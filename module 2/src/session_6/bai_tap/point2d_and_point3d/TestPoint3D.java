package session_6.bai_tap.point2d_and_point3d;

import java.util.Scanner;

public class TestPoint3D {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập x");
        float x = input.nextFloat();
        System.out.println("nhập y");
        float y = input.nextFloat();
        System.out.println("nhập z");
        float z = input.nextFloat();
        Point3D point3D = new Point3D(x, y, z);
        System.out.println(point3D);
    }
}
