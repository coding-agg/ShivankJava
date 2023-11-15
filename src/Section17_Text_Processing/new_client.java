package Section17_Text_Processing;

import java.util.BitSet;

public class new_client {
    public static void main(String[] args) {
        String str = "abbccda";
        HuffmanEncoder hf = new HuffmanEncoder(str);
        String codeString = hf.encode(str);
        System.out.println(codeString);
        String decodeString = hf.decode(codeString);
        System.out.println(decodeString);
        BitSet bitSet = new BitSet(codeString.length());
        int bitcounter = 0;
        for (Character c:codeString.toCharArray()){
            if(c.equals('1')){
                bitSet.set(bitcounter);
            }
            bitcounter++;
        }
        byte[] arr = bitSet.toByteArray();
        System.out.println(arr.length);
    }
}
