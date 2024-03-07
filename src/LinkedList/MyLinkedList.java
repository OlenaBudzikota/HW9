package LinkedList;


import java.util.Objects;

public class MyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void add(Object value){
        Node node = new Node(value);

        if (head == null){
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }
        tail = node;
        size++;
    }

    public void remove(int index){
        Objects.checkIndex(index, size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        if (current.previous != null){
            current.previous.next = current.next;
        } else {
            head = current.next;
        }

        if (current.next != null){
            current.next.previous = current.previous;
        } else {
            tail = current.previous;
        }
        size--;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public Object get(int index){
        Objects.checkIndex(index, size);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int size(){
        return size;
    }


    private static class Node{
        Object value;
        Node next;
        Node previous;

        public Node(Object value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }

        System.out.println("\nDelete first index:");
        myLinkedList.remove(1);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println("\nSize = " + myLinkedList.size());

        System.out.println("Clear:");
        myLinkedList.clear();
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
    }
}
