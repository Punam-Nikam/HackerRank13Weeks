// PROBLEM - 77 MIN max operation

import java.util.*;

class MinimumOperations {

    private static final Scanner scan = new Scanner(System.in);

    int n, r, g, b;

    // dp[i][mask]
    // i    = number of boxes processed
    // mask = which colors have been used
    int[][] dp = new int[110][1 << 3];

    Vector<Integer> red = new Vector<>();
    Vector<Integer> green = new Vector<>();
    Vector<Integer> blue = new Vector<>();

    public void get() {

        n = scan.nextInt();

        for (int i = 0; i < n; i++) {

            r = scan.nextInt();
            g = scan.nextInt();
            b = scan.nextInt();

            red.add(r);
            green.add(g);
            blue.add(b);
        }
    }

    public void minOperations() {

        int i, j;

        // Initialize DP with infinity
        for (i = 0; i <= n; i++) {
            for (j = 0; j < 8; j++) {
                dp[i][j] = (1 << 30);
            }
        }

        dp[0][0] = 0;

        // Process every box
        for (i = 0; i < n; i++) {

            for (j = 0; j < 8; j++) {

                // Make this box RED-only
                // Move GREEN + BLUE balls
                dp[i + 1][j | 1] = Math.min(
                    dp[i + 1][j | 1],
                    dp[i][j] + green.get(i) + blue.get(i)
                );

                // Make this box GREEN-only
                // Move RED + BLUE balls
                dp[i + 1][j | 2] = Math.min(
                    dp[i + 1][j | 2],
                    dp[i][j] + red.get(i) + blue.get(i)
                );

                // Make this box BLUE-only
                // Move RED + GREEN balls
                dp[i + 1][j | 4] = Math.min(
                    dp[i + 1][j | 4],
                    dp[i][j] + red.get(i) + green.get(i)
                );
            }
        }

        // Find which colors actually exist
        j = 0;

        for (i = 0; i < n; i++) {

            if (green.get(i) != 0)
                j |= 1;

            if (red.get(i) != 0)
                j |= 2;

            if (blue.get(i) != 0)
                j |= 4;
        }

        // Impossible
        if (dp[n][j] >= (1 << 30))
            dp[n][j] = -1;

        System.out.println(dp[n][j]);
    }
}


public class MinMaxOperation {

    public static void main(String[] args) {

        MinimumOperations obj = new MinimumOperations();

        obj.get();
        obj.minOperations();
    }
}