package HackerRank;

import java.util.*;

public class subarray_division {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> hello = array();

        System.out.println(birthday(hello,4,2));
    }
    public static int birthday(List<Integer> s,int d,int m){
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int ans = 0;
        for (int num : s){
            queue.add(num);
            sum+=num;
            if(queue.size()>=m){
                if(queue.size()>m){
                    int a = queue.remove();
                    sum = sum-a;
                }
                if(sum == d){
                    ans++;
                }
            }
        }
        return ans;
    }
    public static List<Integer> array(){
        List<Integer> list = new ArrayList<>();
        int len = scn.nextInt();
        for (int i = 0; i < len; i++) {
            list.add(scn.nextInt());
        }
        return list;
    }
}
