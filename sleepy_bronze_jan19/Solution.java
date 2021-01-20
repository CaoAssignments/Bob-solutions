import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {

    private static int[] arraylize (String fileIdx) {
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            String cur = s.nextLine();
            int[] nums = new int[Integer.parseInt(cur)];
            cur = s.nextLine();
            String[] cows = cur.split(" ");
            for (int i = 0; i < cows.length; i++) {
                nums[i] = Integer.parseInt(cows[i]);
            }
            return nums;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new int[0];
        }
    }

    private static int solve (int[] numCows) {
        int result = numCows.length - 1;
        for (int i = numCows.length - 2; i >= 0; i--) {
            if (numCows[i] < numCows[i + 1]) {
                result = i;
            }
            else break;
        }
        return result;
    }

    public static void main (String[] args) {
        String fileIdx = args[0];
        int[] numCows = arraylize(fileIdx);
        for (int i: numCows) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("Time steps requried: " + solve(numCows));
    }
}
