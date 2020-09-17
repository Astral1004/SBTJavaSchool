package SberException;

import java.io.IOException;

public class AccountIsLockedException extends IOException {
    String timeToUnlock="Unlock time undefined";
    public AccountIsLockedException(String message) {
        this.timeToUnlock=message;
    }

    @Override
    public String getMessage() {
        return this.timeToUnlock;
    }
}
