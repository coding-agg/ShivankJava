package Challenges_Heaps;

import java.util.*;

public class hostel_visit_new{
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scn.nextInt();
        int k = scn.nextInt();
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int qtype = scn.nextInt();
            if(qtype == 1){
                int x = scn.nextInt();
                int y = scn.nextInt();
                pq.add(x*x + y*y);
            }
            else{
                while(pq.size()!=k){
                    pq.remove();
                }
                System.out.println(pq.peek());
            }
        }
    }
}
