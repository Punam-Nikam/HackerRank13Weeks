import java.util.*;

public class SubArrayDivision {

    public static int birthday(List<Integer> s, int d, int m) {

        int count = 0;

        // Loop through all possible starting positions
        for (int i = 0; i <= s.size() - m; i++) {

            int sum = 0;

            // Calculate sum of current segment
            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }

            // Check if sum matches birthday
            if (sum == d) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of chocolate squares
        int n = sc.nextInt();

        List<Integer> s = new ArrayList<>();

        // Input array elements
        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        // Birthday and month
        int d = sc.nextInt();
        int m = sc.nextInt();

        int result = birthday(s, d, m);

        System.out.println(result);

        sc.close();
    }
}