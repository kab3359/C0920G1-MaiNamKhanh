package session_11.bai_tap.dao_nguoc_phan_tu;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        Stack<Integer> stack = new Stack();
        for (int i=0; i<array.length; i++){
            stack.push(array[i]);
        }
        for (int i=0; i<stack.getSize(); i++){
            array[i] = stack.pop();
        }
        System.out.println(Arrays.toString(array));
    }
}
