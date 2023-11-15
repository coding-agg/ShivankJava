package Challenges_Linked_List;

import java.util.LinkedList;
import java.util.Scanner;

public class merge_ll {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        int test = scn.nextInt();
        for (int i = 0; i < test; i++) {
            LinkedList<Integer> s1 = new LinkedList<>();
            LinkedList<Integer> s2 = new LinkedList<>();
            LinkedList<Integer> s3 = new LinkedList<>();
            int length1 = scn.nextInt();
            for (int j = 0; j < length1; j++) {
                s1.addLast(scn.nextInt());
            }
            int length2 = scn.nextInt();
            for (int j = 0; j < length2; j++) {
                s2.addLast(scn.nextInt());
            }
            int l = 0;
            while(!s1.isEmpty() || !s2.isEmpty()){
                while(!s1.isEmpty() && !s2.isEmpty() && s1.getFirst()<s2.getFirst()){
                    s3.addLast(s1.removeFirst());
                    l++;
                }
                while (!s1.isEmpty() && !s2.isEmpty() && s1.getFirst()>=s2.getFirst()){
                    s3.addLast(s2.removeFirst());
                    l++;
                }
                if(s1.isEmpty()) {
                    while (!s2.isEmpty()){
                        s3.addLast(s2.removeFirst());
                        l++;
                    }
                }
                if(s2.isEmpty()){
                    while (!s1.isEmpty()){
                        s3.addLast(s1.removeFirst());
                        l++;
                    }
                }
            }
            for (int j = 0; j < s3.size(); j++) {
                System.out.print(s3.get(j)+" ");
            }
            System.out.println();
        }
    }
}
