import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int razmer = scanner.nextInt();
        Array array = new Array(razmer);
        for (int i = 0; i < razmer; i++) {
            System.out.println("Введите " + i + " элемент массива");
            array.addElement(scanner.nextInt());
        }

        System.out.println("Ваш массив");
        array.printElement();
        System.out.println("Отсорированный массив методом пузырька");
        array.sorterArray();
        array.printElement();
    }
}
