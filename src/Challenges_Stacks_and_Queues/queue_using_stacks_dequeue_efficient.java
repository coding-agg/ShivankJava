package Challenges_Stacks_and_Queues;

import java.util.Stack;

public class queue_using_stacks_dequeue_efficient {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public queue_using_stacks_dequeue_efficient(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    public boolean isEmpty(){
        return s2.isEmpty();
    }
    public int dequeue(){
        return s2.pop();
    }
    public void enqueue(int item){
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        s1.push(item);
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
    }
    public int size(){
        return s2.size();
    }
    public void display(){
        for (int i = s2.size()-1; i >=0 ; i--) {
            System.out.print(s2.get(i)+" ");
        }
        System.out.println();
    }
    public int front(){
        return s2.peek();
    }

    public static void main(String[] args) {
        Queues.queue_using_stacks_dequeue s1 = new Queues.queue_using_stacks_dequeue();
        s1.enqueue(1);
        s1.enqueue(2);
        s1.enqueue(3);
        s1.enqueue(4);
        s1.display();
        System.out.println(s1.dequeue());
        System.out.println(s1.dequeue());
        System.out.println(s1.front());
        s1.display();
    }
}

