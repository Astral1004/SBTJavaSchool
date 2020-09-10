import java.io.*;
/* Вывод всех строк в обратном порядке*/

public class ReverseFile {
    public static void main(String[] args) {
        try(BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader("C:/Users/user/Desktop/file/TextReader/src/test.txt"))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                String reverse = new StringBuilder(line).reverse().toString();
                System.out.println(reverse);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
