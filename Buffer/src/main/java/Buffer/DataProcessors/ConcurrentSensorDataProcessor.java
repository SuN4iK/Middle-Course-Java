package Buffer.DataProcessors;

import Buffer.BufferProcessors.BufferStrategy;
import Buffer.BufferProcessors.DataBuffer;
import Buffer.ErrorHandlers.ErrorHandler;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class ConcurrentSensorDataProcessor {
    private final DataBuffer buffer; // ← ИНТЕРФЕЙС!
    private final DataWriter writer;
    private final BufferStrategy strategy;
    private final ErrorHandler errorHandler;
    private final AtomicBoolean isProcessing;
    private final ExecutorService flushExecutor;

    public ConcurrentSensorDataProcessor(DataBuffer buffer, // ← ИНТЕРФЕЙС!
                                         DataWriter writer,
                                         BufferStrategy strategy,
                                         ErrorHandler errorHandler) {
        this.buffer = buffer;
        this.writer = writer;
        this.strategy = strategy;
        this.errorHandler = errorHandler;
        this.isProcessing = new AtomicBoolean(true);
        this.flushExecutor = Executors.newSingleThreadExecutor();
    }

    /**
     * Метод может вызываться из multiple threads одновременно
     */
    public void process(SensorData data) {
        if (!isProcessing.get()) {
            throw new IllegalStateException("Processor is shutting down");
        }

        buffer.add(data);

        if (strategy.shouldFlush(buffer, data) && buffer.size() > 0) {
            asyncFlush();
        }
    }

    /**
     * Асинхронный flush - не блокирует поток, добавляющий данные
     */
    private void asyncFlush() {
        flushExecutor.submit(() -> {
            try {
                flush();
            } catch (Exception e) {
                errorHandler.handleError("Async flush error", e);
            }
        });
    }

    public void flush() {
        if (buffer.isEmpty()) {
            return;
        }

        try {
            List<SensorData> dataToWrite = buffer.getAndClear();
            writer.write(dataToWrite);
            strategy.onFlushSuccess(buffer);

        } catch (Exception e) {
            errorHandler.handleError("Buffer flush error", e);
            strategy.onFlushError(buffer, e);
        }
    }

    /**
     * Graceful shutdown - гарантирует запись всех данных перед завершением
     */
    public void shutdown() {
        isProcessing.set(false);
        flushExecutor.submit(() -> {
            try {
                // Финальный flush оставшихся данных
                flush();
            } finally {
                flushExecutor.shutdown();
            }
        });

        try {
            flushExecutor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            errorHandler.handleError("Shutdown interrupted", e);
        }
    }
}