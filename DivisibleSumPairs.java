import java.util.*;

public class DivisibleSumPairs{

    public static int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int count = 0;

        // Check all possible pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // If sum is divisible by k
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> ar = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ar.add(sc.nextInt());
        }

        int result = divisibleSumPairs(n, k, ar);

        System.out.println(result);

        sc.close();
    }
}