//PROBLEM - 69 Equal Stacks
/*
Problem:
There are 3 stacks of cylinders with different heights.
You can only remove cylinders from the TOP of any stack.

Find the maximum possible height such that all three stacks
become equal.

Example:
Stack1: 3 2 1 1 1
Stack2: 4 3 2
Stack3: 1 1 4 1

Output:
5
*/

import java.util.*;

public class EqualStacks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of cylinders in each stack
        System.out.print("Enter number of cylinders in Stack 1: ");
        int n1 = sc.nextInt();

        System.out.print("Enter number of cylinders in Stack 2: ");
        int n2 = sc.nextInt();

        System.out.print("Enter number of cylinders in Stack 3: ");
        int n3 = sc.nextInt();

        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];

        int sum1 = 0, sum2 = 0, sum3 = 0;

        // Input Stack 1
        System.out.println("\nEnter heights of Stack 1 (Top to Bottom):");
        for (int i = 0; i < n1; i++) {
            h1[i] = sc.nextInt();
            sum1 += h1[i];
        }

        // Input Stack 2
        System.out.println("\nEnter heights of Stack 2 (Top to Bottom):");
        for (int i = 0; i < n2; i++) {
            h2[i] = sc.nextInt();
            sum2 += h2[i];
        }

        // Input Stack 3
        System.out.println("\nEnter heights of Stack 3 (Top to Bottom):");
        for (int i = 0; i < n3; i++) {
            h3[i] = sc.nextInt();
            sum3 += h3[i];
        }

        // Top indexes of each stack
        int i = 0, j = 0, k = 0;

        while (true) {

            // If all heights are equal
            if (sum1 == sum2 && sum2 == sum3) {
                System.out.println("\nMaximum Equal Height = " + sum1);
                break;
            }

            // Remove from tallest stack
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1[i];
                i++;
            }
            else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2[j];
                j++;
            }
            else {
                sum3 -= h3[k];
                k++;
            }
        }

        sc.close();
    }
}