package Section7_Recursion_Get;

import java.util.ArrayList;
import java.util.Scanner;

public class subsequences {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String str = scn.nextLine() ;
        System.out.println(getss(str));
        System.out.println(getssWASCII(str));
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
    public static ArrayList<String> getssWASCII(String str){
        if(str.length() == 0){
            ArrayList<String> list2 = new ArrayList<>() ;
            list2.add("") ;
            return list2 ;
        }
        ArrayList<String> list = getssWASCII(str.substring(1)) ;
        ArrayList<String> list3 = new ArrayList<>();
        list3.addAll(list) ;
        String ss = str.substring(0,1) ;
        int character = str.charAt(0) ;
        ArrayList<String> mainlist = new ArrayList<>() ;
        mainlist.addAll(list) ;
        for (int i = 0; i < list.size(); i++) {
            list.set(i,ss+list.get(i)) ;
        }
        for (int i = 0; i < list3.size(); i++) {
            list3.set(i,character+list3.get(i)) ;
        }
        mainlist.addAll(list) ;
        mainlist.addAll(list3) ;
        return mainlist ;
    }
}
