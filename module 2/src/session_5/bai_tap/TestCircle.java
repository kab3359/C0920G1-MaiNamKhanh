package session_5.bai_tap;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập bán kính hình tròn");
        AccessModifier circle = new AccessModifier(input.nextDouble());
        System.out.println("Bán kính hình tròn: " + circle.getRadius());
        System.out.println("Diện tích hình tròn: " + circle.getArea());
    }
}
