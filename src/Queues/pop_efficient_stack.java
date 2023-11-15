package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class pop_efficient_stack {
    Queue<Integer> s1;
    Queue<Integer> s2;
    public pop_efficient_stack(){
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }
    public boolean isEmpty(){
        return this.s2.isEmpty();
    }
    public void push(int item){
        this.s1.add(item);
        while(!this.s2.isEmpty()){
            this.s1.add(this.s2.remove());
        }
        Queue<Integer> temp = this.s1;
        this.s1 = this.s2;
        this.s2 = temp;
    }
    public int size(){
        return this.s2.size();
    }
    public int pop(){
        return this.s2.remove();
    }
    public int top(){
        return this.s2.peek();
    }
    public void display(){
        if(s2.isEmpty()){
            return;
        }
        int item = s2.peek();
        s1.add(s2.remove());
        display();
        s2.add(s1.remove());
        System.out.print(item+" ");
    }

    public static void main(String[] args) {
        pop_efficient_stack s1 = new pop_efficient_stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.display();
        System.out.println();
        System.out.println(s1.pop());
        System.out.println(s1.pop());
        System.out.println(s1.top());
        s1.display();
    }
}
