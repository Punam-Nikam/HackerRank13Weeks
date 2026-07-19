//PROBLEM: 51 The Bomberman Game

//In the Bomberman game, Bomberman plants bombs in a grid. Each bomb takes 3 seconds to explode. When a bomb explodes, it destroys itself and any cells adjacent to it (up, down, left, right). Bomberman can plant bombs in any empty cell. Given the initial state of the grid and the number of seconds that have passed, determine the state of the grid after n seconds.

import java.util.*;

public class TheBombermanGame {

    static String[] explode(String[] grid) {

        int r = grid.length;
        int c = grid[0].length();

        char[][] result = new char[r][c];

        // Fill everything with bombs
        for (int i = 0; i < r; i++) {
            Arrays.fill(result[i], 'O');
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        // Explode old bombs
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {

                if (grid[i].charAt(j) == 'O') {

                    result[i][j] = '.';

                    for (int k = 0; k < 4; k++) {

                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr < r && nc >= 0 && nc < c)
                            result[nr][nc] = '.';
                    }
                }
            }
        }

        String[] ans = new String[r];

        for (int i = 0; i < r; i++)
            ans[i] = new String(result[i]);

        return ans;
    }

    static String[] bomberMan(int n, String[] grid) {

        if (n == 1)
            return grid;

        int r = grid.length;
        int c = grid[0].length();

        if (n % 2 == 0) {

            String[] full = new String[r];

            char[] row = new char[c];
            Arrays.fill(row, 'O');

            String s = new String(row);

            for (int i = 0; i < r; i++)
                full[i] = s;

            return full;
        }

        String[] first = explode(grid);

        if ((n - 3) % 4 == 0)
            return first;

        return explode(first);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Rows : ");
        int r = sc.nextInt();

        System.out.print("Columns : ");
        int c = sc.nextInt();

        System.out.print("Seconds : ");
        int n = sc.nextInt();

        String[] grid = new String[r];

        System.out.println("Enter Grid:");

        for (int i = 0; i < r; i++)
            grid[i] = sc.next();

        String[] ans = bomberMan(n, grid);

        System.out.println("\nFinal Grid:");

        for (String row : ans)
            System.out.println(row);

        sc.close();
    }
}
