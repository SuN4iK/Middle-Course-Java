package Buffer.BufferProcessors;

import Buffer.DataProcessors.SensorData;

public interface BufferStrategy {
    boolean shouldFlush(DataBuffer buffer, SensorData newData);
    void onFlushSuccess(DataBuffer buffer);
    void onFlushError(DataBuffer buffer, Exception e);
}