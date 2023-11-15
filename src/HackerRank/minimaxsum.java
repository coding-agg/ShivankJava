package HackerRank;

import java.util.*;

public class minimaxsum {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        ArrayList<Integer> arr = array() ;
        minimaxsum(arr) ;
    }
    public static void minimaxsum(List<Integer> arr){
        long min = 0 ;
        long max = 0 ;
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = 0; j < arr.size()-i-1; j++) {
                if(arr.get(j)>arr.get(j+1)){
                    int temp = arr.get(j) ;
                    arr.set(j,arr.get(j+1)) ;
                    arr.set(j+1,temp) ;
                }
            }
        }
        for (int i = 0; i < arr.size()-1; i++) {
            min = min+(long)arr.get(i) ;
            max = max+(long)arr.get(arr.size()-1-i) ;
        }
        System.out.print(min+" "+max);
    }
    public static ArrayList<Integer> array(){
        ArrayList<Integer> arr = new ArrayList() ;
        for (int i = 0; i < 5; i++) {
            arr.add(scn.nextInt()) ;
        }
        return arr ;

    }
}
