package Challenges_recursion;

import java.util.Scanner;

public class convert_String_to_integer {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scn.nextLine();
        int num = getInteger(str);
        System.out.println(num);
    }
    public static int getInteger(String s){
        if(s.length()==0){
            return 0;
        }
        int i = getInteger(s.substring(1));
        Character c = s.charAt(0);
        int num = (int)((c-48)*Math.pow(10,s.length()-1))+i;
        return num;
    }
}
