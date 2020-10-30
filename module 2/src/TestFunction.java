package _02_loop_array;

public class TestFunction {
    public static void printA(int a) {
        System.out.println(a);
    }

    public static String getString(String b) {
        int a = 3;
        String c = "Hello World";

        return c;
    }

    public static void main(String[] args) {
        System.out.println(23000 * (float) 2.566);
        System.out.println(Math.round(23000 * (double) 2.566));

        int a = 1;
        int count = 0;
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                count++;
            }
        }

        if (count == 2) {
            System.out.println("So nguyen to");
        } else {
            System.out.println("No");
        }
    }
}
