package Challenges_recursion;

import java.util.Scanner;

public class replace_all_pi {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scn.nextInt();
        for (int i = 0; i < test; i++) {
            String str = scn.next();
            System.out.println(replace(str,1));
        }
    }
    public static String replace(String str,int num){
        if(str.length()==0){
            return "";
        }
        String result = "";
        if(str.length()>1 && str.charAt(0)=='p' && str.charAt(1)=='i'){
            result = replace(str.substring(1),num-1);
        }
        else{
            int hello = 1;
            result = replace(str.substring(1),hello);
        }
        String s = "";
        if(num==0 && str.charAt(0)=='i'){
            s = 3.14+result;
        }
        else if(str.length()>1 && str.charAt(0)=='p' && str.charAt(1)=='i'){
            s = result;
        }
        else{
            s = str.charAt(0)+result;
        }
        return s;
    }
}
