package Queue;

import java.util.NoSuchElementException;


public class MyQueue {

    private Node head;
    private Node tail;
    private int size;

    public void add(Object value){
        Node node = new Node(value);

        if (tail == null){
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
    }
    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public Object peek(){
        if (head == null){
            throw new NoSuchElementException("Queue is empty");
        }
       return head.value;
    }
    public Object poll(){
        if (head == null){
            throw new NoSuchElementException("Queue is empty");
        }
        Object value = head.value;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return value;
    }
    public static class Node{
        Object value;
        Node next;


        public Node(Object value){

            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add("12");
        myQueue.add(3);

        System.out.println(myQueue.size());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.size());

        myQueue.clear();
        System.out.println(myQueue.peek());

    }
}
