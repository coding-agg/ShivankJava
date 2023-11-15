package Queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class non_repeating {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        char ch = scn.next().charAt(0);
        HashMap<Character,Integer> map = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        while(ch!='.'){
            queue.add(ch);
            if(map.containsKey(ch)){
                int ov = map.get(ch);
                ov++;
                map.put(ch,ov);
            }
            else{
                map.put(ch,1);
            }
            queue.add(ch);
            while(!queue.isEmpty() && map.get(queue.peek())>1){
                queue.remove();
            }
            if(!queue.isEmpty()) {
                System.out.println(queue.peek()+" ");
            }
            else{
                System.out.println(-1+" ");
            }
            ch = scn.next().charAt(0);
        }

    }
}
