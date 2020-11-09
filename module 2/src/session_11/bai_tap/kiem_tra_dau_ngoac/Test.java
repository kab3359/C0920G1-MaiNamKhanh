package session_11.bai_tap.kiem_tra_dau_ngoac;

import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack bStack = new Stack();
        Scanner input = new Scanner(System.in);
        System.out.println("nhập biểu thức");
        String string = input.nextLine();
        Object sym = "";
        Object left;
        Boolean check = true;
        for (int i=0; i<string.length(); i++){
            if( string.charAt(i) == '('){
                bStack.push(string.charAt(i));
                sym = '(';
            } else if(string.charAt(i) == ')'){
                if(bStack.isEmpty()){
                    check = false;
                }else {
                    left = bStack.pop();
                    if(left != sym){
                        check = false;
                    }
                }
            }
        }
        if(bStack.isEmpty() && check){
            System.out.println("đúng");
        }else {
            System.out.println("sai");
        }
    }
}
