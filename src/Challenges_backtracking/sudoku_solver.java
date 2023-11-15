package Challenges_backtracking;

import java.util.Scanner;

public class sudoku_solver {
    public static int[][] newarr = null;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scn.nextInt();
        int[][] arr = new int[length][length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <arr.length ; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        sudoku(arr,0,0,1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void sudoku(int[][] arr,int row,int col,int num){
        if(col==arr[0].length){
            row++;
            col = 0;
            num = 1;
        }
        if(row==arr.length){
            return;
        }
        while(arr[row][col] == 0 && num<=arr.length) {
                if (isitTrue(arr, row, col, num) && isitsquaretrue(arr, row, col, num)) {
                    arr[row][col] = num;
                    sudoku(arr, row, col+1,1);
                    arr[row][col] = 0;
                }
                num++;
        }
        sudoku(arr, row, col + 1,1);
    }
    public static boolean isitTrue(int[][] arr,int row,int col,int num){
        for (int i = 0; i < arr.length; i++) {
            if(arr[row][i]==num){
                return false;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i][col]==num){
                return false;
            }
        }
        return true;
    }
    public static boolean isitsquaretrue(int[][] arr,int row,int col,int num){
        int low_row = row/3;
        int low_col = col/(arr.length/3);
        for (int i = low_row*3; i <(low_row+1)*3 ; i++) {
            for (int j = low_col*(arr.length/3); j <(low_col+1)*(arr.length/3) ; j++) {
                if(arr[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
