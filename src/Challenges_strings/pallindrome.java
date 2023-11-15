package Challenges_strings;

import java.util.Scanner;

public class pallindrome {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String str = scn.nextLine() ;
        boolean k = true ;
        StringBuilder build = new StringBuilder(str) ;
        for (int i = 0; i < build.length()/2; i++) {
            if(build.charAt(i) == build.charAt(build.length()-i-1)){
            }
            else{
                k = false ;
            }
        }
        System.out.println(k);
    }
}
