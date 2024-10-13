package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Classroom {
    static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        boolean[] vis = new boolean[V];
        System.out.println(cycleusingDFSundirected(graph,vis,0,-1,new boolean[V]));
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));
        //graph[1].add(new Edge(1,4));

        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));
        //graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,0));
        //graph[4].add(new Edge(4,1));
        graph[4].add(new Edge(4,5));

        graph[5].add(new Edge(5,4));
        //graph[5].add(new Edge(5,3));
    }

    public static void BFS(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(0);

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited[node]){
                continue;
            }
            for(Edge edge : graph[node]){
                if(!visited[edge.dest]){
                    queue.add(edge.dest);
                }
            }
            System.out.print(node+" ");
            visited[node] = true;
        }
    }
    public static void DFS(ArrayList<Edge>[] graph){
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while(!stack.isEmpty()){
            int top = stack.pop();
            if(visited[top]){
                continue;
            }
            for(Edge edge : graph[top]){
                if(!visited[edge.dest]){
                    stack.add(edge.dest);
                }
            }
            System.out.print(top+" ");
            visited[top] = true;
        }
    }
    public static void path(ArrayList<Edge>[] graph,boolean[] vis,int curr,String path,int tar){
        if(curr == tar){
            System.out.println(path);
            return;
        }
        vis[curr] = true;
        for(Edge edge : graph[curr]){
            if(!vis[edge.dest]){
                path(graph,vis,edge.dest,path+" "+edge.dest,tar);
            }
        }
        vis[curr] = false;
    }

    public static void DFSRecursion(ArrayList<Edge>[] graph,int curr,boolean[] arr){
        if(arr[curr]){
            return;
        }
        else{
            System.out.print(curr+" ");
        }
        arr[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            DFSRecursion(graph,graph[curr].get(i).dest,arr);
        }
    }
    public static boolean cycleusingDFS(ArrayList<Edge>[] graph,boolean[] vis,int curr,boolean[] rec){
        if(rec[curr]){
            return true;
        }
        if(vis[curr]){
            return false;
        }
        vis[curr] = true;
        rec[curr] = true;
        boolean ans;
        for (int i = 0; i < graph[curr].size(); i++) {
            ans = cycleusingDFS(graph,vis,graph[curr].get(i).dest,rec);
            if(ans){
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }
    public static void topSort(ArrayList<Edge>[] graph,boolean[] vis,int curr,Stack<Integer> stk){
        if(vis[curr]){
            return;
        }
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            topSort(graph,vis,graph[curr].get(i).dest,stk);
        }
        stk.push(curr);
    }
    public static boolean cycleusingDFSundirected(ArrayList<Edge>[] graph,boolean[] vis,int curr,int parent,boolean[] rec){
        if(rec[curr]){
            return true;
        }
        if(vis[curr]){
            return false;
        }
        vis[curr] = true;
        rec[curr] = true;
        boolean ans;
        for (int i = 0; i < graph[curr].size(); i++) {
            int num = graph[curr].get(i).dest;
            if(num == parent){
                continue;
            }
            ans = cycleusingDFSundirected(graph,vis,num,curr,rec);
            if(ans){
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }
}
