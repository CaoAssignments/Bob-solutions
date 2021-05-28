import java.util.*;
import java.io.*;

public class Solution {
    private static final int toInt (String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        int n = toInt(tokenizer.nextToken());
        int k = toInt(tokenizer.nextToken());
        int[] cows = new int[n + 1];
        List<Integer>[] viewed = new List[n + 1];
        for (int j = 1; j <= n; j++) {
            cows[j] = j;
            viewed[j] = new ArrayList<>();
            viewed[j].add(j);
        }
        for (int t = 1; t <= k; t++) {
            tokenizer = new StringTokenizer(in.readLine());
            int a = toInt(tokenizer.nextToken());
            int b = toInt(tokenizer.nextToken());
            int c = cows[a];
            int d = cows[b];
            cows[a] = d;
            cows[b] = c;
            viewed[cows[a]].add(a);
            viewed[cows[b]].add(b);
        }
        int[] answer = new int[n + 1];
        for (int r = 1; r <= n; r++) {
            if (cows[r] != 0) {
                List<Integer> cycle = new ArrayList<>();
                int j = r;
                while (cows[j] != 0) {
                    cycle.add(j);
                    j = cows[j];
                    cows[cycle.get(cycle.size() - 1)] = 0;
                }
                Set<Integer> viewedHere = new HashSet<>();
                for (int cow : cycle) {
                    viewedHere.addAll(viewed[cow]);
                }
                for (int cow : cycle) {
                    answer[cow] = viewedHere.size();
                }
            }
        }
        StringBuilder out = new StringBuilder();
        for (int j = 1; j <= n; j++) {
            out.append(answer[j]).append('\n');
        }
        System.out.print(out);
    }

    /*
    private static final boolean ok (int swaps, int k, int[] arr) {
        if (swaps % k != 0)
            return false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) return false;
        }

        return true;
    }

    public static void main (String[] args) {
        // read input
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        final int n = toInt(line.split(" ")[0]);
        final int k = toInt(line.split(" ")[1]);

        // track how many swaps have happened
        int swaps = 0;

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

            swaps++;
        }
        s.close();

        Iterator<String> itr = lines.iterator();
        // simulate until it's back in original state
        while (!ok(swaps, k, cowLocs)) {
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

            swaps++;
        }

        // print results
        for (int i = 1; i < cows.length; i++) {
            System.out.println(cows[i].size());
        }
    }
    */
}
