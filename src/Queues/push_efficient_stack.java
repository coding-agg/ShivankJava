package Queues;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class push_efficient_stack {
    Queue<Integer> s1;
    Queue<Integer> s2;
    public push_efficient_stack(){
        this.s1 = new LinkedList<>();
        this.s2 = new LinkedList<>();
    }
    public boolean isEmpty(){
        return this.s1.isEmpty();
    }
    public void push(int item){
        this.s1.add(item);
    }
    public int size(){
        return this.s1.size();
    }
    public int pop(){
        while(size()>1){
            s2.add(s1.remove());
        }
        int num = s1.remove();
        Queue<Integer> temp = s1;
        s1 = s2;
        s2 = temp;
        return num;
    }
    public int top(){
        while(size()>1){
            s2.add(s1.remove());
        }
        int num = s1.remove();
        s2.add(num);
        Queue<Integer> temp = s1;
        s1 = s2;
        s2 = temp;
        return num;
    }
    public void display(){
        while (!s1.isEmpty()){
            System.out.print(s1.peek()+" ");
            s2.add(s1.remove());
        }
        System.out.println();
        Queue<Integer> temp = s1;
        s1 = s2;
        s2 = temp;
    }
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        push_efficient_stack stack = new push_efficient_stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.display();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.top());
        stack.display();
    }

}
