package Section17_Text_Processing;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Trie {
    private class Node{
        char data;
        HashMap<Character,Node> children;
        Boolean isTerminal;
        Node(char data,Boolean isTerminal){
            this.data = data;
            this.children = new HashMap<>();
            this.isTerminal = isTerminal;
        }
    }
    private int numWords;
    private Node root;

    Trie(){
        this.root = new Node('\0',false);
        this.numWords = 0;
    }
    public int numWords(){
        return this.numWords;
    }
    public void addWord(String word){
        this.addWord(this.root,word);
    }
    private void addWord(Node parent,String word){
        if(word.length()==0){
            if(parent.isTerminal){

            }else{
                parent.isTerminal = true;
                this.numWords++;
            }
            return;
        }
        char cc = word.charAt(0);
        String ros = word.substring(1);
        Node child = parent.children.get(cc);
        if(child == null){
            child = new Node(cc,false);
            parent.children.put(cc,child);
        }
        this.addWord(child,ros);
    }
    public void display(){
        this.display(this.root,"");
    }
    private void display(Node node,String osf){
        if(node.isTerminal){
            System.out.println(osf);
        }
        Set<Map.Entry<Character,Node>> entries = node.children.entrySet();
        for (Map.Entry<Character,Node> entry : entries){
            this.display(entry.getValue(),osf+entry.getValue().data);
        }
    }
    public boolean search(String word){
        return search(this.root,word);
    }
    private boolean search(Node node,String word){
        if(word.length() == 0){
            if(node.isTerminal){
                return true;
            }else{
                return false;
            }
        }
        char cc = word.charAt(0);
        String ros = word.substring(1);
        if(node == null){
            return false;
        }
        return search(node.children.get(cc),ros);
    }
    public void remove(String word){
        this.remove(this.root,word);
    }
    private void remove(Node node,String word){
        if(word.length() == 0){
            if(node.isTerminal){
                node.isTerminal = false;
                this.numWords--;
            }
            return;
        }
        char cc = word.charAt(0);
        String ros = word.substring(1);
        if(node == null){
            return;
        }
        remove(node.children.get(cc),ros);
        if(!node.isTerminal){
            if(node.children.get(cc)!=null && node.children.get(cc).children == null){
                node.children.remove(cc);
            }
        }

    }



}
