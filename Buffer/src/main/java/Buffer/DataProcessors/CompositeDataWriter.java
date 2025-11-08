package Buffer.DataProcessors;

import java.util.List;

public class CompositeDataWriter implements DataWriter {
    private final List<DataWriter> writers;

    public CompositeDataWriter(List<DataWriter> writers) {
        this.writers = writers;
    }


    /**
     * @param data
     * @throws Exception
     */
    @Override
    public void write(List<SensorData> data) throws Exception {
        Exception lastException = null;

        for (DataWriter writer : writers) {
            try {
                writer.write(data);
            } catch (Exception e) {
                lastException = e;
                // Продолжаем с другими writer'ами
            }
        }

        if (lastException != null) {
            throw lastException;
        }
    }
}
