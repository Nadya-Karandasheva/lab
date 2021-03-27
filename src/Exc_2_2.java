import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_2_2 {
    static long count = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("input.txt"));
             FileWriter writer = new FileWriter("output.txt");) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            int i = 0;
            while (scanner.hasNext()) {
                arr[i] = scanner.nextInt();
                i++;
            }
            merge_sort(arr,0,N);
            writer.write(String.valueOf(count));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    static int[] merge_sort(int[] a, int l, int r) {
        if ((r-l) == 1){
            return new int[]{a[l]};
        }
        int medium = (r+l)/2;
        return merge(merge_sort(a, l,medium),merge_sort(a,medium, r));

    }
    static int[] merge(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int i = 0;
        int j =0;
        int k =0;
        while (i<a.length && j < b.length){
                if(a[i] <= b[j]){
                    c[k] = a[i];
                    i++;
                }
                else {
                    c[k]= b[j];
                    j++;
                    count += a.length-i;
                }
                k++;
        }
        while (i<a.length){
            c[k]=a[i];
            i++;
            k++;
        }
        while (j<b.length){
            c[k] = b[j];
            j++;
            k++;
        }
        return c;
    }
}

