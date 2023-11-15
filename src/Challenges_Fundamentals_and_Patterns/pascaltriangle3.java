package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class pascaltriangle3 {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int[][] arr = array() ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] array() {
        int num = scn.nextInt();
        int[][] arr = new int[num][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                }
                else {
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
                }
            }
        }
        return arr ;
    }
}
