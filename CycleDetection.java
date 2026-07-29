//PROBLEM - 60 cycle detection

/*
Problem Statement:
Check whether a singly linked list contains a cycle.
Return true if a cycle exists, otherwise return false.
*/

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class CycleDetection {

    // Detect cycle using Floyd's Algorithm
    public static boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;          // Move 1 step
            fast = fast.next.next;     // Move 2 steps

            if (slow == fast)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        // Create nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(11);
        head.next.next.next = new Node(21);

        
        head.next.next.next.next = head.next;

        if (hasCycle(head))
            System.out.println("Cycle Found");
        else
            System.out.println("No Cycle");
    }
}