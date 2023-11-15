package Challenges_Fundamentals_and_Patterns;

import java.util.Scanner;

public class prateeklovescandy {
    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scn.nextInt();
        int[] testarray = testcase(test);
        boolean[] booleanarray = soe() ;
        for (int i = 0; i < testarray.length; i++) {
            int num = testarray[i];
            for (int j = 2; j < booleanarray.length; j++) {
                if(booleanarray[j]){
                    num--;
                }
                if(num==0){
                    System.out.println(j);
                    break;
                }
            }
        }
    }
    public static int[] testcase(int test){
        int[] testarray = new int[test];
        for (int i = 0; i < testarray.length; i++) {
            testarray[i] = scn.nextInt();
        }
        return testarray;
    }
    public static boolean[] soe(){
        boolean[] array = new boolean[1000000];
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
}
