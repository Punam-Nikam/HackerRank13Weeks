//PROBLEM - 73 // Maximum Subarray Sum

import java.util.*;

/*
Problem:
Find -
1. Maximum Subarray Sum (Contiguous)
2. Maximum Subsequence Sum (Non-contiguous)
*/

public class MaxSubarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        // -------------------------
        // Maximum Subarray (Kadane)
        // -------------------------

        int current = arr[0];
        int maxSubarray = arr[0];

        for (int i = 1; i < n; i++) {

            current = Math.max(arr[i], current + arr[i]);

            maxSubarray = Math.max(maxSubarray, current);
        }

        // -------------------------
        // Maximum Subsequence
        // -------------------------

        int maxSubsequence = 0;
        boolean hasPositive = false;
        int largest = arr[0];

        for (int num : arr) {

            if (num > 0) {
                maxSubsequence += num;
                hasPositive = true;
            }

            largest = Math.max(largest, num);
        }

        if (!hasPositive)
            maxSubsequence = largest;

        System.out.println("Maximum Subarray Sum = " + maxSubarray);

        System.out.println("Maximum Subsequence Sum = " + maxSubsequence);

        sc.close();
    }
}