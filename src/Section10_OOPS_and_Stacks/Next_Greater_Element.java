package Section10_OOPS_and_Stacks;

import java.util.Scanner;

public class Next_Greater_Element {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args)throws Exception {
        Dynamic_Stack s1 = new Dynamic_Stack();
        int[] arr = null;
        arr = array();
        int i = 0;
        while(i<arr.length){
            while(!s1.isEmpty() && arr[i]>s1.top()){
                System.out.println(s1.top()+" - "+arr[i]);
                s1.pop();
            }
            s1.push(arr[i]);
            i++;
        }
        while(!s1.isEmpty()){
            System.out.println(s1.top()+" - "+(-1));
            s1.pop();
        }
    }
    public static int[] array(){
        int[] arr = new int[scn.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scn.nextInt();
        }
        return arr;
    }
}
