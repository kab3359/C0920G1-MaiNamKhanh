package session_1.bai_tap;

import java.util.Scanner;

public class ReadNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số");
        int number = scanner.nextInt();
        if (number >= 0 && number <= 10){
            switch (number){
                case 0:
                    System.out.println("không");
                    break;
                case 1:
                    System.out.println("một");
                break;
                case 2:
                    System.out.println("hai");
                break;
                case 3:
                    System.out.println("ba");
                    break;
                case 4:
                    System.out.println("bốn");
                    break;
                case 5:
                    System.out.println("năm");
                    break;
                case 6:
                    System.out.println("sáu");
                    break;
                case 7:
                    System.out.println("bảy");
                    break;
                case 8:
                    System.out.println("tám");
                    break;
                case 9:
                    System.out.println("chín");
                    break;
                case 10:
                    System.out.println("mười");
                    break;
            }
        }
    }

    public static void twoNum(int number) {
        if (number > 10 && number < 20){
            switch (number){
                case 11:
                    System.out.println("mười một");
                    break;
                case 12:
                    System.out.println("mười hai");
                    break;
                case 13:
                    System.out.println("mười ba");
                    break;
                case 14:
                    System.out.println("mười bốn");
                    break;
                case 15:
                    System.out.println("mười lăm");
                    break;
                case 16:
                    System.out.println("mười sáu");
                    break;
                case 17:
                    System.out.println("mười bảy");
                    break;
                case 18:
                    System.out.println("mười tám");
                    break;
                case 19:
                    System.out.println("mười chín");
                    break;
            }
        }else if (number >= 20 && number < 100){
            int twoNum = number/10;
            int soDu = number % 10;
            switch (twoNum){
                case 2:
                    System.out.print("hai");
                    break;
                case 3:
                    System.out.print("ba");
                    break;
                case 4:
                    System.out.print("bốn");
                    break;
                case 5:
                    System.out.print("năm");
                    break;
                case 6:
                    System.out.print("sáu");
                    break;
                case 7:
                    System.out.print("bảy");
                    break;
                case 8:
                    System.out.print("tám");
                    break;
                case 9:
                    System.out.print("chín");
                    break;
            }
            switch (soDu) {
                case 1:
                    System.out.println("mốt");
                    break;
                case 2:
                    System.out.println("hai");
                    break;
                case 3:
                    System.out.println("ba");
                    break;
                case 4:
                    System.out.println("bốn");
                    break;
                case 5:
                    System.out.println("năm");
                    break;
                case 6:
                    System.out.println("sáu");
                    break;
                case 7:
                    System.out.println("bảy");
                    break;
                case 8:
                    System.out.println("tám");
                    break;
                case 9:
                    System.out.println("chín");
                    break;
            }
        }
    }
}
