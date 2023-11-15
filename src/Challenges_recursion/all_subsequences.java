package Challenges_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class all_subsequences {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int test = scn.nextInt();
        for (int j = 0; j < test; j++) {
            String str = scn.next();
            ArrayList<String> arr = getss(str);
            lexo(arr);
            for (int i = 0; i < arr.size(); i++) {
                System.out.println(arr.get(i));
            }
        }
    }
    public static ArrayList<String> getss(String str){
        if(str.length() == 0){
            ArrayList<String> list2 = new ArrayList<>() ;
            list2.add("") ;
            return list2 ;
        }
        ArrayList<String> list = getss(str.substring(1)) ;
        String ss = str.substring(0,1) ;
        ArrayList<String> mainlist = new ArrayList<>() ;
        mainlist.addAll(list) ;
        for (int i = 0; i < list.size(); i++) {
            list.set(i,ss+list.get(i)) ;
        }
        mainlist.addAll(list) ;
        return mainlist ;
    }
    public static void lexo(ArrayList<String> arr){
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if(arr.get(i).compareTo(arr.get(j))>0){
                    String temp = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,temp);
                }
            }
        }
    }
}
