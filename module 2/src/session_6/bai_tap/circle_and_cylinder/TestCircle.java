package session_6.bai_tap.circle_and_cylinder;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập bán kính");
        double radius = input.nextDouble();
        System.out.println("nhập màu");
        input.nextLine();
        String color = input.nextLine();
        Circle circle = new Circle(radius, color);
        System.out.println(circle);
    }
}
