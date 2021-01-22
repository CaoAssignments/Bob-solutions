import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    public static void main (String[] args) {
        int fileIdx = Integer.parseInt(args[0]);
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            int lines = Integer.parseInt(s.nextLine());
            int prev = Integer.parseInt(s.nextLine().split(" ")[1]);
            int curr;
            int result = 1;
            for (int i = 0; i < lines - 1; i++) {
                curr = Integer.parseInt(s.nextLine().split(" ")[1]);
                if (curr <= prev) {
                    result++;
                }
            }
            s.close();
            System.out.println(result + " groups remain");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
