package Section4_Arraylist_and_2d_array;

import java.util.ArrayList;

public class arraylist {
    public static void main(String[] args) {
        /*ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list);
        System.out.println(list.size());
        list.add(10) ;
        System.out.println(list);
        System.out.println(list.size());
        list.add(20) ;
        System.out.println(list);
        System.out.println(list.size());
        list.add(30);
        System.out.println(list);
        System.out.println(list.size());
        list.add(40);
        System.out.println(list);
        System.out.println(list.size());
        list.add(50);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(4));
        list.remove(3) ;
        System.out.println(list);
        System.out.println(list.size());*/
        ArrayList<ArrayList<Integer>> list = new ArrayList() ;
        ArrayList<Integer> list2 = new ArrayList() ;
        list2.add(2) ;
        list.add(list2) ;
        list.add(list2) ;
        System.out.println(list2);
        list2.add(25) ;
        System.out.println(list2);
        list2.remove(0) ;
        System.out.println(list2);
        list2.add(2) ;
        System.out.println(list2);
        System.out.println(Math.abs(1));
    }

}
