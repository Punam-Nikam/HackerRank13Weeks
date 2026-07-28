//PROBLEM - 59 merged sorted linked list(singly) 
/*
Problem Statement:
Given two sorted singly linked lists, merge them into a single
sorted linked list. Reuse the existing nodes and return the
head of the merged list.
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

public class MergerSortedLinkedList {

    // Function to merge two sorted linked lists
    public static Node mergeLists(Node head1, Node head2) {

        Node dummy = new Node(0);   // Dummy node
        Node tail = dummy;

        // Compare nodes from both lists
        while (head1 != null && head2 != null) {

            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }

        // Attach remaining nodes
        if (head1 != null)
            tail.next = head1;

        if (head2 != null)
            tail.next = head2;

        return dummy.next;
    }

    // Print linked list
    public static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First Linked List
        System.out.print("Enter number of nodes in first list: ");
        int n1 = sc.nextInt();

        Node head1 = null, tail1 = null;

        System.out.println("Enter elements (sorted):");

        for (int i = 0; i < n1; i++) {

            Node newNode = new Node(sc.nextInt());

            if (head1 == null) {
                head1 = newNode;
                tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        // Second Linked List
        System.out.print("Enter number of nodes in second list: ");
        int n2 = sc.nextInt();

        Node head2 = null, tail2 = null;

        System.out.println("Enter elements (sorted):");

        for (int i = 0; i < n2; i++) {

            Node newNode = new Node(sc.nextInt());

            if (head2 == null) {
                head2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        Node merged = mergeLists(head1, head2);

        System.out.println("Merged Linked List:");
        printList(merged);

        sc.close();
    }
}