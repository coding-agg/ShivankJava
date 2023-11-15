package Section5_String_and_StringBuilder;

import java.util.Scanner;

public class demoques {
    static Scanner scn = new Scanner(System.in) ;

    public static void main(String[] args) {
        String string = scn.nextLine() ;
        for (int i = 0; i < string.length(); i++) {
            System.out.println(string.charAt(i));
        }
    }
}
