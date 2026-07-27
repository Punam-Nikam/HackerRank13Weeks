//PROBLEM - 56 Reverse linked list (starts intermediate)
/*
Problem Statement:
Given the head of a singly linked list, reverse the linked list by
changing the next pointers of each node. Return the head of the
reversed linked list.
*/

import java.util.*;


class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

    public class ReversedLinkedList {

    // Function to reverse linked list
    public static Node reverse(Node head) {

        Node previous = null;
        Node current = head;

        while (current != null) {

            Node next = current.next; // Save next node

            current.next = previous;  // Reverse pointer

            previous = current;       // Move previous

            current = next;           // Move current
        }

        return previous;
    }

    // Function to print linked list
    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.println("Original Linked List:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed Linked List:");
        printList(head);

        sc.close();
    }
}   
