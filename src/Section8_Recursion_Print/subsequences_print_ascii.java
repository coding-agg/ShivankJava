package Section8_Recursion_Print;

import java.util.Scanner;

public class subsequences_print_ascii {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        subsequencesascii(scn.nextLine(),"");
    }
    public static void subsequencesascii(String str, String result){
        if(str.length()==0){
            System.out.println(result);
            return;
        }
        String character = str.charAt(0)+"" ;
        int ascii = str.charAt(0) ;
        String Asc = Integer.toString(ascii) ;
        subsequencesascii(str.substring(1),result) ;
        subsequencesascii(str.substring(1),result+character);
        subsequencesascii(str.substring(1),result+Asc);
    }
}
