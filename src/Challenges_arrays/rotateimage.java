package Challenges_arrays;

import java.util.Scanner;

public class rotateimage {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int[][] arr = array() ;
        for (int i = arr.length-1; i >=0; i--) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }
    public static int[][] array(){
        int n = scn.nextInt() ;
        int[][] arr = new int[n][n] ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        return arr ;
    }
}
