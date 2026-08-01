//PROBLEM - 62 Insert a node into a sorted doubly linked list

/*
Problem Statement:
Insert a node into a sorted doubly linked list
while maintaining the sorted order.
*/

import java.util.*;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

public class InsertNodeInDoublyLL {

    static Node sortedInsert(Node head, int data) {

        Node newNode = new Node(data);

        // Empty list
        if (head == null)
            return newNode;

        // Beginning
        if (data <= head.data) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        Node current = head;

        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        // End
        if (current.next == null) {

            current.next = newNode;
            newNode.prev = current;

        } else {

            newNode.next = current.next;
            newNode.prev = current;

            current.next.prev = newNode;
            current.next = newNode;
        }

        return head;
    }

    static void print(Node head) {

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

        Node head = null, tail = null;

        System.out.println("Enter sorted elements:");

        for (int i = 0; i < n; i++) {

            Node node = new Node(sc.nextInt());

            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
        }

        System.out.print("Enter value to insert: ");
        int data = sc.nextInt();

        head = sortedInsert(head, data);

        System.out.println("Updated List:");
        print(head);

        sc.close();
    }
}