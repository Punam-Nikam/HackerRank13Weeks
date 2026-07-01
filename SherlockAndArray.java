//PROBLEM - 45 Sherlock and Array
//Given an array of integers, determine whether there exists an element such that the sum of all elements to its left is equal to the sum of all elements to its right. Print "YES" if such an element exists; otherwise, print "NO".
import java.util.Scanner;

public class SherlockAndArray {

    public static String balancedSums(int[] arr) {

        int total = 0;

        // Calculate total sum
        for (int num : arr) {
            total += num;
        }

        int leftSum = 0;

        // Check each element
        for (int i = 0; i < arr.length; i++) {

            int rightSum = total - leftSum - arr[i];

            if (leftSum == rightSum) {
                return "YES";
            }

            leftSum += arr[i];
        }

        return "NO";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(balancedSums(arr));
        }

        sc.close();
    }
}   