package session_2.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Hình chữ nhật");
        System.out.println("2. Tam giác vuông góc ở bot left");
        System.out.println("3. Tam giác vuông góc ở top left");
        System.out.println("4. Tam giác cân");
        System.out.println("5. Exit");
        int choose = input.nextInt();
        switch (choose) {
            case 1:
                System.out.println("Nhập chiều dài hình chữ nhật");
                int width = input.nextInt();
                System.out.println("Nhập chiều rộng hình chữ nhật");
                int height = input.nextInt();
                for (int i = 1; i <= height; i++) {
                    if (i == 1 || i == height) {
                        for (int j = 1; j <= width; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    } else {
                        for (int j = 1; j <= width; j++) {
                            if (j == 1 || j == width) {
                                System.out.print("*");
                            } else {
                                System.out.print(" ");
                            }
                        }
                        System.out.println("");
                    }
                }
                break;
            case 2:
                System.out.println("Nhập chiều cao");
                int chieuCaoTamGiac = input.nextInt();
                for (int i = 0; i <= chieuCaoTamGiac; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
            case 3:
                System.out.println("Nhập chiều cao");
                int chieuCaoTamGiacVuongTopLeft = input.nextInt();
                for (int i=chieuCaoTamGiacVuongTopLeft; i>=0; i--){
                    for (int j=0; j<i; j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
            case 4:
                System.out.println("Nhập chiều cao");
                int chieuCaoTamGiacCan = input.nextInt();
                for (int i=chieuCaoTamGiacCan, k=1; i>0; i--,k++){
                    for (int j=0; j<i; j++){
                        System.out.print(' ');
                    }
                    for (int j=1; j<=2*k-1; j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
        }
    }
}
