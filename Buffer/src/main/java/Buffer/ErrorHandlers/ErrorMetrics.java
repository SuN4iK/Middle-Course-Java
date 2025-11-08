package Buffer.ErrorHandlers;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;

public class ErrorMetrics {
    private final ConcurrentHashMap<String, AtomicLong> errorCounts = new ConcurrentHashMap<>();
    private final AtomicLong totalErrors = new AtomicLong(0);

    public void recordError(String errorType, Exception e) {
        // Увеличиваем счетчик для конкретного типа ошибки
        errorCounts.computeIfAbsent(errorType, k -> new AtomicLong(0))
                .incrementAndGet();

        // Увеличиваем общий счетчик
        totalErrors.incrementAndGet();
    }

    public long getErrorCount(String errorType) {
        AtomicLong count = errorCounts.get(errorType);
        return count != null ? count.get() : 0;
    }

    public long getTotalErrors() {
        return totalErrors.get();
    }

    public void printMetrics() {
        System.out.println("=== Error Metrics ===");
        System.out.println("Total errors: " + totalErrors.get());
        errorCounts.forEach((type, count) ->
                System.out.printf("  %s: %d%n", type, count.get()));
    }
}
