package Backtracking;

import java.util.Scanner;

public class N_Knights_kill {
    public static int number = 0;
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scn.nextInt();
        boolean[][] arr = new boolean[N][N];
        knights_2d_kill(arr,0,0,0,"",N);
    }
    public static void knights_2d_kill(boolean[][] arr, int num, int row, int col, String str, int N){
        if(num==N){
            number++;
            System.out.println(number+" "+str);
            return;
        }
        if(col==N){
            knights_2d_kill(arr,num,row+1,0,str,N);
            return;
        }
        if(row==N){
            return;
        }
        if(knight_at_position(arr,row,col,N)){
            arr[row][col]=true;
            knights_2d_kill(arr,num+1,row,col+1,str+"{"+row+","+col+"}"+" ",N);
            arr[row][col]=false;
        }
        knights_2d_kill(arr,num,row,col+1,str,N);
    }
    public static boolean knight_at_position(boolean[][] arr,int row,int col,int N){
        for (int i = 0; i < 1; i++) {
            if(row-1>=0 && col-2>=0 && arr[row-1][col-2]){
                return false;
            }
            if(row-2>=0 && col-1>=0 && arr[row-2][col-1]){
                return false;
            }
            if(row-2>=0 && col+1<N && arr[row-2][col+1]){
                return false;
            }
            if(row-1>=0 && col+2<N && arr[row-1][col+2]){
                return false;
            }
        }
        return true;
    }

}
