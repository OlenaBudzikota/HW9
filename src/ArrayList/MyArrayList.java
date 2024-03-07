package ArrayList;

public class MyArrayList {
    private Object[] data;
    private int size;
    public static final int DEFAULT_CAPACITY = 1;

    public MyArrayList(){
        this.data= new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void add(Object value){
        if(size >= data.length){
             Object[] newArray = new Object[data.length*2];
             System.arraycopy(data, 0, newArray, 0, size);
             data = newArray;
        }
        data[size] = value;
        size++;
    }

    public void remove(int index){
        if (index<0 || index >=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        int number = 0;
        Object[] newArray = new Object[size - 1];
        for (int i = 0; i < size; i++) {
            if (i != index) {
                newArray[number] = data[i];
                number++;
            }
        }
        data = newArray;
        size--;
    }

    public void clear(){
        data = new Object[0];
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index){
        if (index< 0 || index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }


    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);

        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.data[i]);
        }
        System.out.println(myArrayList.size() + " size");

        myArrayList.remove(2);
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println(myArrayList.data[i]);
        }
        System.out.println("index 1 = " + myArrayList.get(1));
        System.out.println("clear");
        myArrayList.clear();
        for (int i = 0; i <myArrayList.size() ; i++) {
            System.out.print(myArrayList.data[i]);
        }


    }
}
