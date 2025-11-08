package Buffer.ErrorHandlers;

public class MetricsErrorHandler implements ErrorHandler {
    private final ErrorMetrics metrics;

    public MetricsErrorHandler(ErrorMetrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public void handleError(String context, Exception e) {
        metrics.recordError(context, e);
        // Можно комбинировать с логированием
    }
}
