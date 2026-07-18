//PROBLEM - 49 Super digit
//Given a number n (as a string) and an integer k, create a new number by concatenating n exactly k times. The super digit of a number is found by repeatedly adding its digits until only one digit remains. Return the super digit of the concatenated number.

import java.util.Scanner;

public class SumDigit {

    // Function to find super digit
    public static int superDigit(String n, int k) {

        long sum = 0;

        // Sum of digits of n
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }

        // Multiply by k instead of concatenating
        sum = sum * k;

        // Keep finding digit sum until one digit remains
        while (sum >= 10) {

            long temp = 0;

            while (sum > 0) {
                temp += sum % 10;
                sum /= 10;
            }

            sum = temp;
        }

        return (int) sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        String n = sc.next();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = superDigit(n, k);

        System.out.println("Super Digit = " + result);

        sc.close();
    }
}
