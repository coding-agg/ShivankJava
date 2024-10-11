package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Classroom2 {
    static class EdgeWT{
        int src;
        int dest;
        int wt;
        public EdgeWT(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int node;
        int dist;
        public Pair(int node,int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<EdgeWT>[] graph = new ArrayList[V];
        createGraph(graph);
        Dijkstra(graph,new int[V]);
        BellmanFord(graph,0);
        primsAlgo(graph,V);

    }
    public static void createGraph(ArrayList<EdgeWT>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new EdgeWT(0,1,10));
        graph[0].add(new EdgeWT(0,2,15));
        graph[0].add(new EdgeWT(0,3,30));

        graph[1].add(new EdgeWT(1,0,10));
        graph[1].add(new EdgeWT(1,3,40));

        graph[2].add(new EdgeWT(2,0,15));
        graph[2].add(new EdgeWT(2,3,50));

        graph[3].add(new EdgeWT(3,1,40));
        graph[3].add(new EdgeWT(3,2,50));
    }

    public static void primsAlgo(ArrayList<EdgeWT>[] graph,int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[V];
        pq.add(new Pair(0,0));
        int ans = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.node]){
                vis[curr.node] = true;
                ans += curr.dist;
                for (int i = 0; i < graph[curr.node].size(); i++) {
                    EdgeWT e = graph[curr.node].get(i);
                    if(!vis[e.dest]){
                        pq.add(new Pair(e.dest,e.wt));
                    }
                }
            }
        }
        System.out.println("Cost of MST " + ans);
    }
    public static void Dijkstra(ArrayList<EdgeWT>[] graph, int[] dist){
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0,0));
        dist[0] = 0;
        boolean[] vis = new boolean[graph.length];
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            if(!vis[p.node]) {
                vis[p.node] = true;
                for (int i = 0; i < graph[p.node].size(); i++) {
                    EdgeWT edge = graph[p.node].get(i);
                    if (dist[edge.src] + edge.wt < dist[edge.dest]) {
                        dist[edge.dest] = dist[edge.src] + edge.wt;
                        queue.add(new Pair(edge.dest, dist[edge.dest]));
                    }
                }
            }
        }
        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
    }
    public static void BellmanFord(ArrayList<EdgeWT>[] graph,int src){
        int len = graph.length;
        int[] dist = new int[len];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i <len-1 ; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < graph[j].size(); k++) {
                    EdgeWT edge = graph[j].get(k);
                    if(dist[edge.src] == Integer.MAX_VALUE){
                        continue;
                    }
                    if(dist[edge.src]+edge.wt<dist[edge.dest]){
                        dist[edge.dest] = dist[edge.src] + edge.wt;
                    }
                }
            }
        }

        //Negative Weight Cycle detection
        for (int j = 0; j < len; j++) {
            int flag = 0;
            for (int k = 0; k < graph[j].size(); k++) {
                EdgeWT edge = graph[j].get(k);
                if(dist[edge.src] == Integer.MAX_VALUE){
                    continue;
                }
                if(dist[edge.src]+edge.wt<dist[edge.dest]){
                    System.out.println("Negative Weight Cycle");
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
        }

        for(int i : dist){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
