package Section11_Linked_List;


import java.util.LinkedList;

public class DynamicQueue {
    private LinkedList<Integer> Queue;
    public DynamicQueue(){
        this.Queue = new LinkedList<>();
    }
    public void addLast(int item){
        this.Queue.add(item);
    }
    public int remove(){
        return this.Queue.remove();
    }
    public int size(){
        return this.Queue.size();
    }
    public boolean isEmpty(){
        return this.Queue.isEmpty();
    }
    public void display(){
        for (int i = 0; i <size(); i++) {
            System.out.print(this.Queue.get(i)+" ");
        }
        System.out.println();
    }
}
