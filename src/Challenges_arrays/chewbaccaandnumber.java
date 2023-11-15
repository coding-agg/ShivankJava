package Challenges_arrays;

import java.util.*;

public class chewbaccaandnumber {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        long item = scn.nextLong() ;
        long result = array(item) ;
        System.out.println(result);
    }
    public static long array(long item){
        ArrayList<Integer> array = new ArrayList<>() ;
        long temp = 0 ;
        long sum = 0 ;
        long length = (long) (Math.log10(item) + 1);
        while(item>0){
            long num = item%10 ;
            item = item/10 ;
            if(num>9-num){
                if(temp<length-1){
                    num = 9-num ;
                }
                else{
                    if(num == 9){
                    }
                    else{
                        num = 9-num ;
                    }
                }
            }
            sum = sum+ (long)(num*Math.pow(10,temp)) ;
            temp++ ;
        }
        return sum ;
    }
}
