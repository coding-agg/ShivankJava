package Section8_Recursion_Print;

import java.util.Scanner;

public class boardpath_print {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        boardpath(0,scn.nextInt(),"");
    }
    public static void boardpath(int curr,int end,String ans){
        if(curr==end){
            System.out.println(ans);
            return;
        }
        if(curr>end){
            return ;
        }
        for (int i = 1; i <= 6; i++) {
            boardpath(curr+i,end,ans+i);
        }
    }
}
