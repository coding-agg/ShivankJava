package practice;

import java.util.Scanner;

public class The_gift {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int test = scn.nextInt();
        for (int i = 0; i < test; i++) {
            int addyt = scn.nextInt();
            int sumom = 0;
            int finalsum = 0;
            for (int j = 0; j < addyt; j++) {
                int num = scn.nextInt();
                if(num == 0){
                    sumom = 0;
                }
                else {
                    sumom++;
                }
                if(sumom>finalsum){
                    finalsum = sumom;
                }
            }
            int sumaddy = 0;
            int finalsum2 = 0;
            for (int j = 0; j < addyt; j++) {
                int num = scn.nextInt();
                if(num==0){
                    sumaddy = 0;
                }
                else {
                    sumaddy++;
                }
                if(sumaddy>finalsum2){
                    finalsum2 = sumaddy;
                }
            }
            if(finalsum>finalsum2){
                System.out.println("OM");
            }
            else if(finalsum<finalsum2){
                System.out.println("ADDY");
            }
            else{
                System.out.println("DRAW");
            }
        }
    }
}
