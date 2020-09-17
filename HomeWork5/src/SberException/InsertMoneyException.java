package SberException;

import java.io.IOException;

public class InsertMoneyException extends IOException {
    @Override
    public String getMessage() {
        return "Ошибка поплнения баланса";
    }
}