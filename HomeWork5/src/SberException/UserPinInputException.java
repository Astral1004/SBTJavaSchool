package SberException;

import java.io.IOException;

public class UserPinInputException extends IOException {
    @Override
    public String getMessage() {
        return "PIN код введен не верно";
    }
}

