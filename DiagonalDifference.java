import java.util.*;

public class DiagonalDifference {

    public static void main(String[] args) {

        List<List<Integer>> arr = new ArrayList<>();

        arr.add(Arrays.asList(1, 2, 3));
        arr.add(Arrays.asList(4, 5, 6));
        arr.add(Arrays.asList(9, 8, 9));

        int leftDiagonal = 0;
        int rightDiagonal = 0;

        int n = arr.size();

        for (int i = 0; i < n; i++) {

            // Left to Right Diagonal
            leftDiagonal += arr.get(i).get(i);

            // Right to Left Diagonal
            rightDiagonal += arr.get(i).get(n - 1 - i);
        }

        int difference = Math.abs(leftDiagonal - rightDiagonal);

        System.out.println("Left Diagonal Sum = " + leftDiagonal);
        System.out.println("Right Diagonal Sum = " + rightDiagonal);
        System.out.println("Absolute Difference = " + difference);
    }
}