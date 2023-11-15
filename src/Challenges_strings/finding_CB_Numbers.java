package Challenges_strings;

import java.util.ArrayList;
import java.util.Scanner;

public class finding_CB_Numbers {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        String[] s = substring(scn.next());
        boolean[] prime = soe();
        for (int i = 0; i < s.length; i++) {
            
        }
        
    }
    public static boolean[] soe(){
        boolean[] array = new boolean[54];
        for (int i = 2; i < array.length; i++) {
            array[i] = true ;
        }
        for (int i = 2; i*i<=array.length-1; i++) {
            if(array[i]){
                for (int j = 2; j*i <=array.length-1 ; j++) {
                    array[i*j]=false;
                }
            }
        }
        return array;
    }
    public static String[] substring(String s){
        if(s.length() == 0){
            String[] l = {""};
            return l;
        }
        String[] arr = substring(s.substring(1));
        String[] main = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            main[i] = s.charAt(0)+arr[i];
        }
        String[] returnarr = new String[(arr.length)*2];
        int k = 0 ;
        while(k<returnarr.length){
            for (int i = 0; i < arr.length; i++) {
                returnarr[k] = arr[i];
                k++;
            }
            for (int i = 0; i < main.length; i++) {
                returnarr[k] = main[i];
                k++;
            }
        }
        return returnarr;
    }
}
