//week-2 (MOCK TEST)
//Maximize the sum of the top-left n×n quadrant of a 2n×2n matrix by reversing any rows or columns any number of times.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipMatrix {

    // Complete the flippingMatrix function below.
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int size = 2 * n;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = matrix.get(i).get(j);
                int b = matrix.get(i).get(size - 1 - j);
                int c = matrix.get(size - 1 - i).get(j);
                int d = matrix.get(size - 1 - i).get(size - 1 - j);

                // Choose the maximum of the four symmetric positions
                sum += Math.max(Math.max(a, b), Math.max(c, d));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt(); // number of queries

        for (int query = 0; query < q; query++) {
            int n = scanner.nextInt();
            int size = 2 * n;
            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < size; j++) {
                    row.add(scanner.nextInt());
                }
                matrix.add(row);
            }

            int result = flippingMatrix(matrix);
            System.out.println(result);
        }
        scanner.close();
    }
}