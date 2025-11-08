package Buffer.BufferProcessors;

import Buffer.DataProcessors.SensorData;

public class TimeBasedBufferStrategy implements BufferStrategy{
    private final long flushIntervalMs;
    private long lastFlushTime;

    public TimeBasedBufferStrategy(long flushIntervalMs) {
        this.flushIntervalMs = flushIntervalMs;
        this.lastFlushTime = System.currentTimeMillis();
    }

    @Override
    public boolean shouldFlush(DataBuffer buffer, SensorData newData) { // ← DataBuffer вместо ConcurrentDataBuffer
        boolean byTime = (System.currentTimeMillis() - lastFlushTime) >= flushIntervalMs;
        boolean bySize = buffer.isFull();
        return bySize || byTime;
    }

    @Override
    public void onFlushSuccess(DataBuffer buffer) { // ← DataBuffer вместо ConcurrentDataBuffer
        lastFlushTime = System.currentTimeMillis();
    }

    @Override
    public void onFlushError(DataBuffer buffer, Exception e) { // ← DataBuffer вместо ConcurrentDataBuffer
        // Оставляем пустым или добавляем базовую логику
    }
}