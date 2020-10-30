package session_3.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập số phần tử mảng");
        int []array = new int[input.nextInt()];
        for (int i=0; i<array.length; i++){
            System.out.println("Nhập phần tử thứ " + (i + 1));
            array[i] = input.nextInt();
        }
        System.out.println("Mảng sau khi nhâp: " + Arrays.toString(array));
        System.out.println("nhập phần tử cần xóa");
        int phanTuCanXoa = input.nextInt();
        int index_del = 0;
        int count = 0;
        for (int i=0; i<array.length; i++){
            if (array[i] == phanTuCanXoa){
                count++;
                index_del = i;
                i = 0;
                for (int j=index_del; j<array.length; j++){
                    if(j==array.length-1){
                        array[j] = 0;
                    }else {
                        array[j] = array[j+1];
                    }
                }
            }
        }
        int []newArray = new  int[array.length - count];
        System.arraycopy(array, 0, newArray, 0, array.length - count);
        System.out.println("Mảng sau khi xóa phần tử "+ phanTuCanXoa + " là: " + Arrays.toString(newArray));
    }
}
