package session_3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số phần tử mảng 1");
        int []array1 = new int[input.nextInt()];
        for (int i=0; i<array1.length; i++){
            System.out.println("nhập phần tử thứ " + (i+1) + " của mảng 1: ");
            array1[i] = input.nextInt();
        }
        System.out.println("mảng 1 sau khi nhập: " + Arrays.toString(array1));
        System.out.println("Nhập số phần tử mảng 2");
        int []array2 = new int[input.nextInt()];
        for (int i=0; i<array2.length; i++){
            System.out.println("Nhập phần tử thứ " + (i+1) + " của mảng 2: ");
            array2[i] = input.nextInt();
        }
        System.out.println("mảng 2 sau khi nhập: " + Arrays.toString(array2));
        int []array3 = new int[array1.length + array2.length];
        for (int i=0; i<array1.length; i++){
            array3[i] = array1[i];
        }
        for (int i=array1.length, j=0; i<array3.length; i++, j++){
            array3[i] = array2[j];
        }
        System.out.println("Mảng sau khi gộp: " + Arrays.toString(array3));
    }
}
