package Section10_OOPS_and_Stacks;

public class Stack_Func {
    public static void main(String[] args) throws Exception{
        Stack s1 = new Dynamic_Stack();
        s1.push(4);
        s1.push(5);
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.push(60);
        s1.push(60);
        s1.push(60);
        s1.push(60);
        s1.push(60);
        s1.push(60);
        s1.display();
    }
}
