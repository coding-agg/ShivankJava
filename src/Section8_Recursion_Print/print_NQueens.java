package Section8_Recursion_Print;

import java.util.Scanner;

public class print_NQueens {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int n = scn.nextInt() ;
        boolean[][] board = new boolean[n][n] ;
        countNQueens(board,0,"");
    }
    public static void countNQueens(boolean[][] board,int row,String str){
        if(row==board.length){
            System.out.println(str);
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if(isItSafe(board,row,col)){
                board[row][col] = true;
                countNQueens(board,row+1,str+(row+1)+"-"+(col+1)+", ");
                board[row][col] = false;
            }
        }
    }
    private static boolean isItSafe(boolean[][] board,int row,int col){
        for (int i = row; i >=0; i--) {
            if(board[i][col]){
                return false ;
            }
        }
        for (int i = row,j=col; i >=0&&j>=0 ; i--,j--) {
            if(board[i][j]){
                return false;
            }
        }
        for (int i = row,j=col; i >=0&&j<board.length ; i--,j++) {
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }
}
