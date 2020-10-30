package session_6.bai_tap.point_and_moveablepoint;

import java.util.Scanner;

public class TestMoveablePoint {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập x");
        float x = input.nextFloat();
        System.out.println("nhập y");
        float y = input.nextFloat();
        Point point = new Point(x, y);
        System.out.println(point);
        System.out.println("nhâp xSpeed");
        float xSpeed = input.nextFloat();
        System.out.println("nhập ySpeed");
        float ySpeed = input.nextFloat();
        MoveablePoint moveablePoint = new MoveablePoint(x, y, xSpeed, ySpeed);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
    }
}
