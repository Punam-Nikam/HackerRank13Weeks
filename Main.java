// PROBLEM - 39 Dymanic Array
// Perform dynamic array operations based on queries and print the results of all type-2 queries.


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of arrays (n): ");
        int n = sc.nextInt();

        System.out.print("Enter number of queries (q): ");
        int q = sc.nextInt();

        // Create n empty arrays
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        int lastAnswer = 0;

        System.out.println("\nEnter each query in the format:");
        System.out.println("Type x y");
        System.out.println("Example: 1 0 5");
        System.out.println();

        while (q-- > 0) {

            int type = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            int idx = (x ^ lastAnswer) % n;

            if (type == 1) {
                arr.get(idx).add(y);
            } else {
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                System.out.println("Output: " + lastAnswer);
            }
        }

        sc.close();
    }
}