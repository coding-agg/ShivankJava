package Section8_Recursion_Print;

import java.util.Scanner;

public class permutation_print {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        printper(scn.nextLine(),"");
    }
    public static void printper(String str, String result){
        if(str.length()==0){
            System.out.println(result);
            return ;
        }
        for (int i = 0; i <str.length(); i++) {
            printper(str.substring(0,i)+str.substring(i+1),result+str.substring(i,i+1)) ;
        }
    }
}
