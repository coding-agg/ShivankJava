package Section19_Graph;

import java.util.HashMap;

public class GraphClient {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A","B",2);
        graph.addEdge("A","D",10);
        graph.addEdge("B","C",3);
        graph.addEdge("C","D",1);
        graph.addEdge("D","E",8);
        graph.addEdge("E","F",5);
        graph.addEdge("E","G",6);
        graph.addEdge("F","G",4);
        //graph.removeEdge("D","C");
        //graph.removeEdge("E","D");
        //System.out.println(graph.getConnected());
//        graph.prims().display();
//        System.out.println("*******************************");
//        System.out.println(graph.dijkstra("A"));
        System.out.println(graph.bellmanFord("A"));
    }
}
