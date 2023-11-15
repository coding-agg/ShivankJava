package Challenges_strings;

import java.util.ArrayList;
import java.util.Scanner;

public class canyoureadthis {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String str = scn.nextLine() ;
        ArrayList<String> arr = readthis(str) ;
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
    public static ArrayList<String> readthis(String str){
        StringBuilder build = new StringBuilder(str) ;
        ArrayList<String> arr = new ArrayList<>() ;
        int k = 0 ;
        for (int i = 0; i < build.length(); i++) {
            if(i>0){
                if(build.charAt(i)>='A' && build.charAt(i)<='Z'){
                    arr.add(build.substring(k,i)) ;
                    k = i ;
                }
            }
        }
        arr.add(build.substring(k,build.length())) ;
        return arr ;
    }

}
