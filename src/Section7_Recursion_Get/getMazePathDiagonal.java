package Section7_Recursion_Get;

import java.util.ArrayList;
import java.util.Scanner;

public class getMazePathDiagonal {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int dest = scn.nextInt() ;
        ArrayList<String> result = getMazePathDiagonal(0,0,dest) ;
        System.out.println(result);
        System.out.println(result.size());
    }
    public static ArrayList<String> getMazePathDiagonal(int row, int col, int dest){
        if(row==dest && col == dest){
            ArrayList<String> br = new ArrayList<>() ;
            br.add("") ;
            return br ;
        }
        if(row>dest || col>dest){
            ArrayList<String> br = new ArrayList<>() ;
            return br ;
        }
        ArrayList<String> mr = new ArrayList<>() ;
        ArrayList<String> rr = getMazePathDiagonal(row+1,col,dest) ;
        for(String rrs : rr){
            mr.add("V"+rrs) ;
        }
        ArrayList<String> rs = getMazePathDiagonal(row,col+1,dest) ;
        for(String rrs : rs) {
            mr.add("H" + rrs);
        }
        ArrayList<String> rd = getMazePathDiagonal(row+1,col+1,dest) ;
        for (String rrd : rd){
            mr.add("D"+rrd) ;
        }
        return mr ;
    }
}
