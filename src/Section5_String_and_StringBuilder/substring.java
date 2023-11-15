package Section5_String_and_StringBuilder;

import java.util.Scanner;

public class substring {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String str = scn.nextLine() ;
        long start = System.currentTimeMillis() ;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <=str.length() ; j++) {
                System.out.print(str.substring(i,j)+" ");
            }
            System.out.println();
        }
        long end = System.currentTimeMillis() ;
        System.out.println(end-start);
    }
}