package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayDS {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>() ;
        int item = scn.nextInt() ;
        for (int i = 0; i < item; i++) {
            list.add(scn.nextInt()) ;
        }
        List<Integer> b = reverseArray(list) ;
        System.out.println(b);
    }
    public static List<Integer> reverseArray(List<Integer> a){
        ArrayList<Integer> b = new ArrayList<>() ;
        for (int i = a.size()-1; i >=0; i--) {
            b.add(a.remove(i)) ;
        }
        return b ;
    }
}
