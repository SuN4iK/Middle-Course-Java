package Buffer.ErrorHandlers;

import java.util.Arrays;
import java.util.List;

public class CompositeErrorHandler implements ErrorHandler {
    private final List<ErrorHandler> handlers;

    public CompositeErrorHandler(ErrorHandler... handlers) {
        this.handlers = Arrays.asList(handlers);
    }

    @Override
    public void handleError(String context, Exception e) {
        for (ErrorHandler handler : handlers) {
            try {
                handler.handleError(context, e);
            } catch (Exception handlerException) {
                // Логируем ошибку в обработчике ошибок, но не прерываем выполнение
                System.err.println("Error in error handler: " + handlerException.getMessage());
            }
        }
    }
}
