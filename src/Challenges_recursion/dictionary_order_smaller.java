package Challenges_recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class dictionary_order_smaller {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String str = scn.nextLine();
        ArrayList<String> arr = dict_order(str);
        lexico(arr);
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).equals(str)){
                break;
            }
            else{
                System.out.println(arr.get(i));
            }
        }
    }
    public static ArrayList<String> dict_order(String str){
        if(str.length()==0){
            ArrayList<String> l = new ArrayList<>();
            l.add("");
            return l;
        }
        ArrayList<String> dict = dict_order(str.substring(1));
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < dict.size(); i++) {
            String res = dict.get(i) ;
            for (int j = 0; j <= res.length(); j++) {
                result.add(res.substring(0,j)+str.charAt(0)+res.substring(j));
            }
        }
        return result;
    }
    public static void lexico(ArrayList<String> arr){
        for (int i = 0; i < arr.size()-1; i++) {
            for (int j = i+1; j <arr.size() ; j++) {
                if(arr.get(i).compareTo(arr.get(j))>0){
                    String temp = arr.get(i);
                    arr.set(i,arr.get(j));
                    arr.set(j,temp);
                }
            }
        }
    }
}
