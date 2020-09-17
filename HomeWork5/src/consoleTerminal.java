import ServerSber.ServerSberAPI;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class consoleTerminal implements Terminal {
    private ServerSberAPI server;
    private Integer UserId;
    public consoleTerminal(Integer UserId, ServerSberAPI serverApi) {
        server=serverApi;
        this.UserId=UserId;
        this.startParallelTerminalThread();
    }

    @Override
    public int InputCashCnt() {
        System.out.println("Введите сумму кратную 100 руб.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    @Override
    public Long getUserId() {
        return 1234578910L;
    }

    @Override
    public ServerSberAPI getServer() {
        return server;
    }

    public String readPinCode() {
        System.out.println("Введите пинкод: ");
        Scanner scanner=new Scanner(System.in);
        return scanner.nextLine();
    }

   public void showStartScreen(){
        System.out.println("Привет, это терминал!");
        System.out.println("Пожалуйста введите пин-код! ");
   }

    @Override
    public void showUserMessage(String text) {
        System.out.println(text);
    }

    @Override
    public TerminalStatus showLogicScreen() {
        System.out.println("/******************************************************/");
        System.out.println("Меню выбора операций, введите цифру");
        System.out.println("1 - Узнать баланс");
        System.out.println("2 - Снять деньги");
        System.out.println("3 - Внести деньги");
        System.out.println("4 - Завершить работу");
        System.out.println("/******************************************************/");
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        TerminalStatus state=TerminalStatus.NOAUTHORIZED;
        if(num==1) state=TerminalStatus.SHOWBALANCE;
        if(num==2) state=TerminalStatus.GETMONEY;
        if(num==3) state=TerminalStatus.INSERTMONEY;
        if(num==4) state=TerminalStatus.CLOSECONNECTION;
        return state;

    }

}
