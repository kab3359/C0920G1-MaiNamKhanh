package _02_loop_array;

import java.util.Arrays;
import java.util.Scanner;

public class TestArray {
    public static void main(String[] args) {
        // C1
        int[] arrayInt = new int[3];
//        int arrayInt4[] = new int[5];
        int[][] arrayTwoInt = new int[3][2];

        // C2
        int[] arrayInt2 = {2, 3, 4, 5};
        int[] arrayInt3 = new int[]{2, 3, 4, 5};


        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println("Please input a[" + i + "]: ");
            arrayInt[i] = scanner.nextInt();
        }

        arrayInt[3] = scanner.nextInt();

        for (int i = 0; i < arrayInt.length; i++) {
            System.out.println(arrayInt[i]);
        }

//        for (int number : arrayInt) {
//            System.out.println(number);
//        }

//        System.out.println(Arrays.toString(arrayInt));


//        int[][] arrayTwoInt2 = {
//                {3, 2, 1},
//                {4, 5}
//        };

//        for (int i = 0; i < arrayTwoInt2.length; i++) {
//            for (int j = 0; j < arrayTwoInt2[i].length; j++) {
//                System.out.println(arrayTwoInt2[i][j]);
//            }
//        }

//        for (int i = 0; i < arrayTwoInt2.length; i++) {
//            System.out.println(Arrays.toString(arrayTwoInt2[i]));
//        }

        String[] arrStr = {"abc", "xyz"};
    }
}
