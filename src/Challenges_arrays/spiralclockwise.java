package Challenges_arrays;

import java.util.Scanner;

public class spiralclockwise {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int[][] arr = array() ;
        spiral(arr) ;
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
    public static void spiral(int[][] arr){
        int top = 0 ;
        int bottom = arr.length-1 ;
        int left = 0 ;
        int right = arr[0].length-1 ;
        int count = 1 ;
        int num = (bottom+1)*(right+1) ;
        while(bottom>=top && right>=left){
            if(num>0){
                if(count==1){
                    for (int i = left; i <= right; i++) {
                        System.out.print(arr[top][i]+", ");
                        num-- ;
                    }
                    top++ ;
                    count=2 ;
                }
            }
            if(num>0){
                if(count==2){
                    for (int i = top; i <= bottom; i++) {
                        System.out.print(arr[i][right]+", ");
                        num-- ;
                    }
                    right-- ;
                    count=3 ;
                }
            }
            if(num>0){
                if(count==3){
                    for (int i = right; i >=left ; i--) {
                        System.out.print(arr[bottom][i]+", ");
                        num-- ;
                    }
                    bottom-- ;
                    count=4 ;
                }
            }
            if(num>0){
                if(count==4){
                    for (int i = bottom; i >=top ; i--) {
                        System.out.print(arr[i][left]+", ");
                        num-- ;
                    }
                    left++ ;
                    count=1 ;
                }
            }
        }
        System.out.print("END");
    }
}
