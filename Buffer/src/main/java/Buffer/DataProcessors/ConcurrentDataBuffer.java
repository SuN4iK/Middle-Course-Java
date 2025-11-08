package Buffer.DataProcessors;

import Buffer.BufferProcessors.DataBuffer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class ConcurrentDataBuffer implements DataBuffer {
    private final List<SensorData> buffer;
    private final int maxSize;
    private final ReentrantLock lock;

    public ConcurrentDataBuffer(int maxSize) {
        this.maxSize = maxSize;
        this.buffer = new ArrayList<>(); // Теперь обычный ArrayList с синхронизацией
        this.lock = new ReentrantLock(true); // Fair lock для честного доступа потоков
    }

    public void add(SensorData data) {
        lock.lock();
        try {
            buffer.add(data);
        } finally {
            lock.unlock();
        }
    }

    public boolean isFull() {
        lock.lock();
        try {
            return buffer.size() >= maxSize;
        } finally {
            lock.unlock();
        }
    }

    public List<SensorData> getAndClear() {
        lock.lock();
        try {
            List<SensorData> copy = new ArrayList<>(buffer);
            buffer.clear();
            return copy;
        } finally {
            lock.unlock();
        }
    }

    public boolean isEmpty() {
        lock.lock();
        try {
            return buffer.isEmpty();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return buffer.size();
        } finally {
            lock.unlock();
        }
    }
    public int getMaxSize() {
        return maxSize;
    }
}
