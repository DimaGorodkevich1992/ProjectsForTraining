package text;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{100, 5000, 0, 0, 0, 0, 0, 0, 0, 1, 2, 5, 3, 56, 98, 40};

        Main.sort(array);
        Arrays.stream(array).forEach(n -> System.out.println(n));
    }

    public static void sort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int a = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = a;
                }
            }
        }
    }
}
