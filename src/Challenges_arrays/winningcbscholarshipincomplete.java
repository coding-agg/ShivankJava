package Challenges_arrays;

import java.util.Scanner;

public class winningcbscholarshipincomplete {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        long stud = scn.nextInt() ;
        long schol = scn.nextInt() ;
        long x = scn.nextInt() ;
        long y = scn.nextInt() ;
        long result = winning(stud,schol,x,y);
        System.out.println(result);
    }
    public static long winning(long stud,long schol,long x,long y){
        long[] arr = new long[(int)stud];
        long result = 0 ;
        long copyschol = schol ;
        long index = arr.length;
        for (int i = 0; i < arr.length;i++) {
            if(copyschol>1){
                arr[i] = arr[i]+2 ;
                copyschol = copyschol-2 ;
                result++ ;
                index = i+1 ;
            }
            else{
                break ;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr.length-i-1>index){
                copyschol++ ;
            }
            if(copyschol>1){
                arr[(int)index] = arr[(int)index]+2 ;
                copyschol = copyschol-2 ;
                index++ ;
                result++ ;
            }
        }
        return result ;
    }
}
