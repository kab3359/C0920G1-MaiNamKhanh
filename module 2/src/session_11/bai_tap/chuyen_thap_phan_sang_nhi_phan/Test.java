package session_11.bai_tap.chuyen_thap_phan_sang_nhi_phan;

import java.util.Scanner;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Stack stack = new Stack();
        final StringBuilder sb = new StringBuilder();
        Scanner input = new Scanner(System.in);
        System.out.println("nhập số thập phân");
        int num = input.nextInt();
        while (num != 0){
            stack.push(num % 2);
            num = Math.round(num) / 2;
        }
        for (int i = 0; i<stack.size();){
            sb.append(stack.pop());
        }
        System.out.println("Số nhị phân: " + sb);
    }
}
