package Section15_Hashmap;

public class HashClient {
    public static void main(String[] args) throws Exception{
        Hashtable<String, Integer> map = new Hashtable<>(3);
        map.put("USA",200);
        map.put("UK",175);
        map.put("India",325);
        map.put("China",350);
        map.put("Swedan",100);
        map.put("Nepal",50);
        map.put("Ireland",75);
        map.display();
//        System.out.println(map.get("India"));
//        System.out.println(map.remove("India"));
//        System.out.println();
//        map.display();
    }
}
