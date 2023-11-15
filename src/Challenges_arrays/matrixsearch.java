package Challenges_arrays;

import java.util.Scanner;

public class matrixsearch {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int[][] arr = array() ;
        int item = matrix(arr) ;
        System.out.println(item);
    }
    public static int[][] array(){
        int[][] arr = new int[scn.nextInt()][scn.nextInt()] ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scn.nextInt() ;
            }
        }
        return arr ;
    }
    public static int matrix(int[][] arr){
        int item = scn.nextInt() ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(item == arr[i][j]){
                    return 1 ;
                }
            }
        }
        return 0 ;
    }
}
