package session_2.bai_tap;

import java.util.Scanner;

public class HienThiSoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập số lượng số nguyên tố cần hiển thị");
        int number = input.nextInt();
        int count = 0;
        int n = 2;
        boolean check = true;
        while (count <= number){
            for(int i=2; i<=n-1; i++){
                if(n % i == 0){
                    check = false;
                    break;
                }
            }
            if (check){
                count++;
                System.out.print(n + " ");
            }n++;
            check = true;
        }
    }
}
