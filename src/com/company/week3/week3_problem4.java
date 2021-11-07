package com.company.week3;

import java.util.HashSet;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

public class week3_problem4 {

    public static boolean hasLoop(Node head){
        if (head == null){
            return false;
        }
        //one pointer fast and one pointer slow
        Node slow = head;
        Node fast = head.next;

        while(slow != fast){    //check if two pointers will meet or not
            if(fast.next == null || fast.next.next == null){
                return false; //check if the next data of the next fast pointer is null or not
            }
            //otherwise, move slow and fast pointer to next one, until they meet and escape loop
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void removeLoopWithSet(Node head){
        if(!hasLoop(head)){
            return;
        }
        HashSet<Node> nodeHashSet = new HashSet<>(); //hashset only contains unique nodes
        nodeHashSet.add(head); //add head into hashset
        while(!nodeHashSet.contains(head.next)){ //check if the next node already contains the node or not
            nodeHashSet.add(head.next); //if node is unique then add next node
            head = head.next; // assign the new head if the next node
        }
        head.next = null; //if node is not unique, then the next node should be null
    }

    public static void removeLoopWith2Pointers(Node head){
        if(!hasLoop(head)){
            return;
        }
        Node fast,slow;
        fast = slow = head;

        //move two pointers to where they meet the same node
        do {
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);

        //count how many nodes in the loop using the slow pointer
        //the do while loop will execute the do first then check with the condition
        int count = 1;
        do {
            slow = slow.next;
            count++;
        }
        while (slow != fast);

        slow = fast = head; //reset two pointers

        for (int i = 0; i < count; i++) {
            fast = fast.next; //move the fast pointer one step forward inside the loop
        }

        while (slow.next != fast.next){ //check if they are intersected otherwise, move up one
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null; //if they meet, set slow or fast of next pointer to null
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node n2 = new Node(2);
        head.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
        Node n5 = new Node(5);
        n4.next = n5;

        // This assignment creates a loop
        n5.next = n3;

//        System.out.println(hasLoop(head));
        removeLoopWith2Pointers(head);
//        removeLoopWithSet(head);

    }
}
