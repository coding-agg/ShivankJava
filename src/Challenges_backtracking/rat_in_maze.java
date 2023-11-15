package Challenges_backtracking;

import java.util.Scanner;

public class rat_in_maze {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        Character[][] arr = array();
        rat_in(arr,0,0,arr.length,arr[0].length,"");
    }
    public static Character[][] array(){
        Character[][] arr = new Character[scn.nextInt()][scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            String str = scn.next();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        return arr;
    }
    public static void rat_in(Character[][] arr,int col,int row,int final_row,int final_col,String str){
        if(row==final_row-1 && col==final_col-1){
            System.out.println(str);
            return;
        }
        if(row>=final_row || col>=final_col || arr[row][col]=='X'){
            return;
        }
        rat_in(arr,col,row+1,final_row,final_col,str+"D");
        rat_in(arr,col+1,row,final_row,final_col,str+"R");
    }
}
