package SberException;

import java.io.IOException;

public class PinValidationOnServerException extends IOException {
    @Override
    public String getMessage() {
        return "Ошибка при про проверке PIN кода на стороне сервера";
    }
}
