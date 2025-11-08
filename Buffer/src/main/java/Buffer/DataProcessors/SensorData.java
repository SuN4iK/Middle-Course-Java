package Buffer.DataProcessors;

import java.util.Objects;

public class SensorData {
    private final long timestamp;
    private final double value;
    private final String sensorId;

    public SensorData(long timestamp, double value, String sensorId) {
        this.timestamp = timestamp;
        this.value = value;
        this.sensorId = sensorId;
    }

    // Геттеры (без сеттеров для immutability)
    public long getTimestamp() { return timestamp; }
    public double getValue() { return value; }
    public String getSensorId() { return sensorId; }

    @Override
    public String toString() {
        return String.format("SensorData{sensorId='%s', timestamp=%d, value=%.2f}",
                sensorId, timestamp, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SensorData)) return false;
        SensorData that = (SensorData) o;
        return timestamp == that.timestamp &&
                Double.compare(that.value, value) == 0 &&
                Objects.equals(sensorId, that.sensorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, value, sensorId);
    }
}
