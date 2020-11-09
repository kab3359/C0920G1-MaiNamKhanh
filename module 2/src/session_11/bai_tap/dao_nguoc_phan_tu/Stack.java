package session_11.bai_tap.dao_nguoc_phan_tu;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<Integer> stack;
    private int size =0;

    public Stack(){
        stack = new LinkedList<>();
    }


    public void push(int element){
            stack.addFirst(element);
            size++;
    }
    public Integer pop(){
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
}
