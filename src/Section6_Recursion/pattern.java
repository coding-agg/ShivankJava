package Section6_Recursion;

import java.util.Scanner;

public class pattern {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int N = scn.nextInt() ;
        pattern(N,1,1);
    }
    public static void pattern(int N ,int column,int row){
        if(N==0){
            return;
        }
        if(column<=row){
            System.out.print("* ");
        }
        if(column==row){
            System.out.println();
            pattern(N-1,1,row+1);
        }
        else if(column<row){
            pattern(N,column+1,row) ;
        }
    }

}
