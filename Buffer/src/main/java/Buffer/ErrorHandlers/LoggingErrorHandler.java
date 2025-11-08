package Buffer.ErrorHandlers;

import org.slf4j.Logger;

public class LoggingErrorHandler implements ErrorHandler {
    private final Logger logger;

    public LoggingErrorHandler(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void handleError(String context, Exception e) {
        logger.error("{}: {}", context, e.getMessage(), e);
    }
}
