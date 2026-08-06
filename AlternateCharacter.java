//PROBLEM - 72 // Alternate Character

import java.util.*;

/*
Problem:
Find the longest string containing only
2 alternating characters.
*/

public class AlternateCharacter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string: ");
        String s = sc.next();

        int max = 0;

        // Try every pair of letters
        for (char c1 = 'a'; c1 <= 'z'; c1++) {

            for (char c2 = (char)(c1 + 1); c2 <= 'z'; c2++) {

                StringBuilder temp = new StringBuilder();

                // Keep only these two letters
                for (char ch : s.toCharArray()) {

                    if (ch == c1 || ch == c2)
                        temp.append(ch);
                }

                // Check alternating
                boolean valid = true;

                for (int i = 1; i < temp.length(); i++) {

                    if (temp.charAt(i) == temp.charAt(i - 1)) {
                        valid = false;
                        break;
                    }
                }

                if (valid && temp.length() >= 2)
                    max = Math.max(max, temp.length());
            }
        }

        System.out.println("Maximum Length = " + max);

        sc.close();
    }
}