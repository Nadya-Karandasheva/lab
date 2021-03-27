import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_1_2 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("input.txt"));
            FileWriter writer = new FileWriter("output.txt");){
            long a = scanner.nextInt();
            long b = scanner.nextInt();
            long c = a + b*b;
            String res = String.valueOf(c);
            writer.write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
