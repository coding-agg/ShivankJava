package Challenges_strings;

import java.util.ArrayList;
import java.util.Scanner;

public class fastmath {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int test = scn.nextInt() ;
        String result = " " ;
        ArrayList<String> arr = new ArrayList<>() ;
        for (int i = 0; i < test; i++) {
            arr = array() ;
            result = fastmath(arr) ;
            System.out.println(result);
        }
    }
    public static String fastmath(ArrayList<String> arr){
        StringBuilder str = new StringBuilder() ;
        for (int i = 0; i < arr.get(0).length(); i++) {
            if(arr.get(0).charAt(i)!=arr.get(1).charAt(i)){
                str.append(1) ;
            }
            else{
                str.append(0) ;
            }
        }
        return str.toString() ;
    }
    public static ArrayList<String> array(){
        ArrayList<String> arr = new ArrayList<>() ;
        for (int i = 0; i < 2; i++) {
            arr.add(scn.next()) ;
        }
        return arr ;
    }
}
