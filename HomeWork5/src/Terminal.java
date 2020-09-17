import SberException.*;
import ServerSber.ServerSberAPI;
import ServerSber.TestServerSber;

public interface Terminal extends PinBaseValidator, Runnable {
    enum TerminalStatus {NOAUTHORIZED, AUTHORIZED, SHOWBALANCE, GETMONEY, INSERTMONEY, CLOSECONNECTION}

    public default void run() {
        TerminalStatus terminalStatus = TerminalStatus.NOAUTHORIZED;
        while (terminalStatus != TerminalStatus.CLOSECONNECTION) {
            switch (terminalStatus) {
                case NOAUTHORIZED:
                    terminalStatus = Authentification();
                    break;
                case AUTHORIZED:
                    terminalStatus=showLogicScreen();
                    break;
                case SHOWBALANCE:
                    Double balance = getServer().getUserBalance(getServer().getToken());
                    terminalStatus = TerminalStatus.AUTHORIZED;
                    break;
                case GETMONEY:
                    showUserMessage("Введите сумму!");
                    Integer cash = InputCashCnt();
                    getMoney(cash);
                    terminalStatus=TerminalStatus.AUTHORIZED;
                    break;
                case INSERTMONEY:
                    showUserMessage("Внесите деньги");
                    Integer cashIn=InputCashCnt();
                    insertMoney(cashIn);
                    terminalStatus=TerminalStatus.AUTHORIZED;

            }
            Thread.yield();
        }
    }



    public default void startParallelTerminalThread() {
        Thread t = new Thread(this);
        t.start();
    }

    public default TerminalStatus Authentification() {
        showStartScreen();
        String readPin = readPinCode();

        try {
            this.validateUserPinInput(readPin);
        } catch (UserPinInputException e) {
            showUserMessage(e.getMessage());
            return TerminalStatus.NOAUTHORIZED;
        }
        //Aутентификация на сервере
        try {
            getServer().validateUserPinOnServer(getUserId(), readPin);
        } catch (PinValidationOnServerException e) {//ошибка ввода пина
            showUserMessage(e.getMessage());
            return TerminalStatus.NOAUTHORIZED;
        } catch (AccountIsLockedException e) {//аккаунт заблокирован
            showUserMessage(e.getMessage());
            return TerminalStatus.NOAUTHORIZED;
        }
        return TerminalStatus.AUTHORIZED;
    }

    public default TerminalStatus getMoney(Integer cash){
        try {
            if(cash%100 == 0){
                getServer().getCashFromServerToUser(getServer().getToken(),cash);
                showUserMessage("Ожидайте выдачи денег из терминала");
                showUserMessage("Ваш баланс равен " +getServer().getUserBalance(getServer().getToken()));
            }else{
                showUserMessage("Сумма не кратна 100");
            }
        } catch (NotEnoughMoneyException e) {
            showUserMessage("Недостаточно денег на Вашем счету");
            return TerminalStatus.AUTHORIZED;
        } catch (ConnectionProblemException e) {
            showUserMessage("Возникли проблемы с сетью");
            return TerminalStatus.AUTHORIZED;
        }
        return TerminalStatus.AUTHORIZED;

    }
    public default TerminalStatus insertMoney(Integer cashIn){
        try{
            if(cashIn%100 == 0){
                getServer().receiveCashFromUserToServer(getServer().getToken(),cashIn);
                showUserMessage("Ваш баланс успешно пополнен на сумму "+ cashIn+" .Ваш баланс равен " +getServer().getUserBalance(getServer().getToken()));
            }else{
                showUserMessage("Сумма не кратна 100");
            }
        } catch (InsertMoneyException e) {
            showUserMessage("Ошибка при вводе денег");
        } catch (ConnectionProblemException e) {
            showUserMessage("Возникли проблемы с сетью");
        }

        return TerminalStatus.AUTHORIZED;
    }


    Long getUserId();

    ServerSberAPI getServer();
    public String readPinCode();
    public void showStartScreen();
    public void showUserMessage(String text);
    public TerminalStatus showLogicScreen();
    public int InputCashCnt();
}
