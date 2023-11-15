package Section14_Interfaces_and_Generics;

import java.util.ArrayList;

public class client_of_pair {
    public static void main(String[] args) {
        Pair<String> pair = new Pair<>();
        pair.one = "abc";
        pair.two = "def";
        Pair<Integer> pair1 = new Pair<>();
        pair1.one = 1;
        pair1.two = 2;
        PairTwo<Integer,String> pair2 = new PairTwo<>();
        pair2.one = 3;
        pair2.two = "Hello";
    }
}
