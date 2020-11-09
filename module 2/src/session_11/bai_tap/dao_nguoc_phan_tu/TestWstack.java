package session_11.bai_tap.dao_nguoc_phan_tu;

import java.util.Scanner;
import java.util.Stack;

public class TestWstack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        java.util.Stack<String> stack = new Stack<>();
        String string = input.nextLine();
        String[] mWord = string.split(" ",string.length());
        String str = "";
        for (String array: mWord){
            stack.push(array);
        }
//        System.out.println(stack);
        for (int i=0; i<mWord.length; i++){
            mWord[i] = stack.pop();
            str += mWord[i] + " ";
        }
//        System.out.println(Arrays.toString(mWord));
        System.out.println(str);
    }
}
