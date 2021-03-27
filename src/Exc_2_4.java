import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Exc_2_4 {
    static int[] arr;
    static int a;
    static int b;
    static int count=0;
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(new File("input.txt"));
        FileWriter out = new FileWriter("output.txt");
        int N = in.nextInt();
        a = in.nextInt();
        b = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        arr = new int[N];
        int i = 0;
        while (in.hasNext()){
            arr[i] = in.nextInt();
            i++;
        }
        for (int j = 2; j < N ; j++) {
            arr[j]= A*arr[j-2]+B*arr[j-1]+C;
        }
        System.out.println(Arrays.toString(arr));
        quickSort(0,N-1);
        System.out.println(Arrays.toString(arr));
        for (int j = a-1; j < b; j++) {
            out.write(arr[j]+" ");
        }
        out.flush();
        in.close();
    }

    static void quickSort(int l, int r){
        int var = arr[(l+r) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (arr[i] < var) {
                i++;
            }
            while (arr[j] > var) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if(count<1) {
            count++;
            if (l < j) {
                quickSort(l, j);
            }
            if (r > i) {
                quickSort(i, r);
            }
        }
        else{
            if (l < j && check(l,j)) {
                quickSort(l, j);
            }
            if (r > i && check(i,r)) {
                quickSort(i, r);
            }
        }
    }
    static boolean check(int l, int r){
        boolean status = false;
        if((l>=a && l<=b) || (r>=a && r<=b) ){
            status = true;
        }
        return status;
    }
}

