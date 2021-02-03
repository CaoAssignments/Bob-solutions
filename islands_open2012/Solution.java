import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Piece {
    int height;
    boolean hasWater;

    public Piece(int height) {
        this.height = height;
        this.hasWater = false;
    }

    public String toString() {
        // return "Height: " + this.height + ", hasWater: " + this.hasWater + ", ok? " + this.ok;
        return this.height + "";
    }
}

class PieceComparator implements Comparator<Piece> {
    public int compare (Piece a, Piece b) {
        return a.height - b.height;
    }
}

public class Solution {

    private static final int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("./" + args[0] + ".in"));
            String in = s.nextLine();
            Piece[] ps = new Piece[toInt(in)];
            for (int i = 0; i < ps.length; i++) {
                ps[i] = new Piece(toInt(s.nextLine()));
            }
            Arrays.sort(ps, new PieceComparator());
            System.out.println(Arrays.toString(ps));
            for (int i = 0; i < ps.length; i++) {
                
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
