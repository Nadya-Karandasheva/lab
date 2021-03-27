import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_2_5 {
    static int n = 0;
    static int m = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("input.txt"));
             FileWriter writer = new FileWriter("output.txt");) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            int i = 0;
            while (scanner.hasNext()) {
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int[] quickSort(int[] arr, int left, int right) {
        if (arr.length == 0 || left > right) {
            return arr;
        }
        int temp;
        int key = arr[(left + (right - left)) / 2];
        int i = left;
        int j = right - 1;
        while (i <= j) {
            while (arr[i] < key) {
                i++;
            }
            while (key < arr[j]) {
                j--;
            }

            if (i <= j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (left < j) {
            quickSort(arr, left, j);
        }

        if (i < right) {
            quickSort(arr, i, right);
        }
        return arr;
    }

//    static String answer(int number) {
//        if (number == 1) {
//            return "YES";
//        }
//        for (int i = 0; i < n; i++) {
//
//        }
//    }

}
