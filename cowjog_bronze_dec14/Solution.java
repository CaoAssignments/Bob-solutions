import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main (String[] args) {
        // int fileIdx = Integer.parseInt(args[0]);
        int result = 0;
        try {
            // Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            Scanner s = new Scanner(new File("cowjog.in"));
            int lines = Integer.parseInt(s.nextLine());
            int[] speeds = new int[lines];
            for (int i = 0; i < speeds.length; i++) {
                speeds[i] = Integer.parseInt(s.nextLine().split(" ")[1]);
            }
            int end = speeds[speeds.length - 1];
            result = 1;
            for (int i = speeds.length - 2; i >= 0; i--) {
                if (speeds[i] <= end) {
                    result++;
                }
                end = Math.min(end, speeds[i]);
            }
            s.close();
            // System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileWriter out = new FileWriter("cowjog.out");
            out.write(result + "");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
