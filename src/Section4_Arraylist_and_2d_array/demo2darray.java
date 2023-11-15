package Section4_Arraylist_and_2d_array;

import java.util.Scanner;

public class demo2darray {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int[][] arr = input() ;
        output(arr) ;
    }
    public static int[][] input(){
        int[][] arrsize = new int[scn.nextInt()][] ;
        for (int i = 0; i < arrsize.length; i++) {
            arrsize[i] = new int[scn.nextInt()] ;
            for (int j = 0; j < arrsize[i].length; j++) {
                arrsize[i][j] = scn.nextInt() ;
            }
        }
        return arrsize ;
    }
    public static void output(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
