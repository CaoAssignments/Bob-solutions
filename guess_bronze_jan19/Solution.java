/**
 * Author: Bob Zhang
 * CSE 199 Winter 2021 - Animal Guess Solution
 * Concepts involved for this challenge: File I/O, cross array reference (or Map & Set for better performance)
 * Thoughts to have in mind: the maximum amount of "YES" is the same as the maximum amount of common characteristics for any pair of animals
 */

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solution {
    private static final int SECOND_IN_ARRAY = 2;

    private static void mapify (int fileIdx, HashMap<String, HashSet<String>> characs) {
        try {
            Scanner s = new Scanner(new File("./" + fileIdx + ".in"));
            String cur = s.nextLine();
            String[] splitted = null;
            String currName = null;
            int iters = Integer.parseInt(cur);
            for (int i = 0; i < iters; i++) {
                splitted = s.nextLine().split(" ");
                currName = splitted[0];
                characs.put(currName, new HashSet<String>());
                for (int j = SECOND_IN_ARRAY; j < splitted.length; j++) {
                    characs.get(currName).add(splitted[j]);
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main (String[] args) {
        HashMap<String, HashSet<String>> characs = new HashMap<String, HashSet<String>>();
        mapify(Integer.parseInt(args[0]), characs);
        Object[] keys = characs.keySet().toArray();
        int result = 0;
        int curr = 0;
        for (int i = 0; i < keys.length; i++) {
            for (int j = i + 1; j < keys.length; j++) {
                HashSet<String> seti = characs.get(keys[i]);
                HashSet<String> setj = characs.get(keys[j]);
                // can simply use the retainAll() method from HashSet, didn't realize from earlier
                for (String s : seti) {
                    if (setj.contains(s)) {
                        curr += 1;
                    }
                }
            }
            if (curr > result) result = curr;
        }
        System.out.println("Answer: " + (result + 1));
    }
}
