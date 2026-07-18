//PROBLEM - 48 Forming magic square

// Given a 3 × 3 matrix containing integers from 1 to 9, convert it into a valid magic square. A magic square contains all numbers from 1 to 9 exactly once, and the sum of every row, column, and diagonal is 15. The cost of changing a number is the absolute difference between the original and new value. Find the minimum total cost.

import java.util.*;

public class MagicSquareForming {

    public static int formingMagicSquare(List<List<Integer>> s) {

        // All possible 3x3 magic squares
        int[][][] magic = {
            {{8,1,6},{3,5,7},{4,9,2}},
            {{6,1,8},{7,5,3},{2,9,4}},
            {{4,9,2},{3,5,7},{8,1,6}},
            {{2,9,4},{7,5,3},{6,1,8}},
            {{8,3,4},{1,5,9},{6,7,2}},
            {{4,3,8},{9,5,1},{2,7,6}},
            {{6,7,2},{1,5,9},{8,3,4}},
            {{2,7,6},{9,5,1},{4,3,8}}
        };

        int minCost = Integer.MAX_VALUE;

        // Compare the input with each magic square
        for (int k = 0; k < 8; k++) {

            int cost = 0;

            for (int i = 0; i < 3; i++) {

                for (int j = 0; j < 3; j++) {

                    cost += Math.abs(s.get(i).get(j) - magic[k][i][j]);

                }
            }

            if (cost < minCost) {
                minCost = cost;
            }
        }

        return minCost;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<List<Integer>> s = new ArrayList<>();

        System.out.println("Enter the 3x3 matrix:");

        for (int i = 0; i < 3; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < 3; j++) {

                row.add(sc.nextInt());

            }

            s.add(row);
        }

        int result = formingMagicSquare(s);

        System.out.println("Minimum Cost = " + result);

        sc.close();
    }
}