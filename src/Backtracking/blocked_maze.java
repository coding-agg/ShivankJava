package Backtracking;

import java.util.Scanner;

public class blocked_maze {
    static Scanner scn = new Scanner(System.in);
    public static int number = 0;

    public static void main(String[] args) {
        int[][] arr = new int[scn.nextInt()][2];
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = scn.nextInt();
            arr[i][1] = scn.nextInt();
        }
        int row = scn.nextInt();
        int col = scn.nextInt();
        boolean[][] array = new boolean[row][col];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            array[arr[i][0]][arr[i][1]] = false;
        }
        blocked_maze_func(array,0,0,"");
    }
    public static void blocked_maze_func(boolean[][] arr, int row, int col, String str){
        if(row==arr.length-1 && col == arr[0].length-1){
            number++;
            System.out.println(number+" "+str);
            return;
        }
        if(col>arr[0].length-1 || row>arr.length-1 || row<0 || col<0){
            return;
        }
        if(arr[row][col]) {
            arr[row][col] = false;
            blocked_maze_func(arr, row + 1, col, str + "Down ");
            blocked_maze_func(arr, row, col + 1, str + "Right ");
            blocked_maze_func(arr, row - 1, col, str + "Upwards ");
            blocked_maze_func(arr, row, col - 1, str + "Left ");
            arr[row][col] = true;
        }
    }
}
