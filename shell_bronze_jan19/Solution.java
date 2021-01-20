import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    public static void main (String[] args) {
        int fileIdx = Integer.parseInt(args[0]);
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            String cur = s.nextLine();
            String[] swaps = new String[Integer.parseInt(cur)];
            for (int i = 0; i < swaps.length; i++) {
                swaps[i] = s.nextLine();
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
