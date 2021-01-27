import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {

    private static String[][] puzzle;
    private static final String PUZ_CLEAR = ".";
    private static final String PUZ_BLOCK = ".";

    private static final int toInt(String s) {
        return Integer.parseInt(s);
    }

    private static final char chkCrd(int row, int col) {
        if (puzzle[row][col].equals(PUZ_CLEAR) && puzzle[row][col+1].equals(PUZ_CLEAR) && puzzle[row][col+2].equals(PUZ_CLEAR)) {
            puzzle[row][col] = PUZ_BLOCK;
            puzzle[row][col+1] = PUZ_BLOCK;
            puzzle[row][col+2] = PUZ_BLOCK;
            System.out.println((row+1) + " " + (col+1));
            System.out.println((row+1) + " " + ((col+1)+1));
            System.out.println((row+1) + " " + ((col+1)+2));
            return 'r';
        }
        else if (puzzle[row][col].equals(PUZ_CLEAR) && puzzle[row+1][col].equals(PUZ_CLEAR) && puzzle[row+2][col].equals(PUZ_CLEAR)) {
            puzzle[row][col] = PUZ_BLOCK;
            puzzle[row+1][col] = PUZ_BLOCK;
            puzzle[row+2][col] = PUZ_BLOCK;
            System.out.println((row+1) + " " + (col+1));
            System.out.println(((row+1)+1) + " " + (col+1));
            System.out.println(((row+1)+2) + " " + (col+1));
            return 'c';
        }
        return 0;
    }

    public static void main (String[] args) {
        int fileIdx = Integer.parseInt(args[0]);
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            String[] dim = s.nextLine().split(" ");
            puzzle = new String[toInt(dim[0])][toInt(dim[1])];
            String currLine = null;
            int col = 0;
            for (int row = 0; row < puzzle.length; row++) {
                currLine = s.nextLine();
                for (col = 0; col < currLine.length(); col++) {
                    puzzle[row][col] = Character.toString(currLine.charAt(col));
                }
            }
            int ct = 0;
            char check = 0;
            for (int row = 0; row < puzzle.length - 2; row++) {
                // missing check for border / up or left is blocked
                for (col = 0; col < puzzle[row].length - 2; col++) {
                    if (puzzle[row][col].equals("#")) continue;
                    check = chkCrd(row, col);
                    if (check == 'r') {
                        ct += 3;
                    }
                    else if (check != 0) {
                        ct++;
                    }
                }
            }
            s.close();
            System.out.println("Total: " + ct);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
