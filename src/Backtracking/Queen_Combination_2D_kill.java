package Backtracking;

import java.util.Scanner;

public class Queen_Combination_2D_kill {
    static Scanner scn = new Scanner(System.in);
    public static int number = 0;

    public static void main(String[] args) {
        int row = scn.nextInt();
        int col = scn.nextInt();
        boolean[][] arr = new boolean[row][col];
        int queen_num = scn.nextInt();
        queen_2d_kill(arr,0,0,0,"",row,col,queen_num);
    }
    public static void queen_2d_kill(boolean[][] arr,int num,int row,int col,String str,int ini_row,int ini_col,int queen_num){
        if(num==queen_num){
            number++;
            System.out.println(number+" "+str);
            return;
        }
        if(col==ini_col){
            row++;
            col = 0;
        }
        if(row==ini_row){
            return;
        }
        if(queen_at_position(arr,row,col)){
            arr[row][col]=true;
            queen_2d_kill(arr,num+1,row+1,0,str+"{"+row+","+col+"}",ini_row,ini_col,queen_num);
            arr[row][col]=false;
        }
        queen_2d_kill(arr,num,row,col+1,str,ini_row,ini_col,queen_num);
    }
    public static boolean queen_at_position(boolean[][] arr,int row,int col){
        for (int i = 0; i < 1; i++) {
            for (int j = row-1; j >=0 ; j--) {
                if(arr[j][col]){
                    return false;
                }
            }
            for (int j=row-1,k=col-1; j>=0 && k>=0 ; j--,k--) {
                if(arr[j][k]){
                    return false;
                }
            }
            for (int j=row-1,k=col+1; j>=0 && k<arr[0].length ; j--,k++) {
                if(arr[j][k]){
                    return false;
                }
            }
        }
        return true;
    }
}
