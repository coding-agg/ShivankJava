package Section7_Recursion_Get;

import java.util.ArrayList;
import java.util.Scanner;

public class getpermutation {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String str = scn.nextLine() ;
        System.out.println(getper(str));
    }
    public static ArrayList<String> getper(String str){
        if(str.length() == 0){
            ArrayList<String> l = new ArrayList<>() ;
            l.add("") ;
            return l ;
        }
        ArrayList<String> readlist = getper(str.substring(1)) ;
        ArrayList<String> newlist = new ArrayList<>() ;
        String s = str.substring(0,1) ;
        for (int i = 0; i < readlist.size(); i++) {
            String main = readlist.get(i) ;
            for (int j = 0; j <= main.length(); j++) {
                newlist.add(main.substring(0,j)+s+main.substring(j)) ;
            }
        }
        return newlist;
    }

}
