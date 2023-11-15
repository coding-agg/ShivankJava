package HackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayDS2d {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList() ;
        list = array() ;
        int result = ds(list) ;
        System.out.println(result);
    }
    public static ArrayList<ArrayList<Integer>> array(){
        ArrayList<ArrayList<Integer>> list = new ArrayList() ;
        for (int i = 0; i < 6; i++) {
            ArrayList<Integer> list2 = new ArrayList() ;
            for (int j = 0; j < 6; j++) {
                list2.add(scn.nextInt()) ;
            }
            list.add(list2) ;
        }
        return list ;
    }
    public static int ds(ArrayList<ArrayList<Integer>> arr){
        float result = Float.NEGATIVE_INFINITY;;
        for (int i = 0; i < arr.size()-2; i++) {
            int sum = 0 ;
            for (int j = 0; j < arr.get(i).size()-2; j++) {
                sum = arr.get(i).get(j)+arr.get(i).get(j+1)+arr.get(i).get(j+2)+arr.get(i+1).get(j+1)+arr.get(i+2).get(j)+arr.get(i+2).get(j+1)+arr.get(i+2).get(j+2) ;
                if(sum>result){
                    result = sum ;
                }
            }
        }
        return (int)result ;
    }
}
