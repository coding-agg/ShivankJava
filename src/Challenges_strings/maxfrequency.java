package Challenges_strings;

import java.util.ArrayList;
import java.util.Scanner;

public class maxfrequency {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String str = scn.nextLine() ;
        char charact = maxfrequency(str) ;
        System.out.println(charact);
    }
    public static char maxfrequency(String s){
        ArrayList<Character> str = new ArrayList<>() ;
        ArrayList<Integer> arr = new ArrayList<>();
        char k = ' ' ;
        int num = 0 ;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)!=k){
                k = s.charAt(i) ;
                for (int j = 0; j < str.size(); j++) {
                    if(str.get(j) == k){
                        num = 1 ;
                        break ;
                    }
                    else{
                        num = 0 ;
                    }
                }
                if(num == 0){
                    str.add(k) ;
                }
            }
        }
        int sum = 0 ;
        for (int i = 0; i < str.size(); i++) {
            sum = 0 ;
            for (int j = 0; j < s.length(); j++) {
                if(str.get(i) == s.charAt(j)){
                    sum++ ;
                }
            }
            arr.add(sum);
        }
        sum = 0 ;
        int index = -1 ;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i)>sum){
                sum = arr.get(i) ;
                index = i ;
            }
        }
        return str.get(index) ;
    }
}
