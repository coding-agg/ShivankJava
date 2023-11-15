package Challenges_strings;

import java.util.Scanner;

public class differenceascii {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String str = scn.nextLine() ;
        str = difference(str) ;
        System.out.println(str);
    }
    public static String difference(String s){
        StringBuilder str = new StringBuilder(s) ;
        StringBuilder newstr = new StringBuilder() ;
        for (int i = 0; i <str.length()-1 ; i++) {
            newstr.append(str.charAt(i)) ;
            newstr.append(str.charAt(i+1)-str.charAt(i)) ;
        }
        newstr.append(str.charAt(str.length()-1)) ;
        return newstr.toString() ;
    }
}
