package Section11_Linked_List;

public class queue_client {
    public static void main(String[] args)throws Exception {
        LL_as_Queue s1 = new LL_as_Queue();
        s1.enqueue(1);
        s1.enqueue(2);
        s1.enqueue(3);
        s1.enqueue(4);
        s1.display();
        s1.dequeue();
        s1.display();
        System.out.println(s1.size());
    }
}
