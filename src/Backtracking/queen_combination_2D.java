package Backtracking;

import java.util.Scanner;

public class queen_combination_2D {
    static Scanner scn = new Scanner(System.in);
    public static int number = 0;

    public static void main(String[] args) {
        int row = scn.nextInt();
        int col = scn.nextInt();
        boolean[][] arr= new boolean[row][col];
        queen_2d(arr,0,0,"",-1);
    }
    public static void queen_2d(boolean[][] arr,int num,int ini,String str,int ini2){
        if(num==2){
            number++;
            System.out.println(number+" "+str);
            return;
        }
        for (int i = ini; i < arr.length; i++) {
            int k = ini2+1;
            if(i>ini){
                k = 0;
            }
            for (int j = k; j < arr[i].length; j++) {
                arr[i][j]=true;
                queen_2d(arr,num+1,i,str+" queen"+num+" at row"+i+" at col"+j+",",j);
            }
        }
    }
}
