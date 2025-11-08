package Buffer.BufferProcessors;

import Buffer.DataProcessors.SensorData;

public class SizeBasedBufferStrategy implements BufferStrategy {

    @Override
    public boolean shouldFlush(DataBuffer buffer, SensorData newData) {
        return buffer.isFull(); // Просто делегируем буферу
    }

    @Override
    public void onFlushSuccess(DataBuffer buffer) {
        // Можно добавить логирование при необходимости
    }

    @Override
    public void onFlushError(DataBuffer buffer, Exception e) {
        // Можно добавить логирование
    }
}