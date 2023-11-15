package Challenges_Linked_List;

public class k_reverse {
    private class Node{
        int data;
        Node next;
    }
    private Node head;
    private Node tail;
    private int size;
    public int size(){
        return size;
    }
    public void display(){    //O(n)
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public void addLast(int item){    //O(1)
        Node nn = new Node();
        nn.data = item;
        if(size==0){
            head = nn;
            tail = nn;
            size++;
        }
        else{
            tail.next = nn;
            tail = nn;
            size++;
        }
    }
    public void addFirst(int item){     //O(1)
        Node nn = new Node();
        nn.data = item;
        if(size==0){
            head = nn;
            tail = nn;
            size++;
        }
        else {
            nn.next = head;
            head = nn;
            size++;
        }
    }
    public int getFirst()throws Exception{      //O(1)
        if(size==0){
            throw new Exception("Size of linkedlist is zero");
        }
        return(head.data);
    }
    public int getLast()throws Exception{         //O(1)
        if(size==0){
            throw new Exception("Size of linkedlist is zero");
        }
        return(tail.data);
    }
    public int getAt(int index)throws Exception{       //O(n)
        if(size==0){
            throw new Exception("LL is empty");
        }
        if(index<0 || index>=size){
            throw new Exception("Index out of range");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    private Node getNodeAt(int index)throws Exception{      //O(n)
        if(size==0){
            throw new Exception("LL is empty");
        }
        if(index<0 || index>=size){
            throw new Exception("Index out of range");
        }
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
    public void addAt(int index,int item)throws Exception{       //O(n)
        if(size<=index-1 || index<0){
            throw new Exception("Out of range");
        }
        Node nn = new Node();
        nn.data = item;
        if(size==0){
            addFirst(item);
        }
        else {
            Node temp1 = getNodeAt(index-1);
            Node temp2 = temp1.next;
            temp1.next = nn;
            nn.next = temp2;
        }
        size++;
    }
    public int removeFirst()throws Exception{      //O(1)
        if(size==0){
            throw new Exception("LL is empty");
        }
        int ans = head.data;
        if(size==1){
            head = null;
            tail = null;
        }
        else {
            head = head.next;
        }
        size--;
        return ans;
    }
    public int removeLast()throws Exception{        //O(n)
        if(size==0){
            throw new Exception("LL is empty");
        }
        int ans = tail.data;
        if(size==1){
            head = null;
            tail = null;
        }
        else{
            Node temp = getNodeAt(size-2);
            temp.next = null;
            tail = temp;
        }
        size--;
        return ans;
    }
    public int removeAt(int index)throws Exception{
        if(size==0){
            throw new Exception("LL is empty");
        }
        if(index>=size || index<0){
            throw new Exception("Index out of range");
        }
        int ans = getAt(index);
        if(index==0){
            removeFirst();
        }
        else if(index==size-1){
            removeLast();
        }
        else{
            Node temp1 = getNodeAt(index-1);
            Node temp2 = temp1.next;
            temp1.next = temp2.next;
        }
        size--;
        return ans;
    }
    public void reverseData()throws Exception{
        if(size==0){
            throw new Exception("LL is empty");
        }
        for (int i = 0; i < size/2; i++) {
            Node left = getNodeAt(i);
            Node right = getNodeAt(size-i-1);
            int temp = left.data;
            left.data = right.data;
            right.data = temp;
        }
    }
    public void reversePointers()throws Exception{
        if(size==0){
            throw new Exception("LL is empty");
        }
        int i = 0;
        Node prev = head;
        Node curr = prev.next;
        while(curr!=null){
            Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        Node t = head;
        head=tail;
        tail = t;
        tail.next = null;
    }
    public int midPoint()throws Exception{
        if(size==0){
            throw new Exception("LL is empty");
        }
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
    public int kth_node(int index)throws Exception{
        if(size==0){
            throw new Exception("LL is empty");
        }
        if(index>size){
            throw new Exception("Out of range");
        }
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < index; i++) {
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }
    public void k_reverse(int k)throws Exception{
        if(size==0){
            throw new Exception("Empty ll");
        }
        Node slow = head;
        Node fast = tail;
        while(fast.next!=null){

        }
    }
}
