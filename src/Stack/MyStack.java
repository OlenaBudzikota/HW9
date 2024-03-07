package Stack;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class MyStack {
    private Node top;
    private int size;

    public void push(Object value){
        Node node = new Node(value);
        if (top == null){
            top = node;
        } else{
            node.next = top;
            top = node;
        }
        size++;
    }

    public void clear(){
        top = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object peek(){
        if (top == null){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public Object pop(){
        if (top == null){
            throw new EmptyStackException();
        }
        Object value = top.data;
        top = top.next;
        size--;
        return value;

    }
    public static class Node {
        Object data;
        Node next;

        Node(Object data){
            this.data=data;
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push(1);

        System.out.println("size = " + myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println("size = " + myStack.size());
        System.out.println(myStack.pop());


        myStack.clear();
        System.out.println("size = " + myStack.size());
    }
}
