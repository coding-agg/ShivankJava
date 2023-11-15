package Backtracking;

import java.util.Scanner;

public class N_queens_placement {
    public static int number = 0 ;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scn.nextInt();
        queen_row_placement("",0,0,0,N,N);
    }
    public static void queen_row_placement(String str, int num, int row, int col, int ini_row, int ini_col){
        if(num==ini_row){
            number++;
            System.out.println(number+" "+str);
            return;
        }
        if(col==ini_col){
            queen_row_placement(str,num,row+1,0,ini_row,ini_col);
            return;
        }
        if(row==ini_row){
            return;
        }
        queen_row_placement(str+"queen"+num+" at row"+row+" col"+col+" , " ,num+1,row+1,0,ini_row,ini_col);
        queen_row_placement(str,num,row,col+1,ini_row,ini_col);
    }
}
