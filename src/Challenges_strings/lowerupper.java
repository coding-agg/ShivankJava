package Challenges_strings;

import java.util.Scanner;

public class lowerupper {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        char character = scn.next().charAt(0) ;
        if(character>='a' && character<='z'){
            System.out.println("lowercase");
        }
        else if(character>='A'&& character<='Z'){
            System.out.println("UPPERCASE");
        }
        else{
            System.out.println("Invalid");
        }
    }
}
