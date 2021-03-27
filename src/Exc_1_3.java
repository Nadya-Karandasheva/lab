import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_1_3 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("input.txt"));
            FileWriter writer = new FileWriter("output.txt");){
            int N = scanner.nextInt();
            int[][] arr= new int[2][N];
            int i = 0;
            while (scanner.hasNext()){
                arr[1][i] = scanner.nextInt();
                arr[0][i]=i+1;
                if(i<=N){i++;}
            }

            StringBuffer result1 = new StringBuffer();
            result1.append(1).append(" ");

            for(int p=1;p<N;p++) {
                int position=p+1;
                for (int j = p; j > 0 && arr[1][j - 1] > arr[1][j]; j--) {
                    int temp = arr[1][j-1];
                    arr[1][j-1] = arr[1][j];
                    arr[1][j] = temp;
                    position = arr[0][j-1];
                }
                result1.append(position).append(" ");
            }
            
            StringBuffer result2 = new StringBuffer();

            for (int j = 0; j < N ; j++) {
                result2.append(arr[1][j]+" ");
            }
            StringBuffer result = new StringBuffer();
            result.append(result1).append('\n').append(result2);
            writer.write(String.valueOf(result));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}