import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/*Вывод на экран списка различных слов файла, отсортированный по возрастанию их длины*/

public class SortedByFile {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(bvc);

        try {
            BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader fileReader = new BufferedReader(new FileReader("C:/Users/user/IdeaProjects/untitled2/src/test.txt"));

            while (fileReader.ready()) {
                String string = fileReader.readLine();
                String[] words = string.split(" ");

                for (String word : words) {
                    if (!map.containsKey(word)) {
                        map.put(word, 0);
                    }
                    map.put(word, map.get(word)+1);
                }
            }
            sorted_map.putAll(map);
            System.out.println("results: " + sorted_map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;

    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }

    public int compare(String a, String b) {
        if (a.length() <= b.length()) {
            return -1;
        } else {
            return 1;
        }
    }
}
