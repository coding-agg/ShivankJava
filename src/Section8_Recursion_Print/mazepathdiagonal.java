package Section8_Recursion_Print;

import java.util.Scanner;

public class mazepathdiagonal {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        mazepathdiagonal(0,0,scn.nextInt(),"");
    }
    public static void mazepathdiagonal(int row, int col, int last, String ans){
        if(row>last || col>last){
            return ;
        }
        if(row==last && col==last){
            System.out.println(ans);
            return ;
        }
        mazepathdiagonal(row+1,col,last,ans+"V");
        mazepathdiagonal(row,col+1,last,ans+"H");
        mazepathdiagonal(row+1,col+1,last,ans+"D") ;
    }
}
