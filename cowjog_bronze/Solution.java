import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    public static void main (String[] args) {
        int fileIdx = Integer.parseInt(args[0]);
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            int lines = Integer.parseInt(s.nextLine());
            int[] speeds = new int[lines];
            for (int i = 0; i < speeds.length; i++) {
                speeds[i] = Integer.parseInt(s.nextLine().split(" ")[1]);
            }
            int end = speeds[speeds.length - 1];
            int result = 1;
            for (int i = speeds.length - 2; i >= 0; i--) {
                if (speeds[i] <= end) {
                    result++;
                }
                end = Math.min(end, speeds[i]);
            }
            s.close();
            System.out.println(result + " groups remain");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
