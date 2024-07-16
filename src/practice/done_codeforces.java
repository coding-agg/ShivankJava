package practice;

import java.util.Scanner;

public class done_codeforces {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while(t-- >0){
            int a = scn.nextInt();
            int b = scn.nextInt();
            int c = scn.nextInt();
            int ans = 0;
            for(int i=0; i<5; i++)
            {
                if(a<=b  &&  a<=c)
                {
                    a++;
                }
                else if(b<=a  &&  b<=c)
                {
                    b++;
                }
                else if(c<=a  &&  c<=b)
                {
                    c++;
                }
            }
            System.out.println(a*b*c);
        }
    }
}
