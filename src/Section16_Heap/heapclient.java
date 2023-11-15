package Section16_Heap;

public class heapclient{
    public static void main(String[] args) {
        Heap h1 = new Heap();
        h1.add(10);
        h1.display();
        h1.add(20);
        h1.add(30);
        h1.add(5);
        h1.display();
        System.out.println();
    }
}
