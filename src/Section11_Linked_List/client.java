package Section11_Linked_List;


public class client {
    public static void main(String[] args)throws Exception {
        LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.display();
        list.reversePointers();
        System.out.println();
        System.out.println(list.midPoint());
        list.display();
        System.out.println();
        System.out.println(list.kth_node(2));
    }
}
