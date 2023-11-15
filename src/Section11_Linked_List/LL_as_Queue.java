package Section11_Linked_List;

public class LL_as_Queue {
    private LinkedList queue;
    public LL_as_Queue(){
        this.queue = new LinkedList();
    }
    public int size(){
        return this.queue.size();
    }
    public boolean isEmpty(){
        return size()==0;
    }
    public void enqueue(int item){
        this.queue.addLast(item);
    }
    public int dequeue()throws Exception{
        return this.queue.removeFirst();
    }
    public int front()throws Exception{
        return this.queue.getFirst();
    }
    public void display(){
        this.queue.display();
    }

}
