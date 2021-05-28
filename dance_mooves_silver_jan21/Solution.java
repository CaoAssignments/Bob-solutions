import java.util.*;

public class Solution {
    private static final int toInt (String s) {
        return Integer.parseInt(s);
    }

    private static final boolean ok (int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) return false;
        }
        return true;
    }

    public static void main (String[] args) {
        // read input
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        int n = toInt(line.split(" ")[0]);
        int k = toInt(line.split(" ")[1]);

        // make a set for each cow to track locs it's been to
        // their indices start at 1, so +1 to avoid off by one errors
        HashSet[] cows = new HashSet[n + 1];
        int[] cowLocs = new int[n + 1];
        for (int i = 0; i < cows.length; i++) {
            cows[i] = new HashSet<Integer>();
            cows[i].add(Integer.valueOf(i));
            cowLocs[i] = i;
        }

        // tmp vars used to perform swaps in arrays
        int fst = -1;
        int snd = -1;
        int tmp = -1;
        HashSet tmpSet = null;

        // all swaps
        ArrayList lines = new ArrayList<String>();

        // deplete all lines in Scanner
        for (int i = 0; i < k; i++) {
            line = s.nextLine();
            lines.add(line);
            fst = toInt(line.split(" ")[0]);
            snd = toInt(line.split(" ")[1]);

            // swap cowSet
            tmpSet = cows[fst];
            cows[fst] = cows[snd];
            cows[snd] = tmpSet;

            // swap cowLoc
            tmp = cowLocs[fst];
            cowLocs[fst] = cowLocs[snd];
            cowLocs[snd] = tmp;

            // add each other to their set of "been to" sets (no duplicate)
            cows[fst].add(Integer.valueOf(snd));
            cows[snd].add(Integer.valueOf(fst));
        }
        s.close();

        Iterator<String> itr = lines.iterator();
        // simulate until it's back in original state
        while (!ok(cowLocs)) {
            if (!itr.hasNext()) {
                itr = lines.iterator(); // go back to start
            }
            line = itr.next();
            fst = toInt(line.split(" ")[0]);
            snd = toInt(line.split(" ")[1]);

            // swap cowSet
            tmpSet = cows[fst];
            cows[fst] = cows[snd];
            cows[snd] = tmpSet;

            // swap cowLoc
            tmp = cowLocs[fst];
            cowLocs[fst] = cowLocs[snd];
            cowLocs[snd] = tmp;

            // add each other to their set of "been to" sets (no duplicate)
            cows[fst].add(Integer.valueOf(snd));
            cows[snd].add(Integer.valueOf(fst));
        }

        // print results
        for (int i = 1; i < cows.length; i++) {
            System.out.println(cows[i].size());
        }
    }
}
