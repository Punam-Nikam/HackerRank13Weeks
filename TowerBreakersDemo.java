// PROBLEM - 32 TOWER BREAKERS
// Determine the winner of the Tower Breakers game where players alternately reduce tower heights using valid divisors.
// Return 1 if Player 1 wins with optimal play, otherwise return 2.

import java.util.*;

public class TowerBreakersDemo {

    public static int towerBreakers(int n, int m) {

        if (m == 1 || n % 2 == 0) {
            return 2;
        }

        return 1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();

            System.out.println(towerBreakers(n, m));
        }
    }
}