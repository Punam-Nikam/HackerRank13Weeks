//PROBLEM - 64 Sherlock and Anagrams
/*
Problem:
Find the number of pairs of substrings
that are anagrams of each other, means they contain the same characters but in different order.

*/
import java.util.*;

public class SherlockAndAnagram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.next();

        HashMap<String, Integer> map = new HashMap<>();

        // Generate all substrings
        for (int i = 0; i < s.length(); i++) {

            for (int j = i + 1; j <= s.length(); j++) {

                // Current substring
                String sub = s.substring(i, j);

                // Convert to char array
                char[] arr = sub.toCharArray();

                // Sort characters
                Arrays.sort(arr);

                // Sorted substring
                String key = new String(arr);

                // Store frequency
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }

        int pairs = 0;

        // Calculate number of pairs
        for (int freq : map.values()) {

            pairs += freq * (freq - 1) / 2;
        }

        System.out.println("Total Anagram Pairs = " + pairs);

        sc.close();
    }
}
