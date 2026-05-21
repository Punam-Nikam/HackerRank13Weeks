// PROBLEM - 22 Sales By Match.

// Given a list of sock colors represented by integers, count how many matching pairs of socks can be formed.
//  Two socks form a pair if they have the same color.

import java.util.*;

public class SalesByMatch {

    public static int sockMerchant(int n, List<Integer> ar) {

        int pair = 0;

        Collections.sort(ar);

        for(int i = 0; i < n - 1; i++) {

            if(ar.get(i).equals(ar.get(i + 1))) {

                pair++;
                i++;
            }
        }

        return pair;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> ar = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            ar.add(sc.nextInt());
        }

        int result = sockMerchant(n, ar);

        System.out.println(result);

        sc.close();
    }
}
