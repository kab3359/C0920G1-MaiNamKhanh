package session_6.bai_tap.thiet_ke_va_trien_khai_lop_triangle;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập độ dài canh 1");
        double side1 = input.nextDouble();
        System.out.println("nhập độ dài canh 2");
        double side2 = input.nextDouble();
        System.out.println("nhập độ dài canh 3");
        double side3 = input.nextDouble();
        System.out.println("nhập màu");
        input.nextLine();
        String color = input.nextLine();
        Triangle triangle = new Triangle(color, side1, side2, side3);
        System.out.println(triangle);
    }
}
