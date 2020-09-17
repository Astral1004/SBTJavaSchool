import ServerSber.ServerSberAPI;
import ServerSber.TestServerSber;

public class Main {
    public static void main(String[] args) {
        Terminal st= new consoleTerminal(1234, new TestServerSber());
    }
}