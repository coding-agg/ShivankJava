package Backtracking;

import java.util.Scanner;

public class Queen_Combination_Box_Respect {
    static Scanner scn = new Scanner(System.in);
    public static int box_length;
    public static void main(String[] args) {
        box_length = scn.nextInt();
        Queen("",0,0);
    }
    public static void Queen(String str,int num,int count){
        if(count==2){
            System.out.println(str);
            return;
        }
        if(num==box_length){
            return;
        }

        Queen(str+"Queen "+(count)+" at "+ num + " , ",num+1,count+1);
        Queen(str,num+1,count);
    }
}
