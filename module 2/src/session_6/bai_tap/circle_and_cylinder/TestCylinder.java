package session_6.bai_tap.circle_and_cylinder;

import java.util.Scanner;

public class TestCylinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập bán kính");
        double radius = input.nextDouble();
        System.out.println("nhập màu");
        input.nextLine();
        String color = input.nextLine();
        System.out.println("nhập chiều cao");
        double height = input.nextDouble();
        Circle cylinder = new Cylinder(radius, color, height);
        System.out.println(cylinder);
    }
}
