package session_3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số phần tử của mảng");
        int []array = new int[input.nextInt()];
        for (int i=0; i<array.length; i++){
            System.out.println("nhập phần tử thứ " + (i+1) + ": ");
            array[i] = input.nextInt();
        }
        System.out.println("Mảng sau khi nhập: " + Arrays.toString(array));
        System.out.println("Nhập số cần chèn");
        int x = input.nextInt();
        System.out.println("Nhập vị trí cần chèn");
        int index = input.nextInt();
        if (index <= 1 || index > array.length){
            System.out.println("ko chèn dc phần tử vào mảng");
        }else {
            for (int i=array.length-1; i>=index-1; i--){
                if (i==index-1){
                    array[i] = x;
                }else {
                    array[i] = array[i-1];
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
