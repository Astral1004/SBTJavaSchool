public class Array {

    private int[] massiv;
    private int count;

    public Array(int razmer) {
        massiv = new int[razmer];
        count = 0;
    }

    public void addElement(int value) {
        massiv[count] = value;
        count++;
    }

    private void zamena(int a, int b) {
        int element = massiv[a];
        massiv[a] = massiv[b];
        massiv[b] = element;
    }

    public void sorterArray() {
        for (int i = count - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (massiv[j] > massiv[j + 1])
                    zamena(j, j + 1);
            }
        }
    }


    public void printElement() {
        for (int i = 0; i < count; i++) {
            System.out.print(massiv[i] + " ");

        }
    }
}


