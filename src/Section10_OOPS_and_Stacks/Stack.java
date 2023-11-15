package Section10_OOPS_and_Stacks;

public class Stack {
    public static int total_No_filled = 0;
    public static int Final_No = 10;
    int[] arr;
    public Stack() throws Exception{
        this(Final_No);
    }
    public Stack(int length)throws Exception{
        if (length<1) {
            throw new Exception("Not valid");
        }
        this.arr = new int[length];
        Final_No = length;
    }
    public void size(){
        System.out.println(Final_No);
    }
    public boolean isEmpty(){
        if(total_No_filled==0){
            return true;
        }
        return false;
    }
    public void push(int item) throws Exception{
        if(total_No_filled==Final_No){
            throw new Exception("The stack is filled");
        }
        this.arr[total_No_filled] = item;
        total_No_filled++;
    }
    public void pop() throws Exception{
        if(total_No_filled==0){
            throw new Exception("Stack is Empty");
        }
        else {
            this.arr[total_No_filled-1] = 0;
            total_No_filled--;
        }
    }
    public void display(){
        for (int i = total_No_filled-1; i >=0; i--) {
            System.out.print(this.arr[i]+" ");
        }
        System.out.println();
    }
    public int top()throws Exception{
        if(total_No_filled==0){
            throw new Exception("No elements in Stack");
        }
        return arr[total_No_filled-1];
    }

}
