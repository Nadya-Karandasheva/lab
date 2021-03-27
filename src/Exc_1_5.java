import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_1_5 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("input.txt"));
            FileWriter writer = new FileWriter("output.txt");){
            int N = scanner.nextInt();
            int[] arr= new int[N];
            int i = 0;
            while (scanner.hasNext()){
                arr[i] = scanner.nextInt();
                i++;
            }
            for (int j = 0; j < N ; j++) {
                int min = arr[j];
                int ind_min = j;
                for (int k=j+1 ; k < N ; k++) {
                    if(arr[k]<min){
                        min = arr[k];
                        ind_min = k;
                    }
                }
                if(ind_min !=j){
                    int temp = arr[ind_min];
                    arr[ind_min] = arr[j];
                    arr[j] = temp;
                    writer.write("Swap elements at indices "+ (j+1) +" and "+ (ind_min+1)+"."+"\n");
                }
            }
            writer.write("No more swaps needed."+"\n");
            for (int j = 0; j < N ; j++) {
                writer.write(arr[j] +" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}