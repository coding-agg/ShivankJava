package Section15_Hashmap;

import Section15_Hashmap.generics.LinkedList;

import java.util.Set;

public class Hashtable<K,V> {
    private class HTPair{
        K key;
        V value;
        HTPair(K key,V value){
            this.key = key;
            this.value = value;
        }
        public boolean equals(Object other){
            HTPair op = (HTPair) other;
            return this.key.equals(op.key);
        }
        public String toString(){
            return "{"+ this.key + "-" + this.value + "}";
        }
    }
    public static final int DEFAULT_CAPACITY = 10;
    private LinkedList<HTPair>[] bucketArray;
    private int size;

    public Hashtable(){
        this(DEFAULT_CAPACITY);
    }
    public Hashtable(int capacity){
        this.bucketArray =(LinkedList<HTPair>[]) new LinkedList[capacity];
        this.size = 0;
    }
    public void put(K key,V value) throws Exception{
        int bi = hashfunction(key);
        LinkedList<HTPair> bucket = this.bucketArray[bi];
        HTPair pta = new HTPair(key,value);
        if(bucket == null){
            bucket = new LinkedList();
            bucket.addLast(pta);
            bucketArray[bi] = bucket;
            this.size++;
        }
        else{
            int findAt = bucket.find(pta);
            if(findAt == -1) {
                bucket.addLast(pta);
                this.size++;
            }
            else{
                HTPair pair = bucket.getAt(findAt);
                pair.value = value;
            }
        }
        double lamda = (this.size*1.0)/this.bucketArray.length;
        if(lamda>0.75){
            this.rehash();
        }
    }

    private int hashfunction(K key){
        int hc = key.hashCode();
        hc = Math.abs(hc);
        int bi = hc % this.bucketArray.length;
        return bi;
    }
    public void display(){
        for(LinkedList<HTPair> bucket: this.bucketArray){
            if(bucket!=null && !bucket.isEmpty()){
                bucket.display();
            }
            else{
                System.out.println("Null");
            }
        }
    }
    public V get(K key) throws Exception{
        int bi = hashfunction(key);
        LinkedList<HTPair> bucket = this.bucketArray[bi];
        HTPair ptf = new HTPair(key,null);
        if(bucket == null){
            return null;
        }
        else{
            int findat = bucket.find(ptf);
            if(findat == -1){
                return null;
            }else{
                HTPair pair = bucket.getAt(findat);
                return pair.value;
            }
        }
    }
    public V remove(K key)throws Exception{
        int bi = hashfunction(key);
        LinkedList<HTPair> bucket = this.bucketArray[bi];
        HTPair ptf = new HTPair(key,null);
        if(bucket == null){
            return null;
        }
        else{
            int findat = bucket.find(ptf);
            if(findat == -1){
                return null;
            }else{
                HTPair pair = bucket.getAt(findat);
                bucket.removeAt(findat);
                this.size--;
                return pair.value;
            }
        }
    }
    private void rehash() throws Exception{
        LinkedList<HTPair>[] aba = this.bucketArray;
        this.bucketArray = (LinkedList<HTPair>[]) new LinkedList[2*aba.length];
        this.size = 0;
        for (LinkedList<HTPair> ob:aba){
            while(ob!=null && !ob.isEmpty()){
                HTPair pair = ob.removeFirst();
                this.put(pair.key,pair.value);
            }
        }

    }
}
