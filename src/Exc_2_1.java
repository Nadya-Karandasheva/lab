import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_2_1 {
    static StringBuilder stringBuilder = new StringBuilder();

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
            int[] res = merge_sort(arr,0,N);
            StringBuffer result = new StringBuffer();
            result.append(stringBuilder);
            for (int j = 0; j < N; j++) {
                result.append(res[j]).append(" ");
            }
            writer.write(String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static int[] merge_sort(int[] a, int l, int r) {
        if ((r-l) == 1){
            return new int[]{a[l]};
        }
        int medium = (r+l)/2;
        int[] arr = merge(merge_sort(a, l,medium),merge_sort(a,medium, r));
        stringBuilder.append(l+1).append(" ").append(r).append(" ").append(arr[0]).append(" ").append(arr[r-l-1]).append('\n');
        return arr;

    }
    private static int[] merge(int[] a, int[] b){
        int[] c = new int[a.length+b.length];
        int i = 0;
        int j =0;
        while (i<a.length || j < b.length){
            for (int k = 0; k < c.length; k++) {
                if(j== b.length || (i<a.length && a[i] <= b[j])){
                    c[k] = a[i];
                    i++;
                }
                else {
                    c[k]= b[j];
                    j++;
                }
            }
        }
        return c;
    }
}

