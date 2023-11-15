package Backtracking;

import java.util.Scanner;

public class queen_combination_2D_boxrespect {
    static Scanner scn = new Scanner(System.in);
    public static int number = 0;

    public static void main(String[] args) {
        int ini_row = scn.nextInt();
        int ini_col = scn.nextInt();
        queen_2d_boxrespect("",0,0,0,ini_row,ini_col);
    }
    public static void queen_2d_boxrespect(String str,int num,int row,int col,int ini_row,int ini_col){
        if(num==2){
            number++;
            System.out.println(number+" "+str);
            return;
        }
        if(col==ini_col){
            queen_2d_boxrespect(str,num,row+1,0,ini_row,ini_col);
            return;
        }
        if(row==ini_row){
            return;
        }
        queen_2d_boxrespect(str+"queen"+num+" at row"+row+" col"+col+" , " ,num+1,row,col+1,ini_row,ini_col);
        queen_2d_boxrespect(str,num,row,col+1,ini_row,ini_col);
    }
}
