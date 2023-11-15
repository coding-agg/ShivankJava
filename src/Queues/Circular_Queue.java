package Queues;

public class Circular_Queue {
    private int[] arr;
    private int cs;
    private int ms;
    private int front;
    private int rear;
    public static int DEFAULT_CAPACITY = 10;
    public Circular_Queue(){
        this(DEFAULT_CAPACITY);
    }
    public Circular_Queue(int capacity) {
        this.arr = new int[capacity];
        this.cs = 0;
        this.ms = capacity;
        this.front = 0;
        this.rear = capacity - 1;
    }
    public boolean isfull(){
        return this.cs == this.ms;
    }
    public boolean isempty(){
        return this.cs == 0;
    }
    public void enqueue(int data){
        if(!this.isfull()){
            this.rear = (this.rear+1)%this.arr.length;
            this.arr[this.rear] = data;
            this.cs++;
        }
    }
    public void dequeue(){
        if(!this.isempty()){
            this.front = (this.front+1)%this.arr.length;
            this.cs--;
        }
    }
    public int getFront(){
        return this.arr[this.front];
    }

    public static void main(String[] args) {
        Circular_Queue queue = new Circular_Queue();
        for (int i = 1; i <= 6; i++) {
            queue.enqueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(8);
        while(!queue.isempty()){
            System.out.println(queue.getFront());
            queue.dequeue();
        }
    }

}
