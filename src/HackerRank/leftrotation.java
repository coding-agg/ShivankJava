package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class leftrotation {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int num = scn.nextInt() ;
        int left = scn.nextInt() ;
        ArrayList<Integer> arr = array(num) ;
        arr = rotateleft(left,arr) ;
        System.out.println(arr);
    }
    public static ArrayList<Integer> array(int num){
        ArrayList<Integer> arr = new ArrayList() ;
        for (int i = 0; i < num; i++) {
            arr.add(scn.nextInt()) ;
        }
        return arr ;
    }
    public static ArrayList<Integer> rotateleft(int d,ArrayList<Integer> arr){
        for (int i = 0; i < d; i++) {
            int temp = arr.get(0) ;
            arr.remove(0) ;
            arr.add(temp) ;
        }
        return arr ;
    }
}
