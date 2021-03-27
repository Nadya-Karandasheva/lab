import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exc_1_1 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("input.txt"));
            FileWriter writer = new FileWriter("output.txt");){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = a + b;
            String res = String.valueOf(c);
            writer.write(res);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
