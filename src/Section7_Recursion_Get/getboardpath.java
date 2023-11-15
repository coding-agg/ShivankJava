package Section7_Recursion_Get;

import java.util.ArrayList;
import java.util.Scanner;

public class getboardpath {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        ArrayList<String> result = getBoardPath(0,3) ;
        System.out.println(result);
        System.out.println(result.size());
    }
    public static ArrayList<String> getBoardPath(int curr,int end){
        if(curr == end){
            ArrayList<String> br = new ArrayList<>() ;
            br.add("") ;
            return br ;
        }
        if(curr >end){
            ArrayList<String> br = new ArrayList<>();
            return br ;
        }
        ArrayList<String> mr = new ArrayList<>();
        for (int dice = 1; dice <=6; dice++) {
            ArrayList<String> rr = getBoardPath(curr+dice,end);
            for(String rrs : rr){
                mr.add(dice+rrs) ;
            }
        }
        return mr ;
    }
}
