package Challenges_Heaps;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hostel_visit {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        Queue<Integer> hq = new LinkedList<>();
        int Q = scn.nextInt();
        int k = scn.nextInt();
        while(Q!=0){
            int ans = scn.nextInt();
            if(ans == 1){
                int x = scn.nextInt();
                int y = scn.nextInt();
                int num = (x*x) + (y*y);
                if(hq.size()<k){
                    hq.add(num);
                }
                else{
                    if(hq.peek()>num){
                        hq.add(num);
                        hq.remove();
                        Queue<Integer> hv = new LinkedList<>();
                        while(!hq.isEmpty()){
                            if(hq.isEmpty()) {
                                hv.add(hq.remove());
                            }
                            while(!hv.isEmpty() && !hq.isEmpty() && hq.peek()>hv.peek()){
                                hq.add(hv.remove());
                            }
                            while(!hq.isEmpty()){
                                hv.add(hq.remove());
                            }
                        }
                        Queue<Integer> temp = hv;
                        hv = hq;
                        hq = temp;
                    }
                }
            }
            else{
                System.out.println(hq.peek());
            }
            Q--;

        }
    }
}
