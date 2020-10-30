package session_2.thuc_hanh;

import java.util.Scanner;

public class UngDungTienLaiChoVay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền gửi");
        double money = scanner.nextDouble();
        System.out.println("Nhập số tháng");
        int month = scanner.nextInt();
        System.out.println("Nhập lãi suất");
        double interset_rate = scanner.nextDouble();
        double total_interset = 0;
        for (int i=0; i<month; i++){
            total_interset += money * (interset_rate/100)/12 * month;
        }
        System.out.println("số tiền lãi:" + total_interset);
    }
}
