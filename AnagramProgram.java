import java.util.Scanner;
/// WEEK TEST - 4 

/*
Problem Description:
Given a string, divide it into two equal halves.
Find the minimum number of character changes required in the first half
to make it an anagram of the second half.

If the string length is odd, return -1.

Example:
Input:
aaabbb

First Half  = "aaa"
Second Half = "bbb"

We need to change all 3 'a' characters to 'b'.
Output: 3
*/

public class AnagramProgram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int q = sc.nextInt();

        while (q-- > 0) {

            String s = sc.next();

            // If length is odd, anagram is impossible
            if (s.length() % 2 != 0) {
                System.out.println(-1);
                continue;
            }

            // Split string into two halves
            String s1 = s.substring(0, s.length() / 2);
            String s2 = s.substring(s.length() / 2);

            int count = 0;

            // Check each character of first half
            for (int i = 0; i < s1.length(); i++) {

                char ch = s1.charAt(i);

                // Find character in second half
                int pos = s2.indexOf(ch);

                if (pos != -1) {

                    // Remove matched character from second half
                    s2 = s2.substring(0, pos)
                            + s2.substring(pos + 1);

                } else {

                    // Character not found, change required
                    count++;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}