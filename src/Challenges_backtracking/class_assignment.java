package Challenges_backtracking;

import java.util.Scanner;

public class class_assignment {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int test = scn.nextInt();
        int[] arr = array(test);
        for (int i = 0; i < test; i++) {
            int ans = assign("",arr[i]);
            System.out.println("#"+arr[i]+" : "+ans);
        }
    }
    public static int assign(String ans,int num){
        if(ans.length() == num){
            return 1;
        }
        int first = assign(ans+"a",num);
        int second = 0;
        if(ans.length()==0){
            second = assign(ans+"b",num);
        }
        else if(ans.charAt(ans.length()-1)!='b') {
            second = assign(ans + "b", num);
        }
        return first+second;
    }
    public static int[] array(int test){
        int[] arr = new int[test];
        for (int i = 0; i < test; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
