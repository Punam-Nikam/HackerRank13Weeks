//PROBLEM - 26 - Drawing Book(fLIPPING PAGE)

// Find the minimum number of page flips required to reach a given page in a book, starting either from the front or the back.
// Each page flip turns two pages at a time.

import java.util.*;

public class PageFlippingDemo {

    public static int pageCount(int n, int p) {

        int frontCount = 0;
        int backCount = 0;

        // Count flips from front
        for (int i = 1; i < p; i += 2) {
            frontCount++;
        }

        // Determine starting page from back
        int start;

        if (n % 2 == 0)
            start = n;
        else
            start = n - 1;

        // Count flips from back
        for (int j = start; j > p; j -= 2) {
            backCount++;
        }

        return Math.min(frontCount, backCount);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        System.out.println(pageCount(n, p));

        sc.close();
    }
}