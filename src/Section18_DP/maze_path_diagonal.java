package Section18_DP;

import java.util.Scanner;

public class maze_path_diagonal {
    static Scanner scn = new Scanner(System.in);
    public static long start;
    public static long end;
    public static void startAlgo(){
        start = System.currentTimeMillis();
    }
    public static long endAlgo(){
        end = System.currentTimeMillis();
        return end-start;
    }
    public static void main(String[] args) {
        int destrow = scn.nextInt();
        int destcol = scn.nextInt();
        int[][] strg = new int[destrow+1][destcol+1];
        startAlgo();
        System.out.println(getMazePath_diag(0,0,destrow,destcol));
        System.out.println("mazepath normal "+endAlgo()+" ms");

        startAlgo();
        System.out.println(MazePath_diag(0,0,destrow,destcol,strg));
        System.out.println("mazepath dp "+endAlgo()+" ms");

        startAlgo();
        System.out.println(mazepath_diagLI(destrow,destcol));
        System.out.println("mazepath IS "+endAlgo()+" ms");

    }
    public static int getMazePath_diag(int row, int col, int destrow, int destcol){
        if(row==destrow && col == destcol){
            return 1 ;
        }
        if(row>destrow || col>destcol){
            return 0 ;
        }
        int ans1 = getMazePath_diag(row+1,col,destrow,destcol) ;

        int ans2 = getMazePath_diag(row,col+1,destrow,destcol) ;

        int ans3 = getMazePath_diag(row+1,col+1,destrow,destcol);

        return ans1+ans2+ans3 ;
    }
    public static int MazePath_diag(int row, int col, int destrow, int destcol, int[][] strg){
        if(row==destrow && col == destcol){
            return 1 ;
        }
        if(row>destrow || col>destcol){
            return 0 ;
        }
        if(strg[row][col]!=0){
            return strg[row][col];
        }
        int ans1 = MazePath_diag(row+1,col,destrow,destcol,strg) ;

        int ans2 = MazePath_diag(row,col+1,destrow,destcol,strg) ;

        int ans3 = MazePath_diag(row+1,col+1,destrow,destcol,strg);
        strg[row][col] = ans1+ans2+ans3;

        return ans1+ans2+ans3 ;
    }
    public static int mazepath_diagLI(int row, int col){
        int[][] strg = new int[row+1][col+1];
        for (int i = 0; i <= row; i++) {
            strg[i][col] = 1;
        }
        for (int i = 0; i <= col; i++) {
            strg[row][i] = 1;
        }
        for (int i = row-1; i >=0; i--) {
            for (int j = col-1; j >=0; j--) {
                strg[i][j] = strg[i+1][j] + strg[i][j+1] + strg[i+1][j+1];
            }
        }
        return strg[0][0];
    }
}
