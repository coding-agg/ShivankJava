package Challenges_arrays;

import java.util.Scanner;

public class painterincomplete {
    static Scanner scn = new Scanner(System.in) ;
    public static void main(String[] args) {
        int painter = scn.nextInt() ;
        int board = scn.nextInt() ;
        int time = time(painter,board) ;
    }
    public static int time(int painter, int board){
        int[] arr = new int[board] ;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt() ;
        }
        int answer = 0 ;
        int result = (int)Float.NEGATIVE_INFINITY;
        for (int i = 0; i < painter; i++) {
            return answer ;
        }
        return answer ;
    }
}
