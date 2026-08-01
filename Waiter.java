//PROBLEM - 67 Waiter Problem
/*
Problem:
You have a stack of numbered plates.

For each prime number (2, 3, 5, ...):
1. Remove plates one by one from the top.
2. If the plate number is divisible by the current prime,
   push it into stack B.
3. Otherwise push it into stack A (next stack).

After each iteration:
- Print/store all plates from stack B (top to bottom).
- Continue with the new A stack.

After all iterations, print the remaining plates.
*/

import java.util.*;

public class Waiter {

    // Function to find the next prime number
    public static int nextPrime(int current) {

        int num = current + 1;

        while (true) {

            boolean isPrime = true;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                return num;

            num++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of plates
        System.out.print("Enter number of plates: ");
        int n = sc.nextInt();

        // Number of iterations
        System.out.print("Enter number of iterations (q): ");
        int q = sc.nextInt();

        Stack<Integer> current = new Stack<>();

        System.out.println("Enter plate numbers:");

        // Push plates into stack
        for (int i = 0; i < n; i++) {
            current.push(sc.nextInt());
        }

        List<Integer> answer = new ArrayList<>();

        int prime = 2;

        // Perform q iterations
        for (int i = 0; i < q; i++) {

            Stack<Integer> next = new Stack<>();
            Stack<Integer> divisible = new Stack<>();

            // Process current stack
            while (!current.isEmpty()) {

                int plate = current.pop();

                if (plate % prime == 0) {
                    divisible.push(plate);
                } else {
                    next.push(plate);
                }
            }

            // Store plates from B stack
            while (!divisible.isEmpty()) {
                answer.add(divisible.pop());
            }

            // Next A becomes current
            current = next;

            // Move to next prime
            prime = nextPrime(prime);
        }

        // Store remaining plates
        while (!current.isEmpty()) {
            answer.add(current.pop());
        }

        // Print answer
        System.out.println("\nFinal Order:");

        for (int x : answer) {
            System.out.println(x);
        }

        sc.close();
    }
}