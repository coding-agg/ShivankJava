package Challenges_recursion;

import java.util.Scanner;

public class all_X_at_end {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scn.nextLine();
        System.out.println(allx(str));
    }
    public static String allx(String str){
        if(str.length()==0){
            return "";
        }
        String s = allx(str.substring(1));
        String hel = "";
        if(str.charAt(0)=='x'){
            hel = s+str.charAt(0);
        }
        else{
            hel = str.charAt(0)+s;
        }
        return hel;
    }
}
