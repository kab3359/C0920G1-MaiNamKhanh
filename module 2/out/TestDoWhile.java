package _02_loop_array;

import java.util.Scanner;

public class TestDoWhile {
//    1. Show lesson today
//2. Test loop
//3. Input array
//4. Show array

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("1. Show lesson today");
            System.out.println("2. Test loop");
            System.out.println("3. Input array");
            System.out.println("4. Show array");
            System.out.println("5. Exit");
            System.out.println("---Please choose: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("LOOP & ARRAY");
                    break;
                case 2:
                    System.out.println("TEST LOOP");
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }

//            if (choice == 5) {
//                break;
//            }
        } while (choice != 5);

    }
}
