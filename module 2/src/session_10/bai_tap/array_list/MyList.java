package session_10.bai_tap.array_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    public MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity){
        elements = new Object[capacity];
    }
    public void add(int index, E element){
        if (size == elements.length){
            ensureCapa();
        }elements[size++] = element;
    }
    private void ensureCapa(){
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("index " + index + " ngoài giới hạn");
        }
    }
    public E remove(int index){
        checkIndex(index);
        E e = (E) elements[index];
        for (int i = index; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }
    public int size(){
        return size;
    }
    public E clone(){
        return (E) elements.clone();
    }
    public boolean contains(E o){
        for(int i = 0; i < size; i++){
            if(o.equals(elements[i])){
                return true;
            }
        }return false;
    }
    public int indexOf(E o){
        for(int i=0; i < size; i++){
            if(o.equals(elements[i])){
                return i;
            }
        }return -1;
    }
    public boolean add(E e){
        if (size == elements.length){
            ensureCapa();
        }elements[size++] = e;
        return true;
    }
    public void ensureCapacity(int minCapacity){
        int newSize = elements.length;
        while (newSize < minCapacity){
            newSize *= 2;
        }
        elements = new Object[newSize];
    }
    public E get(int i){
        checkIndex(i);
        return (E) elements[i];
    }
    public void clear(){
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyList{");
        sb.append("size=").append(size);
        sb.append(", elements=").append(Arrays.toString(elements));
        sb.append('}');
        return sb.toString();
    }

}
