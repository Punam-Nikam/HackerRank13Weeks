// PROBLEM -31 SEPARATE THE NUMBERS

// Given a numeric string, determine whether it can be split into a sequence of two or more consecutive increasing numbers 
// without leading zeroes. 
// If possible, print YES along with the first number; otherwise print NO.

import java.util.*;

class Result {

    public static void separateNumbers(String s) {

        if (s.length() == 1) {
            System.out.println("NO");
            return;
        }

        for (int i = 1; i <= s.length() / 2; i++) {

            String firstPart = s.substring(0, i);

            if (firstPart.startsWith("0")) {
                continue;
            }

            long first = Long.parseLong(firstPart);

            String temp = "";

            long num = first;

            while (temp.length() < s.length()) {
                temp += num;
                num++;
            }

            if (temp.equals(s)) {
                System.out.println("YES " + first);
                return;
            }
        }

        System.out.println("NO");
    }
}

public class SeparateNoDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();

        while (q-- > 0) {
            String s = sc.next();
            Result.separateNumbers(s);
        }

        sc.close();
    }
}

