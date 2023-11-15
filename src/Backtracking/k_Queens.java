package Backtracking;

import java.util.Scanner;

public class k_Queens {
    static Scanner scn = new Scanner(System.in);
    public static int number = 0;

    public static void main(String[] args) {
        int N = scn.nextInt();
        int queens = scn.nextInt();
        boolean[][] arr = new boolean[N][N];
        k_queens(arr,0,0,queens,"");
    }
    public static void k_queens(boolean[][] arr,int row,int qp,int tq,String str){
        if(qp==tq){
            number++;
            System.out.println(number+" "+str);
            return;
        }
        if(row==arr.length){
            return;
        }

        for (int col = 0; col <arr[row].length ; col++) {
            if(queen_at_position(arr,row,col)){
                arr[row][col]=true;
                k_queens(arr,row+1,qp+1,tq,str+"{"+row+","+col+"} ");
                arr[row][col]=false;
            }
        }
        k_queens(arr,row+1,qp,tq,str);
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
