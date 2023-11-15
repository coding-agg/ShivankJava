package Queues;

import java.util.Stack;

public class queue_using_stack_enqueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public queue_using_stack_enqueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public boolean isEmpty(){
        return s1.isEmpty();
    }
    public void enqueue(int item){
        s1.push(item);
    }
    public int dequeue(){
        while(s1.size()>1){
            s2.push(s1.pop());
        }
        int num = s1.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return num;
    }
    public int size(){
        return this.s1.size();
    }
    public int front(){
        while(s1.size()>1){
            s2.push(s1.pop());
        }
        int num = s1.pop();
        s2.push(num);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return num;
    }

    public static void main(String[] args) {
        queue_using_stack_enqueue s1 = new queue_using_stack_enqueue();
        s1.enqueue(1);
        s1.enqueue(2);
        s1.enqueue(3);
        s1.enqueue(4);
        System.out.println(s1.dequeue());
        System.out.println(s1.dequeue());
        System.out.println(s1.front());
    }
}
