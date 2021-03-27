import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class proctoring_1 {
    public static void main(String[] argv) throws IOException{
        Scanner in = new Scanner(new File("input.txt"));
        FileWriter out = new FileWriter("output.txt");
        String[] str = new String[in.nextInt()];
        int k=0;
        while (in.hasNext()){
            str[k] = String.valueOf(in.next());
            k++;
        }
        Stack<Integer> stack = new Stack<>();
        for (String s : str) {
            if (isNumber(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                Integer var1 = stack.pop();
                Integer var2 = stack.pop();
                switch (s) {
                    case "+":
                        stack.push(var1 + var2);
                        break;
                    case "-":
                        stack.push(var2 - var1);
                        break;
                    case "*":
                        stack.push(var1 * var2);
                        break;
                }
            }
        }
        out.write(String.valueOf(stack.pop()));
        out.flush();
        in.close();
    }

    static boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
