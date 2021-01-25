import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class Solution {

    private static final int toInt(String s) {
        return Integer.parseInt(s);
    }

    // private static final int findClosest ()

    public static void main (String[] args) {
        int fileIdx = Integer.parseInt(args[0]);
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            String[] header = s.nextLine().split(" ");
            int lines = toInt(header[0]);
            int start = toInt(header[1]);
            int end = toInt(header[2]);
            boolean[] hasSpot = new boolean[end - start];
            boolean[] noSpot = new boolean[end - start];
            boolean[] existingCows = new boolean[end - start];
            for (int i = 0; i < lines; i++) {
                header = s.nextLine().split(" ");
                existingCows[toInt(header[1])] = true;
                if (header[0].equals("NS")) {
                    noSpot[toInt(header[1])] = true;
                }
                else if (header[0].equals("S")) {
                    hasSpot[toInt(header[1])] = true;
                }
            }
            int ct = 0;
            int dist = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                for (int j = 0; j < existingCows.length; j++) {
                    dist = Integer.min(dist, Math.abs(i - j));
                }
                if ((i + dist < lines && hasSpot[i + dist]) || (i - dist >= 0 && hasSpot[i - dist])) {
                    ct++;
                }
            }
            s.close();
            System.out.println("Result: " + ct);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
