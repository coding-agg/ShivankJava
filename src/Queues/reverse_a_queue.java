package Queues;

import Section11_Linked_List.DynamicQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class reverse_a_queue {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        DynamicQueue s1 = new DynamicQueue();
        for (int i = 0; i < 6; i++) {
            s1.addLast(scn.nextInt());
        }
        s1.display();
        reverse(s1);
        s1.display();
    }
    public static void reverse(DynamicQueue s1){
        if(s1.isEmpty()){
            return;
        }
        int item = s1.remove();
        reverse(s1);
        s1.addLast(item);
    }
}
