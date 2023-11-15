package Section15_Hashmap.generics;

public class LinkedList<T> {
    private class Node{
        T data;
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
        System.out.println();
    }
    public void addLast(T item){    //O(1)
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
    public void addFirst(T item){     //O(1)
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
    public T getFirst()throws Exception{      //O(1)
        if(size==0){
            throw new Exception("Size of linkedlist is zero");
        }
        return(head.data);
    }
    public T getLast()throws Exception{         //O(1)
        if(size==0){
            throw new Exception("Size of linkedlist is zero");
        }
        return(tail.data);
    }
    public T getAt(int index)throws Exception{       //O(n)
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
    public void addAt(int index,T item)throws Exception{       //O(n)
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
    public T removeFirst()throws Exception{      //O(1)
        if(size==0){
            throw new Exception("LL is empty");
        }
        T ans = head.data;
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
    public T removeLast()throws Exception{        //O(n)
        if(size==0){
            throw new Exception("LL is empty");
        }
        T ans = tail.data;
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
    public T removeAt(int index)throws Exception{
        if(size==0){
            throw new Exception("LL is empty");
        }
        if(index>=size || index<0){
            throw new Exception("Index out of range");
        }
        T ans = getAt(index);
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
    public int find(T data){
        int index = 0;
        for (Node temp = this.head; temp!=null ; temp = temp.next) {
            if(temp.data.equals(data)){
                return index;
            }
            index++;
        }
        return -1;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
}
