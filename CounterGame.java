//PROBLEM: 50 Counter Game

// Louise and Richard are playing a game with a number n. Louise always starts first. On each turn, if n is a power of 2, the player divides it by 2; otherwise, the player subtracts the largest power of 2 that is smaller than n. The player who reduces n to 1 wins the game. Determine the winner.


import java.util.*;

public class CounterGame {

    public static String countergame(long n) {

        int moves = 0;

        while (n > 1) {

            // Check if n is a power of 2
            if ((n & (n - 1)) == 0) {

                n = n / 2;

            } else {

                long power = 1;

                while (power * 2 < n) {
                    power *= 2;
                }

                n = n - power;
            }

            moves++;
        }

        if (moves % 2 == 1)
            return "Louise";
        else
            return "Richard";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.print("Enter n: ");
            long n = sc.nextLong();

            System.out.println(countergame(n));
        }

        sc.close();
    }
}