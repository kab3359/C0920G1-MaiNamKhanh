package session_11.bai_tap.dao_nguoc_phan_tu;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Wstack<T> {
    private LinkedList<String> stack;
    private int size =0;

    public Wstack(){
        stack = new LinkedList<>();
    }


    public void push(String element){
        stack.addFirst(element);
        size++;
    }
    public String pop(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.pop();
    }
    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
    public int getSize(){
        return this.size;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(stack);
        return sb.toString();
    }
}
