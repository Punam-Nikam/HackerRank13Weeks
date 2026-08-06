//PROBLEM - 71 // GETWAYS PROBLEM

import java.util.*;

/*
Problem:
Find the number of ways to make a given amount using
unlimited supply of given coin denominations.
*/

public class GetWays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        System.out.print("Enter number of coin types: ");
        int m = sc.nextInt();

        long[] coins = new long[m];

        System.out.println("Enter coin denominations:");

        for (int i = 0; i < m; i++) {
            coins[i] = sc.nextLong();
        }

        long[] dp = new long[amount + 1];

        // Base case
        dp[0] = 1;

        // Process each coin
        for (long coin : coins) {

            for (int j = (int) coin; j <= amount; j++) {

                dp[j] += dp[j - (int) coin];
            }
        }

        System.out.println("Number of ways = " + dp[amount]);

        sc.close();
    }
}