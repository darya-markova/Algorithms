package transposition;

//итеративная генерация перестановок
//каждая следующая лексикографически больше предыдущей
public class Task1 {
    private int[] transposition;
    private int size;

    public Task1(int n) {
        this.size = n;
        this.transposition = new int[n];

        for(int i=0; i < size; i++) {
            transposition[i] = i + 1; //стартовое значение перестановки
        }
    }

    private void swap(int i, int j) {
        int temp = transposition[i];
        transposition[i] = transposition[j];
        transposition[j] = temp;
    }

    private void print() {
        for(int i=0; i < size; i++) {
            System.out.print(transposition[i] + " ");
        }
        System.out.println();
    }

    public void generate() {
        print();

        for (int i = 1; i < count(); i++) {
            generateNext();
        }
    }

    private int count() {
        int r = 1;

        for(int i = 1; i <= size; i++) {
            r *= i;
        }
        return r;
    }

    private void generateNext() {
        int i = size - 1, j = size - 1;

        //находим "скачок"
        while(i > 1 && transposition[i] < transposition[i-1]) {
          i--;
        }

        //находим первый элемента с конца хвоста, больший значения элемента i - 1
        while(j > 1 && transposition[j] < transposition[i - 1]) {
            j--;
        }

        swap(i - 1, j);

        //переставляем элементы хвоста в порядке возрастания
        for (j = 0; j < (size - i + 1) / 2; j++) {
            swap(i+j, size - 1 - j);
        }

        print();
    }
}
