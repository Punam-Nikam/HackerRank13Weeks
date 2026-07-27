//PROBLEM - 55 Sherlock and the Valid String
/*
Problem Statement:
A string is valid if all characters appear the same number of times.
It is also valid if removing exactly one character (one occurrence)
makes all remaining character frequencies equal.
Print "YES" if valid, otherwise print "NO".
*/

import java.util.*;

public class SherlocksValidString {

    // Function to check if all non-zero frequencies are equal
    public static boolean check(int[] freq) {

        int value = 0;

        for (int f : freq) {

            if (f == 0)
                continue;

            if (value == 0)
                value = f;

            else if (value != f)
                return false;
        }

        return true;
    }

    // Function to check string validity
    public static String isValid(String s) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // If already valid
        if (check(freq))
            return "YES";

        // Try removing one occurrence of each character
        for (int i = 0; i < 26; i++) {

            if (freq[i] == 0)
                continue;

            freq[i]--;     // Remove one occurrence

            if (check(freq))
                return "YES";

            freq[i]++;     // Restore frequency
        }

        return "NO";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.next();

        System.out.println("Result: " + isValid(s));

        sc.close();
    }
}