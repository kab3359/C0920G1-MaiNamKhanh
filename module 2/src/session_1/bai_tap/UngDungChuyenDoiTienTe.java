package session_1.bai_tap;

import java.util.Scanner;

public class UngDungChuyenDoiTienTe {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập usd");
        float usd = scanner.nextFloat();
        System.out.println(usd);
        double vnd = rate * usd;
        System.out.println("vnd: " + vnd);
    }
}
