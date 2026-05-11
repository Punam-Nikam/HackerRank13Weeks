import java.util.*;

public class FlippingBits {

    // Function to flip all 32 bits
    public static long flippingBits(long n) {

        // Maximum value of unsigned 32-bit integer
        long max = 4294967295L;

        // Flip bits
        return max - n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of test cases
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {

            long n = sc.nextLong();

            System.out.println(flippingBits(n));
        }

        sc.close();
    }
}