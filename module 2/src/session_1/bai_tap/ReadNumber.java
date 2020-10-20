package session_1.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số");
        int number = scanner.nextInt();
        if (number >= 0 && number <= 10){
            switch (number){
                case 1:
                    System.out.println("một");
                break;
                case 2:
                    System.out.println("hai");
                break;
                case 3:
                    System.out.println("ba");
            }
        }
    }
}
