package Section10_OOPS_and_Stacks;

public class Dynamic_Stack extends Stack {
    public Dynamic_Stack()throws Exception{
        this(Final_No);
    }
    public Dynamic_Stack(int capacity)throws Exception{
        super(capacity);
    }
    public void push(int item)throws Exception{
        if(total_No_filled == Final_No){
            Final_No = Final_No*2;
            int[] newarr = new int[this.arr.length];
            for (int i = 0; i < newarr.length; i++) {
                newarr[i] = arr[i];
            }
            arr = new int[newarr.length*2];
            for (int i = 0; i < newarr.length; i++) {
                arr[i] = newarr[i];
            }
        }
        super.push(item);
    }
}
