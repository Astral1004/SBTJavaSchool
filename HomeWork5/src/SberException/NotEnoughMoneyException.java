package SberException;

import java.io.IOException;

public class NotEnoughMoneyException extends IOException {
    @Override
        public String getMessage() {
            return "На карте недостаточно денег!";
        }
}
