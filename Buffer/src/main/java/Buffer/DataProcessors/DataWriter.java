package Buffer.DataProcessors;

import java.util.List;

public interface DataWriter {
    void write(List<SensorData> data) throws Exception;
}
