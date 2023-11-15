package Challenges_arrays;

import java.util.Scanner;

public class primevisits {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = array();
        int big = 0 ;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][1]>big){
                big = arr[i][1];
            }
        }
        boolean[] prime = soe(big);
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            if(a<2){
                a = 2;
            }
            int counter = 0;
            for (int j = a; j <=b; j++) {
                if(prime[j]){
                    counter++;
                }
            }
            System.out.println(counter);
        }
    }
    public static int[][] array(){
        int test = scn.nextInt();
        int[][] arr = new int[test][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j]=scn.nextInt();
            }
        }
        return arr;
    }
    public static boolean[] soe(int n){
        boolean[] array = new boolean[n+1];
        for (int i = 2; i < array.length; i++) {
            array[i] = true ;
        }
        for (int i = 2; i*i<=array.length-1; i++) {
            if(array[i]){
                for (int j = 2; j*i <=array.length-1 ; j++) {
                    array[i*j]=false;
                }
            }
        }
        return array;
    }
}
