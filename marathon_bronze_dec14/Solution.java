import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    private static int[][] arraylize (int fileIdx) {
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            String cur = s.nextLine();
            String[] splitted = null;
            int[][] nums = new int[Integer.parseInt(cur)][2];
            for (int i = 0; i < nums.length; i++) {
                cur = s.nextLine();
                splitted = cur.split(" ");
                nums[i][0] = Integer.parseInt(splitted[0]);
                nums[i][1] = Integer.parseInt(splitted[1]);
            }
            s.close();
            return nums;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new int[0][0];
        }
    }

    private static int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    private static int totalDistance (int[][] checkpoints) {
        int result = 0;
        for (int i = 0; i < checkpoints.length - 1; i++) {
            result += manhattanDistance(checkpoints[i], checkpoints[i + 1]);
        }
        return result;
    }

    private static int skippedDistance (int[][] checkpoints, int rawDistance) {
        int curr, skipi;
        int maxReduction = 0;
        for (int i = 1; i < checkpoints.length - 1; i++) {
            curr = manhattanDistance(checkpoints[i], checkpoints[i - 1]) + manhattanDistance(checkpoints[i], checkpoints[i + 1]);
            skipi = manhattanDistance(checkpoints[i - 1], checkpoints[i + 1]);
            System.out.println("Skipping " + Arrays.toString(checkpoints[i]) + " reduces distance by " + (curr - skipi));
            maxReduction = Math.max(maxReduction, curr - skipi);
        }
        return (rawDistance - maxReduction);
    }

    public static void main (String[] args) {
        int[][] checkpoints = arraylize(Integer.parseInt(args[0]));
        int raw = totalDistance(checkpoints);
        System.out.println("Before skip total: " + raw);
        System.out.println(skippedDistance(checkpoints, raw));
    }
}