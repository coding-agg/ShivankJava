package HackerRank;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class migratorybirds {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        ArrayList<Integer> arr = array() ;
        int result = migrate(arr) ;
        System.out.println(result);
    }
    public static ArrayList<Integer> array(){
        ArrayList<Integer> arr = new ArrayList<>() ;
        int num = scn.nextInt() ;
        for (int i = 0; i <num ; i++) {
            arr.add(scn.nextInt()) ;
        }
        return arr ;
    }
    public static int migrate(ArrayList<Integer> arr){
        int[] mainarray = new int[6] ;
        for (int i = 0; i < arr.size(); i++) {
            mainarray[arr.get(i)]++ ;
        }
        int num = 0 ;
        int index = -1 ;
        for (int i = 0; i < mainarray.length; i++) {
            if(mainarray[i]>num){
                num = mainarray[i] ;
                index = i ;
            }
        }
        return index ;
    }
}
