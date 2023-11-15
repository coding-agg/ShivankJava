package Backtracking;

import java.util.Scanner;

public class N_Queens_Kill {
    static Scanner scn = new Scanner(System.in);
    public static int number = 0;

    public static void main(String[] args) {
        int N = scn.nextInt();
        boolean[][] arr = new boolean[N][N];
        queen_2d_kill(arr,0,0,0,"",N);
    }
    public static void queen_2d_kill(boolean[][] arr,int num,int row,int col,String str,int N){
        if(num==N){
            number++;
            System.out.println(number+" "+str);
            return;
        }
        if(col==N){
            row++;
            col = 0;
        }
        if(row==N){
            return;
        }
        if(queen_at_position(arr,row,col,N)){
            arr[row][col]=true;
            queen_2d_kill(arr,num+1,row+1,0,str+"{"+row+","+col+"}",N);
            arr[row][col]=false;
        }
        queen_2d_kill(arr,num,row,col+1,str,N);
    }
    public static boolean queen_at_position(boolean[][] arr,int row,int col,int N){
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
            for (int j=row-1,k=col+1; j>=0 && k<N ; j--,k++) {
                if(arr[j][k]){
                    return false;
                }
            }
        }
        return true;
    }
}
