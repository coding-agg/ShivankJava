package Section8_Recursion_Print;

import java.util.Scanner;

public class subsequences_print {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        subsequences(scn.nextLine(),"");
    }
    public static void subsequences(String str,String result){
        if(str.length()==0){
            System.out.println(result);
            return;
        }
        String character = str.charAt(0)+"" ;
        subsequences(str.substring(1),result+character) ;
        subsequences(str.substring(1),result);
    }
}
