// PROBLEM - 43 Sum XOR 
//Given an integer n, find number of values x such that:
// n + x == n ^ x   return valid count
 
import java.util.Scanner;

public class SumXoR {

    public static long sumXor(long n) {

        long zeroBits = 0;

        // Count number of zero bits in binary of n
        while (n > 0) {
            if ((n & 1) == 0) {
                zeroBits++;
            }
            n >>= 1;
        }

        // Each zero bit gives 2 choices (0 or 1)
        return 1L << zeroBits;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        long n = sc.nextLong();

        long result = sumXor(n);

        System.out.println("Output: " + result);

        sc.close();
    }
}