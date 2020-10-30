package session_3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;


public class TimPhanTuLonNhatTrongMang2Chieu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập số phần tử mảng 2 chiều");
        int n = input.nextInt();
        System.out.println("nhập số phần tử mảng con");
        int m = input.nextInt();
        float[][]array = new float[n][m];
        System.out.println(Arrays.toString(array));
        for (int i=0 ; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                System.out.println("nhập phần tử dòng " + (i+1) + " cột " + (j+1));
                array[i][j] = input.nextFloat();
            }
        }
        for (int i=0 ; i<array.length; i++){
            System.out.println(Arrays.toString(array[i]));
        }
        float max = array[0][0];
        int row = 0;
        int col = 0;
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                if (array[i][j] > max){
                    max = array[i][j];
                }
            }
        }
        System.out.println("Phần tử lớn nhất có giá trị là: " + max);
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                if (array[i][j] == max){
                    System.out.println("ở dòng: " + (i+1) + " cột: " + (j+1));
                }
            }
        }
    }
}
