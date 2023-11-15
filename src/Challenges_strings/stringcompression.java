package Challenges_strings;

import java.util.ArrayList;
import java.util.Scanner;

public class stringcompression {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String str = scn.nextLine() ;
        str = compress(str) ;
        System.out.println(str);
    }
    public static String compress(String s){
        StringBuilder str = new StringBuilder(s) ;
        int k = -1 ;
        char chr = ' ' ;
        ArrayList<Character> list1 = new ArrayList<>() ;
        ArrayList<Integer> list2 = new ArrayList<>() ;
        for (int i = 0; i <str.length() ; i++) {
            if(chr != str.charAt(i)){
                chr = str.charAt(i) ;
                list1.add(chr) ;
                k++ ;
                list2.add(1) ;
            }
            else{
                list2.set(k,list2.get(k)+1) ;
            }
        }
        StringBuilder result = new StringBuilder() ;
        for (int i = 0; i < list1.size(); i++) {
            if(list2.get(i)>1){
                result.append(list1.get(i)) ;
                result.append(list2.get(i)) ;
            }
            else{
                result.append(list1.get(i)) ;
            }
        }
        return result.toString() ;
    }
}
