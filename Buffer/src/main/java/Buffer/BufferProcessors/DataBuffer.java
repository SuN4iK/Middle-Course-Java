package Buffer.BufferProcessors;

import Buffer.DataProcessors.SensorData;

import java.util.List;

public interface DataBuffer {
    void add(SensorData data);
    boolean isFull();
    List<SensorData> getAndClear();
    boolean isEmpty();
    int size();
    int getMaxSize();
}
