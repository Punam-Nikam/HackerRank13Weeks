//PROBLEM - 57 DoublyReversedLinkedList

/*
Problem Statement:
Reverse a doubly linked list by swapping the next and prev
pointers of every node. Return the head of the reversed list.
*/

import java.util.*;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class DoublyReversedLinkedList {

    public static Node reverse(Node head) {

        Node current = head;
        Node temp = null;

        while (current != null) {

            // Swap prev and next
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // Move to next node
            current = current.prev;
        }

        if (temp != null)
            head = temp.prev;

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
                newNode.prev = tail;
                tail = newNode;
            }
        }

        System.out.println("Original List:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed List:");
        printList(head);

        sc.close();
    }
}