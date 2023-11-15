package Section18_DP;

import java.util.ArrayList;
import java.util.Scanner;

public class maze_path {
    public static long start;
    public static long end;
    public static void startAlgo(){
        start = System.currentTimeMillis();
    }
    public static long endAlgo(){
        end = System.currentTimeMillis();
        return end-start;
    }
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int destrow = scn.nextInt();
        int destcol = scn.nextInt();
        int[][] strg = new int[destrow+1][destcol+1];
        startAlgo();
        System.out.println(getMazePath(0,0,destrow,destcol));
        System.out.println("mazepath normal "+endAlgo()+" ms");

        startAlgo();
        System.out.println(MazePath(0,0,destrow,destcol,strg));
        System.out.println("mazepath dp "+endAlgo()+" ms");

        startAlgo();
        System.out.println(mazepathLI(destrow,destcol));
        System.out.println("mazepath IS "+endAlgo()+" ms");

    }
    public static int mazepathLI(int row,int col){
        int[][] strg = new int[row+1][col+1];
        for (int i = 0; i < row; i++) {
            strg[i][col] = 1;
        }
        for (int i = 0; i < col; i++) {
            strg[row][i] = 1;
        }
        for (int i = row-1; i >=0; i--) {
            for (int j = col-1; j >=0; j--) {
                strg[i][j] = strg[i+1][j] + strg[i][j+1];
            }
        }
        return strg[0][0];
    }
    public static int getMazePath(int row, int col, int destrow, int destcol){
        if(row==destrow && col == destcol){
            return 1 ;
        }
        if(row>destrow || col>destcol){
            return 0 ;
        }
        int ans1 = getMazePath(row+1,col,destrow,destcol) ;

        int ans2 = getMazePath(row,col+1,destrow,destcol) ;

        return ans1+ans2 ;
    }
    public static int MazePath(int row,int col,int destrow,int destcol,int[][] strg){
        if(row==destrow && col == destcol){
            return 1 ;
        }
        if(row>destrow || col>destcol){
            return 0 ;
        }
        if(strg[row][col]!=0){
            return strg[row][col];
        }
        int ans1 = MazePath(row+1,col,destrow,destcol,strg) ;

        int ans2 = MazePath(row,col+1,destrow,destcol,strg) ;
        strg[row][col] = ans1+ans2;

        return ans1+ans2 ;
    }

}
