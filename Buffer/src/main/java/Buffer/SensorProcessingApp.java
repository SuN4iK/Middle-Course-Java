package Buffer;

import Buffer.BufferProcessors.BufferStrategy;
import Buffer.BufferProcessors.SizeBasedBufferStrategy;
import Buffer.DataProcessors.*;
import Buffer.ErrorHandlers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SensorProcessingApp {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(SensorProcessingApp.class);
        ErrorMetrics metrics = new ErrorMetrics();

        ConcurrentDataBuffer buffer = new ConcurrentDataBuffer(50);
        DataWriter writer = new ConsoleDataWriter();

        // Создаем стратегию - нужно указать размер буфера
        BufferStrategy strategy = new SizeBasedBufferStrategy();

        // ПРАВИЛЬНО: создаем LoggingErrorHandler
        ErrorHandler errorHandler = new CompositeErrorHandler(
                new LoggingErrorHandler(logger),  // ← ДОБАВИТЬ ЭТОТ КЛАСС
                new MetricsErrorHandler(metrics)
        );

        ConcurrentSensorDataProcessor processor =
                new ConcurrentSensorDataProcessor(buffer, writer, strategy, errorHandler);

        // Запускаем multiple threads, которые отправляют данные
        int threadCount = 5;
        int dataPerThread = 100;

        ExecutorService producerExecutor = Executors.newFixedThreadPool(threadCount);
        CountDownLatch latch = new CountDownLatch(threadCount);

        // Запускаем producer threads
        for (int i = 0; i < threadCount; i++) {
            final int threadId = i;
            producerExecutor.submit(() -> {
                try {
                    for (int j = 0; j < dataPerThread; j++) {
                        SensorData data = new SensorData(
                                System.currentTimeMillis(),
                                Math.random() * 100,
                                "sensor-" + threadId
                        );
                        processor.process(data);
                        Thread.sleep(10); // Имитация работы
                    }
                } catch (Exception e) {
                    errorHandler.handleError("Producer thread error", e);
                } finally {
                    latch.countDown();
                }
            });
        }

        // Ждем завершения всех producer threads
        latch.await();
        producerExecutor.shutdown();

        // Graceful shutdown процессора
        processor.shutdown();

        // Печатаем метрики
        metrics.printMetrics();
    }
}