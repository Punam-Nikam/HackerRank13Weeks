import java.util.*;

public class XORArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();

        while (t-- > 0) {

            System.out.print("Enter size of array: ");
            int n = sc.nextInt();

            int[] arr = new int[n];

            System.out.println("Enter elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int result = 0;

            // Optimal logic: check contribution of each element
            for (int i = 0; i < n; i++) {

                long count = (long)(i + 1) * (n - i);

                if (count % 2 == 1) {
                    result ^= arr[i];
                }
            }

            System.out.println("Answer = " + result);
        }

        sc.close();
    }
}