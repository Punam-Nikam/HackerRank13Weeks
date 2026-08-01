//PROBLEM - 63 Implement a Queue using two Stacks

/*
Problem Statement:
Implement a Queue using two Stacks.

Operations:
1 x -> Enqueue x into the queue.
2   -> Dequeue the front element.
3   -> Print the front element.

Queue follows FIFO (First In First Out).
*/
import java.util.*;

public class QueStackusingTwoStack {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Two stacks
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Number of queries
        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        System.out.println("\nQuery Types:");
        System.out.println("1 x -> Enqueue");
        System.out.println("2   -> Dequeue");
        System.out.println("3   -> Print Front\n");

        while (q-- > 0) {

            int type = sc.nextInt();

            // ---------------- ENQUEUE ----------------
            if (type == 1) {

                int x = sc.nextInt();

                // Always push into stack1
                stack1.push(x);
            }

            // ---------------- DEQUEUE ----------------
            else if (type == 2) {

                // If stack2 is empty, move all elements
                if (stack2.isEmpty()) {

                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }

                // Remove front element
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }

            // ---------------- PRINT FRONT ----------------
            else if (type == 3) {

                // If stack2 is empty, move elements
                if (stack2.isEmpty()) {

                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                }

                // Print front element
                if (!stack2.isEmpty()) {
                    System.out.println("Front Element: " + stack2.peek());
                }
            }
        }

        sc.close();
    }
}