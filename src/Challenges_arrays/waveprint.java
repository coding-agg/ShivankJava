package Challenges_arrays;

import java.util.Scanner;

public class waveprint {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int[][] arr = array() ;
        waveprint(arr) ;
    }
    public static void waveprint(int[][] arr){
        for (int top = 0; top < arr.length; top++) {
            if(top%2 == 0){
                for (int i = 0; i < arr[top].length; i++) {
                    System.out.print(arr[top][i]+", ");
                }
            }else{
                for (int i = arr[top].length-1; i>=0 ; i--) {
                    System.out.print(arr[top][i]+", ");
                }
            }
        }
        System.out.print("END");
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
}
