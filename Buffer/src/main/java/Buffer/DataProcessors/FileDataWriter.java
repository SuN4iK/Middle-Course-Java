package Buffer.DataProcessors;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class FileDataWriter implements DataWriter {
    private final String filename;

    public FileDataWriter(String filename) {
        this.filename = filename;
    }

    @Override
    public void write(List<SensorData> data) throws IOException {
        // РЕАЛИЗОВАТЬ запись в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            List<SensorData> sorted = data.stream()
                    .sorted(Comparator.comparingLong(SensorData::getTimestamp))
                    .toList();

            for (SensorData sensorData : sorted) {
                writer.write(String.format("%d,%.2f,%s%n",
                        sensorData.getTimestamp(),
                        sensorData.getValue(),
                        sensorData.getSensorId()));
            }
        }
    }
}
