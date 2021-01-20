/**
 * Author: Bob Zhang
 * CSE 199 Winter 2021 - Shell Game Solution
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    private static final int DIGITS_PER_LINE = 3;
    private static final int LAST_DIGIT_IDX = 2;

    // store data for processing in check()
    private static int[] swap1, swap2, guess;

    /**
     * parse data into int[] for further processing
     * @param fileIdx: range from 1 to 10, corresponding to 10 test cases
     */
    private static void arraylize (int fileIdx) {
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            String cur = s.nextLine();
            String[] nums = new String[DIGITS_PER_LINE];
            swap1 = new int[Integer.parseInt(cur)];
            swap2 = new int[Integer.parseInt(cur)];
            guess = new int[Integer.parseInt(cur)];
            for (int i = 0; i < swap1.length; i++) {
                cur = s.nextLine();
                nums = cur.split(" ");

                // store 3 numbers in respective arrays
                swap1[i] = Integer.parseInt(nums[0]);
                swap2[i] = Integer.parseInt(nums[1]);
                guess[i] = Integer.parseInt(nums[LAST_DIGIT_IDX]);
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * assume target starts at 'starting' index, check all the way through
     * @param starting: assume where the target starts at
     * @return points when target was initially at this index
     */
    private static int check (int starting) {
        int result = 0, curr = starting;
        for (int i = 0; i < swap1.length; i++) {
            if (swap1[i] == curr) curr = swap2[i];
            else if (swap2[i] == curr) curr = swap1[i];
            if (curr == guess[i]) result++;
        }
        return result;
    }

    public static void main (String[] args) {
        int fileIdx = Integer.parseInt(args[0]);
        arraylize(fileIdx);
        int maxPossible = 0;
        for (int i = 1; i <= DIGITS_PER_LINE; i++) {
            maxPossible = Integer.max(maxPossible, check(i));
        }
        System.out.println("Maximum possible points is: " + maxPossible);
    }
}
