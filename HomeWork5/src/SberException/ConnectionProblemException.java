package SberException;

import java.io.IOException;

public class ConnectionProblemException extends IOException {
    @Override
    public String getMessage() {
        return "Проблемы при подключении к серверу";
    }
}