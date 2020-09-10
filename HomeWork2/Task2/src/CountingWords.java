import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*Подсчет количества строк и слов в файле*/

public class CountingWords {
    public static void main(String[] args) throws FileNotFoundException {
        String filename = "C:/Users/user/Desktop/file/TextReader/src/test.txt";
        getWordCount(filename);
    }

    public static void getWordCount(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int words = 0;
        int lines = 0;

        while (scanner.hasNextLine()) {
            lines++;
            String[] array = scanner.nextLine().split(" ");
            words = words + array.length;
        }

        System.out.println("Колличество слов в файле =  " + words);
        System.out.println("Колличество строк в файле = " + lines);
        scanner.close();
    }
}
