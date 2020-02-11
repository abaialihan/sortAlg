import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        minMaxAvg();
        bubbleSort();
        findCatchNumbers();
        selectedSort();
        insertionSort();
        shuttleSort();
    }

    public static void minMaxAvg() {
        int n = 100;
        double[] array = new double[n];

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }

        double max = array[0];
        double min = array[0];
        double avg = 0;

        for (int i = 0; i < array.length; i++) {

            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];

            avg += array[i] / array.length;
        }

        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("avg = " + avg);
    }

    public static void bubbleSort(){

        int[] array = {10, 2, 5, 8, 9, 3, 25, 41, 6};
        boolean needIteration = true;

        System.out.println(Arrays.toString(array));

        while (needIteration) {
            needIteration = false;

            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    swap(array, i, i - 1);
                    needIteration = true;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static void swap(int[] array, int ind1, int ind2){
        int tmp = array[ind1];
        array[ind1] = array[ind2];
        array[ind2] = tmp;
    }

    public static void findCatchNumbers(){
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;

            for (int j = 2; j < i; j++) {

                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                System.out.print(i + " ");

        }
    }

    public static void selectedSort() {
        int[] array = {10, 2, 5, 8, 9, 3, 25, 41, 6};

        System.out.println(Arrays.toString(array));

        for (int left = 0; left < array.length; left++) {
            int minInd = left;

            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minInd])
                    minInd = i;

            }
            swap(array, left, minInd);
        }
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(){
        int[] array = {10, 2, 5, 8, 9, 3, 25, 41, 6};

        System.out.println(Arrays.toString(array));

        for (int left = 0; left < array.length ; left++) {
            //вытаскиваем значение элемента
            int value = array[left];
            //пересещяемся по элементам, которые перед вытащенным элементам
            int i = left - 1;

            for (; i >= 0 ; i--) {
                //если вытащили значение меньше, передвигаем большой элемент дальше
                if (value < array[i]){
                    array[i + 1] = array[i];
                }else {
                    //если вытащенный элемент больше останавливаемся
                    break;
                }
            }
            //в освободившее место вставляем вытащенное значение
            array[i + 1] = value;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void shuttleSort(){
        int[] array = {10, 2, 5, 8, 9, 3, 25, 41, 6};

        System.out.println(Arrays.toString(array));

        for (int i = 1; i <array.length ; i++) {

            if (array[i] < array[i - 1]){
                swap(array, i, i - 1);

                for (int j = i - 1; (j - 1) >= 0 ; j--) {
                    if (array[j] < array[j - 1]){
                        swap(array, j, j - 1);
                    }else {
                        break;
                    }
                }
            }

        }
        System.out.println(Arrays.toString(array));
    }
}
