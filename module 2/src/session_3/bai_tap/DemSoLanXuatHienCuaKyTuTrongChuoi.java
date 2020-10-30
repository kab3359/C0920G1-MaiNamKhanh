package session_3.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi");
        String string = input.nextLine();
        System.out.println("nhập ký tự");
        char a = input.next().charAt(0);
        int count = 0;
        for (int i=0; i<string.length(); i++){
            if (a == string.charAt(i)){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện của ký tự " + a + " trong mảng là: " + count);
    }
}
