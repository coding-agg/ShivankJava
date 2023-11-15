package Section11_Linked_List;

public class LL_as_stack {
    private LinkedList stack;
    public LL_as_stack(){
        stack = new LinkedList();
    }
    public void push(int item){
        this.stack.addFirst(item);
    }
    public int pop()throws Exception{
        return this.stack.removeFirst();
    }
    public int size(){
        return this.stack.size();
    }
    public int top()throws Exception{
        return this.stack.getFirst();
    }
    public boolean isEmpty(){
        return this.stack.size()==0;
    }
    public void display(){
        this.stack.display();
    }
}
