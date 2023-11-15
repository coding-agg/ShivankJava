package Section11_Linked_List;

public class Stack_client {
    public static void main(String[] args)throws Exception{
        LL_as_stack s1 = new LL_as_stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);
        s1.display();
        s1.pop();
        s1.display();
        System.out.println(s1.top());

    }
}
