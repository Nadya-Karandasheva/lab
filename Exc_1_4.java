import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_1_4 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("input.txt"));
            FileWriter writer = new FileWriter("output.txt");){
            int N = Integer.parseInt(scanner.nextLine());
            double[] arr= new double[N];
            int[] order = new int[N];
            String[] string = scanner.nextLine().split(" ");
            int i = 0;
            for(int j = 0; j< string.length; j++ ){
                arr[j] = Double.parseDouble(string[j]);
                order[i] = i+1;
                if(i<=N){i++;}
            }

            for(int p=1;p<N;p++) {
                for (int j = p; j > 0 && arr[j - 1] > arr[j]; j--) {
                    double temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    int num = order[j-1];
                    order[j-1] = order[j];
                    order[j] = num;
                }
            }

            StringBuffer answer = new StringBuffer();
            int medium = N/2 ;
            answer.append(order[0]+" "+ order[medium]+" "+order[N-1]);

            writer.write(String.valueOf(answer));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}