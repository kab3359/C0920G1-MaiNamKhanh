package session_2.thuc_hanh;

import java.util.Scanner;

public class TimUocChungLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a:");
        int a = scanner.nextInt();
        System.out.println("Enter b:");
        int b = scanner.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        System.out.println(a);
        System.out.println(b);
        if (a==0 || b==0){
            System.out.println("không có ước chung lớn nhất");
        }
        int num = 0;
        if (a < b){
            for (int i = 1; i <= a; i++){
                if (a % i == 0){
                    if (b % i == 0){
                        num = i;
                    }
                }
            }
        } else {
            for (int i = 1; i <= b; i++){
                if (b % i == 0){
                    if (a % i == 0){
                        num = i;
                    }
                }
            }
        }
        System.out.println("Ước chung lớn nhất là:" + num);
    }
}
