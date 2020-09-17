import SberException.UserPinInputException;

public interface PinBaseValidator {
    public default  void validateUserPinInput(String pin) throws UserPinInputException {

        if(pin.length()!=4) throw new UserPinInputException();
        int pd=0;
        try {
            pd = new Integer(pin);
        }
        catch(Exception e){// не получилось привести строку к числу
            throw new UserPinInputException();
        }
    };
}
