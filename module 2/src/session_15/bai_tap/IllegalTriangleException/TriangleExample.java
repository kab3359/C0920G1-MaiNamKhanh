package session_15.bai_tap.IllegalTriangleException;

import java.util.Scanner;

public class TriangleExample {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner input = new Scanner(System.in);
        Triangle triangle = new Triangle();
        boolean done = false;
        System.out.println("nhập x");
        double x = input.nextDouble();
        System.out.println("nhập y");
        double y = input.nextDouble();
        System.out.println("nhâp z");
        double z = input.nextDouble();
        while (!done){
            try {
                triangle = new Triangle(x, y, z);
                done = true;
            }catch (IllegalTriangleException e){
                System.err.println(e.getMessage());
                System.out.println("nhập x");
                x = input.nextInt();
                System.out.println("nhập y");
                y = input.nextInt();
                System.out.println("nhâp z");
                z = input.nextInt();
            }
        }

    }

}
