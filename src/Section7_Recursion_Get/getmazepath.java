package Section7_Recursion_Get;

import java.util.ArrayList;
import java.util.Scanner;

public class getmazepath {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int destrow = scn.nextInt() ;
        int destcol = scn.nextInt();
        ArrayList<String> result = getMazePath(0,0,destrow,destcol) ;
        System.out.println(result);
        System.out.println(result.size());
    }
    public static ArrayList<String> getMazePath(int row,int col,int destrow,int destcol){
        if(row==destrow && col == destcol){
            ArrayList<String> br = new ArrayList<>() ;
            br.add("") ;
            return br ;
        }
        if(row>destrow || col>destcol){
            ArrayList<String> br = new ArrayList<>() ;
            return br ;
        }
        ArrayList<String> mr = new ArrayList<>() ;
        ArrayList<String> rr = getMazePath(row+1,col,destrow,destcol) ;
        for(String rrs : rr){
            mr.add("V"+rrs) ;
        }
        ArrayList<String> rs = getMazePath(row,col+1,destrow,destcol) ;
        for(String rrs : rs) {
            mr.add("H" + rrs);
        }
        return mr ;
    }
}
