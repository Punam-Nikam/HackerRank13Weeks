import java.util.*;

public class GridChallenge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> grid = new ArrayList<>();

        System.out.println("Enter " + n + " strings (each row of the grid):");

        for (int i = 0; i < n; i++) {
            grid.add(sc.nextLine());
        }

        // Step 1: Sort each row
        for (int i = 0; i < n; i++) {
            char[] ch = grid.get(i).toCharArray();
            Arrays.sort(ch);
            grid.set(i, new String(ch));
        }

        // Step 2: Check columns
        for (int col = 0; col < grid.get(0).length(); col++) {
            for (int row = 0; row < n - 1; row++) {

                if (grid.get(row).charAt(col) > grid.get(row + 1).charAt(col)) {
                    System.out.println("NO");
                    sc.close();
                    return;
                }
            }
        }

        System.out.println("YES");
        sc.close();
    }
}