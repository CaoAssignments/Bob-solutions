import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("./" + args[0] + ".in"));
            String in = s.nextLine();
            int inDec = 0;
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i) == '0') continue;
                inDec += Math.pow(2, in.length() - i - 1);
            }
            System.out.println("orig: " + in + ", in decimal: " + inDec);
            int decResult = inDec * 17;
            System.out.println("result: " + Integer.toBinaryString(decResult));
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
