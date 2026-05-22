import java.util.*;

public class ZigzagSequence {

    public static void findZigZagSequence(int[] a, int n) {

        // sort array
        Arrays.sort(a);

        // find middle index
        int mid = (n - 1) / 2;

        // swap middle and last element
        int temp = a[mid];
        a[mid] = a[n - 1];
        a[n - 1] = temp;

        // reverse second half
        int st = mid + 1;
        int ed = n - 2;

        while (st <= ed) {

            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;

            st++;
            ed--;
        }

        // print result
        for (int i = 0; i < n; i++) {

            if (i == n - 1) {
                System.out.println(a[i]);
            } else {
                System.out.print(a[i] + " ");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        while (testCases-- > 0) {

            int n = sc.nextInt();

            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            findZigZagSequence(a, n);
        }
    }
}