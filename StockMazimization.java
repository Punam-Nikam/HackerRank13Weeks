//PROBLEM - 68 Stock Maximization
/*
Problem:
Find maximum profit by buying and selling stocks.

You can:
1. Buy one stock per day.
2. Sell any number of stocks on any day.
*/

import java.util.*;

public class StockMazimization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        long profit = 0;

        int maxPrice = 0;

        // Traverse from last day
        for (int i = n - 1; i >= 0; i--) {

            // Update future maximum price
            if (prices[i] > maxPrice) {
                maxPrice = prices[i];
            }

            // Buy on this day and sell later
            else {
                profit += maxPrice - prices[i];
            }
        }

        System.out.println("Maximum Profit = " + profit);

        sc.close();
    }
}