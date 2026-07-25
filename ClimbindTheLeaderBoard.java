// PROBLEM - 54 climbing the leaderboard

import java.util.*;

public class ClimbindTheLeaderBoard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> unique = new ArrayList<>();

        unique.add(ranked.get(0));

        for (int i = 1; i < ranked.size(); i++) {

            if (!ranked.get(i).equals(ranked.get(i - 1))) {
                unique.add(ranked.get(i));
            }
        }

        List<Integer> result = new ArrayList<>();

        int i = unique.size() - 1;

        for (int score : player) {

            while (i >= 0 && score >= unique.get(i)) {
                i--;
            }

            result.add(i + 2);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of leaderboard scores: ");
        int n = sc.nextInt();

        List<Integer> ranked = new ArrayList<>();

        System.out.println("Enter leaderboard scores:");

        for (int i = 0; i < n; i++) {
            ranked.add(sc.nextInt());
        }

        System.out.print("Enter number of player scores: ");
        int m = sc.nextInt();

        List<Integer> player = new ArrayList<>();

        System.out.println("Enter player scores:");

        for (int i = 0; i < m; i++) {
            player.add(sc.nextInt());
        }

        List<Integer> ans = climbingLeaderboard(ranked, player);

        System.out.println("Player Ranks:");

        for (int rank : ans) {
            System.out.println(rank);
        }

        sc.close();
    }
}