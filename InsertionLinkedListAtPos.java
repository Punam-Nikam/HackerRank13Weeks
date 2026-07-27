//PROBLEM - 58 insert Node At PositION 
/*
Problem Statement:
Insert a new node with the given value at the specified position
in a singly linked list and return the updated head.
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

public class InsertionLinkedListAtPos {

    public static Node insertNodeAtPosition(Node head, int data, int position) {

        Node newNode = new Node(data);

        // Insert at head
        if (position == 0) {
            newNode.next = head;
            return newNode;
        }

        Node current = head;

        // Move to previous node
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        // Insert node
        newNode.next = current.next;
        current.next = newNode;

        return head;
    }

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

            Node newNode = new Node(sc.nextInt());

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        System.out.print("Enter data to insert: ");
        int data = sc.nextInt();

        System.out.print("Enter position: ");
        int position = sc.nextInt();

        head = insertNodeAtPosition(head, data, position);

        System.out.println("Updated Linked List:");
        printList(head);

        sc.close();
    }
}