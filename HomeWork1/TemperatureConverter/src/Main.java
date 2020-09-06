import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите температуру в цельсиях");
        double temperature = scanner.nextDouble();
        double kelven = temperature+273.15;
        double farenget = 1.8 * temperature + 32;
        double reomura = 0.8 * temperature;
        System.out.println("В кельвинах = " + kelven);
        System.out.println("В кельвинах = " + farenget);
        System.out.println("Градус Реомюра = " + reomura);
    }
}
