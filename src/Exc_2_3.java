import java.io.*;
import java.util.Scanner;

public class Exc_2_3 {
    static int N;
    static int[] arr;
    public static void main(String[] argv) {

        try (Scanner scanner = new Scanner(new File("input.txt"));
             FileWriter writer = new FileWriter("output.txt");) {
            N = scanner.nextInt();
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = i + 1;
            }
            antiQuickSort(0,arr.length-1);
            StringBuilder answer = new StringBuilder();
            for (int i = 0; i <N ; i++) {
                answer.append(arr[i]).append(" ");
            }
            writer.write(String.valueOf(answer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void antiQuickSort(int l, int r) {
        if(l<r) {
            for (int i = 0; i < N; i++) {
                int temp = arr[i];
                arr[i] = arr[i / 2];
                arr[i / 2] = temp;
            }
            for (int i = 1; i < N; i++) {
                if(arr[i] ==  1){
                    int v = arr[i];
                    arr[i]=arr[0];
                    arr[0]=v;
                }
            }
        }
    }
}


