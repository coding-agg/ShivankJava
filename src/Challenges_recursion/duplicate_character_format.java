package Challenges_recursion;

import java.util.Scanner;

public class duplicate_character_format {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scn.nextLine();
        System.out.println(removedup(str));
    }
    public static String removedup(String str){
        if(str.length()==0){
            return "";
        }
        String s = removedup(str.substring(1));
        String result = "";
        if(s.length()>0 && str.charAt(0) == s.charAt(0)){
            result = str.charAt(0)+"*"+s;
            return result;
        }
        result = str.charAt(0)+s;
        return result;
    }
}
