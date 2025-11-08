package Buffer.DataProcessors;

import java.util.Comparator;
import java.util.List;

public class ConsoleDataWriter implements DataWriter {

    /**
     * @param data
     * @throws Exception
     */
    @Override
    public void write(List<SensorData> data) {
        List<SensorData> sorted = data.stream()
                .sorted(Comparator.comparingLong(SensorData::getTimestamp))
                .toList();

        sorted.forEach(d ->
                System.out.printf("Time: %d, Value: %.2f%n",
                        d.getTimestamp(), d.getValue()));

    }
}
