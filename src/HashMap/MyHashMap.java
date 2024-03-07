package HashMap;


import java.util.Objects;

public class MyHashMap {
    private static final int DEFAULT_SIZE = 8;
    private Node[] table = new Node[DEFAULT_SIZE];
    private int size;

    private void put(Object key, Object value){
    int index = getBucketIndex(key);
    Node node = new Node(key,value);
    if (table[index] == null){
        table[index] = node;
        size++;
    } else {
        Node current = table[index];
         while (current.next!=null){
             if (Objects.equals(current.key, key)){
                 current.value = value;
                 return;
             }
             current = current.next;
         }
         if (Objects.equals(current.key,key)){
             current.value = value;
         } else {
             current.next = node;
             size++;
         }
    }
    }

    private void remove(Object key){
        int index = getBucketIndex(key);
        Node current = table[index];
        Node previous = null;
        while(current != null){
            if (Objects.equals(current.key, key)){
                if (previous == null){
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public void clear(){
       table = new Node[DEFAULT_SIZE];
       size = 0;
    }

    public int size(){
        return size;
    }

    public Object get(Object key){
        int index = getBucketIndex(key);
        Node current = table[index];
        while (current != null){
            if (Objects.equals(current.key, key)){
                return current.value;
            }
                current = current.next;
        }
        return null;
    }


    private int getBucketIndex(Object key){
        return Math.abs(key.hashCode()% table.length);
    }
    private static class Node{
        Object key;
        Object value;
        Node next;

        public Node(Object key, Object value){
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("0", "Zero");
        myHashMap.put("1", "First");
        myHashMap.put("2", "Second");


        System.out.println("size = " + myHashMap.size());

        System.out.println(myHashMap.get("2"));
        myHashMap.remove("1");
        System.out.println("size = " + myHashMap.size());
        System.out.println(myHashMap.get("1"));
        myHashMap.clear();
        System.out.println(myHashMap.get("2"));
        System.out.println(myHashMap.size());

    }


}
