package Challenges_strings;

import java.util.Scanner;

public class piyushandmagicalpark {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        int row = scn.nextInt() ;
        int column = scn.nextInt() ;
        int thresold = scn.nextInt() ;
        int strength = scn.nextInt() ;
        char[][] arr = array(row,column) ;
        magicalpark(thresold,strength,arr) ;
    }
    public static char[][] array(int row,int column){
        char[][] arr = new char[row][column] ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scn.next().charAt(0) ;
            }
        }
        return arr ;
    }
    public static void magicalpark(int thresold,int strength,char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                if(strength<thresold){
                    break ;
                }
                if(arr[i][j] == '.'){
                    strength = strength-2 ;
                } else if (arr[i][j] == '*') {
                    strength = strength+5 ;
                }
                else if(arr[i][j] == '#'){
                    break ;
                }
                if(j != arr.length-1){
                    strength-- ;
                }
            }
        }
        if(strength>=thresold){
            System.out.println("Yes");
            System.out.println(strength);
        }
        else{
            System.out.println("No");
        }
    }
}
