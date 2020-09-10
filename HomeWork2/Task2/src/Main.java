import java.io.*;
import java.util.*;
/*Подсчитать и вывести на экран сколько раз каждое слово встречается в файле*/
public class Main {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader("C:/Users/user/Desktop/file/TextReader/src/test.txt"));
            HashMap<String, Integer> wordToCount = new HashMap<>();
            while (fileReader.ready()){
                String string = fileReader.readLine();
                String[] words = string.trim().split(" ");
                int count = 0;
                for (String word : words)
                {
                    if (!wordToCount.containsKey(word))
                    {
                        wordToCount.put(word, 0);
                        count++;
                    }
                    wordToCount.put(word, wordToCount.get(word) + 1);
                }

            }
            for (String word : wordToCount.keySet())
            {
                System.out.println(word + " " + wordToCount.get(word));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}