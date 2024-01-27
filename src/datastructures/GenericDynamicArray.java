package datastructures;

public class GenericDynamicArray <T>{
    private Object [] storage;
    private int size;
    private static  final  int CAPACITY = 16;
    public GenericDynamicArray(T[] array){

        this.storage = array;
    }
    GenericDynamicArray(T[] array,int size) {
        if (size > 0)
            this.storage = array;
            this.size = size;
    }

    public GenericDynamicArray() {
        this.storage = new Object[CAPACITY];
    }

    //returns count of elements added in to DynamicArray
    public int size() {
        return size;
    }

    //return true if is empty
    public boolean isEmpty() {
        return size <= 0;
    }

    // returns true if the value is exist in the DynamicArray
    public boolean contains(T val) {
        for (int i = 0; i < size; i++) {
            if (storage[i] == val) {
                return true;
            }
        }
        return false;
    }

    // returns the element by specified index
    public <T> Object get(int index) {
        try {
            return storage[index];
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Array index out of bounds");
        }
        return null;
    }


    // sets the specified val by the specified index
    public void set(int index, T val) {
        if (index <= 0 || index<= size) {
            System.out.println("Error");
            return;
        }else {
            storage[index] = val;
        }
    }

    public void add(T element) {
        if (size == storage.length){
            growSize();
        }
        storage[size++] = element;
    }


    public void add(int index, T element) {
        if (size == storage.length){
            growSize();
        }
        for (int i =size; i >= index; i--) {
            storage[i + 1] = storage[i];
        }
        size++;
        storage[index] = element;

    }
    public void removeByIndex(int index) {
        for (int i = index; i <size-1; i++) {
            storage[i] = storage[i+1];
        }
        size--;
    }
    /**
     * Removes the first element which is equal to specified element
     * Shifts any subsequent elements to the left
     */
    public void remove(T element) {
        for (int i = 0; i <size; i++) {
            if (storage[i].equals(element)) {
                removeByIndex(i);
                return;
            }
        }
        System.out.println("That element was not found");
    }
    private void growSize(){
       Object[] temp = new Object[storage.length + (storage.length / 2)];
        System.arraycopy(storage, 0, temp, 0, size);
        storage = temp;
    }
}
