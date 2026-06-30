// PROBLEM - 42 Stable counting sort problem
// problem statement - Given a list of n pairs of integers and strings, sort the pairs in ascending order based on the integer values. If two pairs have the same integer value, maintain their original order in the input list. The first half of the strings should be replaced with a dash ("-") in the output.


import java.io.*;
import java.util.*;

public class StableCountingSort {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        List<List<String>> buckets = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            String[] parts = br.readLine().split(" ");
            int num = Integer.parseInt(parts[0]);
            String word = parts[1];

            if (i < n / 2) {
                word = "-";
            }

            buckets.get(num).add(word);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            for (String s : buckets.get(i)) {
                sb.append(s).append(" ");
            }
        }

        System.out.print(sb.toString().trim());
    }
}