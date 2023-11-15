package Section17_Text_Processing;

import Section16_Heap.HeapGeneric;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HuffmanEncoder {
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;
    public HuffmanEncoder(String feeder){
        //1. to create a frequency map
        HashMap<Character,Integer> fmap = new HashMap<>();
        for (int i = 0; i < feeder.length(); i++) {
            char cc = feeder.charAt(i);
            if(fmap.containsKey(cc)){
                int ov = fmap.get(cc);
                ov = ov+1;
                fmap.put(cc,ov);
            }else{
                fmap.put(cc,1);
            }
        }
        //2. Create the min. heap of trees
        HeapGeneric<Node> minHeap = new HeapGeneric<>();
        Set<Map.Entry<Character,Integer>> entryset = fmap.entrySet();
        for (Map.Entry<Character,Integer> entry:entryset){
            Node node = new Node(entry.getKey(),entry.getValue());
            minHeap.add(node);
        }
        //3. combine nodes until one node is left in heap
        while(minHeap.size()!=1){
            Node minone = minHeap.remove();
            Node mintwo = minHeap.remove();
            Node combined = new Node(minone,mintwo);
            combined.data = '\0';
            combined.cost = minone.cost+ mintwo.cost;
            minHeap.add(combined);
        }
        Node ft = minHeap.remove();
        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();
        this.initEncoderDecoder(ft,"");

    }
    //filling my encoder and decoder
    private void initEncoderDecoder(Node node,String osf){
        if(node == null){
            return;
        }
        if(node.right == null && node.right == null){
            this.encoder.put(node.data,osf);
            this.decoder.put(osf,node.data);
        }
        this.initEncoderDecoder(node.left,osf+0);
        this.initEncoderDecoder(node.right,osf+1);
    }
    public String encode(String source){
        String rv = "";
        for (int i = 0; i < source.length(); i++) {
            String code = this.encoder.get(source.charAt(i));
            rv = rv+code;
        }
        return rv;
    }

    public String decode(String codedstring){
        String rv = "";
        String key = "";
        for (int i = 0; i < codedstring.length(); i++) {
            key = key+codedstring.charAt(i);
            if(this.decoder.containsKey(key)){
                rv = rv+this.decoder.get(key);
                key = "";
            }
        }
        return rv;
    }
    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;
        Node(char data,int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }
        Node(Node left,Node right){
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost-o.cost;
        }
    }

}
