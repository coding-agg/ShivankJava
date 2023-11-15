package Section5_String_and_StringBuilder;

import java.util.Scanner;

public class stringbuilder {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello") ;
        sb.setCharAt(3,'w');
        System.out.println(sb);
        sb.insert(3,"bc") ;
        sb.insert(6,"de") ;
        System.out.println(sb);
        sb.append("abc") ;
        System.out.println(sb);
        sb.deleteCharAt(2) ;
        System.out.println(sb);
        String str = sb.toString() ;
        StringBuilder sbr = new StringBuilder(str) ;
    }
}
