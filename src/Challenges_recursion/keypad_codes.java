package Challenges_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class keypad_codes {
    static Scanner scn = new Scanner(System.in);
    public static int num = 0 ;

    public static void main(String[] args) {
        String[] table = {"","abc", "def", "ghi", "jkl" , "mno", "pqrs" , "tuv","wx", "yz" };
        String str = scn.nextLine();
        smart_keypad(str,"",table);
        System.out.println();
        System.out.println(num);
    }
    public static void smart_keypad(String str, String s, String[] arr){
        if(str.length()==0){
            System.out.print(s+" ");
            num++;
            return;
        }
        int num = getInteger(str.charAt(0)+"");
        for (int i = 0; i <arr[num].length() ; i++) {
            smart_keypad(str.substring(1),s+arr[num].charAt(i),arr);
        }
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
