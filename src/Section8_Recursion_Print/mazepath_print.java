package Section8_Recursion_Print;

import java.util.Scanner;

public class mazepath_print {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        mazepath(0,0,scn.nextInt(),"");
    }
    public static void mazepath(int row,int col,int last,String ans){
        if(row>last || col>last){
            return ;
        }
        if(row==last && col==last){
            System.out.println(ans);
            return ;
        }
        mazepath(row+1,col,last,ans+"V");
        mazepath(row,col+1,last,ans+"H");
    }
}
