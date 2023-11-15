package Section19_Graph;

import Section16_Heap.HeapGeneric;

import java.util.*;

public class Graph {
    private class vertex{
        HashMap<String,Integer> nbrs = new HashMap<>();
    }
    private HashMap<String,vertex> vtces;
    public Graph(){
        this.vtces = new HashMap<>();
    }
    public int numVertex(){
        return this.vtces.size();
    }
    public void addVertex(String vname){
        vertex vtx = new vertex();
        this.vtces.put(vname,vtx);
    }
    public void removeVertex(String vname){
        vertex vtx = this.vtces.get(vname);
        ArrayList<String> keys = new ArrayList<>(vtx.nbrs.keySet());
        for (String key :keys){
            vertex nbrvtx = this.vtces.get(key);
            nbrvtx.nbrs.remove(vname);
        }
        this.vtces.remove(vname);
    }
    public boolean containsVertex(String vname){
        return this.vtces.containsKey(vname);
    }
    public int numEdges(){
//        int sum = 0;
//        Set<Map.Entry<String,vertex>> edges = vtces.entrySet();
//        for (Map.Entry<String,vertex> edge : edges){
//            vertex hello = edge.getValue();
//            sum+= hello.nbrs.size();
//        }
//        return sum;
        int count = 0;
        ArrayList<String> keys = new ArrayList<>(this.vtces.keySet());
        for(String key : keys){
            vertex vtx = this.vtces.get(key);
            count += vtx.nbrs.size();
        }
        return count;
    }
    public boolean containsEdge(String vname1, String vname2){
        vertex vtx1 = this.vtces.get(vname1);
        vertex vtx2 = this.vtces.get(vname2);
        if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)){
            return false;
        }
        return true;
    }
    public void addEdge(String vname1, String vname2, int cost){
        vertex vtx1 = this.vtces.get(vname1);
        vertex vtx2 = this.vtces.get(vname2);
        if(vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)){
            return;
        }
        vtx1.nbrs.put(vname2,cost);
        vtx2.nbrs.put(vname1,cost);
    }
    public void removeEdge(String vname1, String vname2){
        vertex vtx1 = this.vtces.get(vname1);
        vertex vtx2 = this.vtces.get(vname2);
        if(vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)){
            return;
        }
        vtx1.nbrs.remove(vname2);
        vtx2.nbrs.remove(vname1);
    }
    public void display(){
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for (String key : keys){
            vertex vtx = vtces.get(key);
            System.out.println(key+" : "+vtx.nbrs);
        }
    }
    public boolean hasPath(String vname1,String vname2,HashMap<String,Boolean> processed){
        processed.put(vname1,true);
        if(containsEdge(vname1,vname2)){
            return true;
        }
        vertex vtx = vtces.get(vname1);
        ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
        for (String nbr : nbrs){
            if(!processed.containsKey(nbr) && hasPath(nbr,vname2,processed)){
                return true;
            }
        }
        return false;
    }
    private class pair{
        String vname;
        String psf;
    }
    public boolean bfs(String src,String dst){                //breadth first search
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();
        pair sp = new pair();
        sp.vname = src;
        sp.psf = src;
        queue.addLast(sp);
        while(!queue.isEmpty()){
            pair rp = queue.removeFirst();
            if(processed.containsKey(rp.vname)){
                continue;
            }
            processed.put(rp.vname,true);

            if(containsEdge(rp.vname,dst)){
                return true;
            }
            vertex rpvtx = vtces.get(rp.vname);
            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
            for (String nbr : nbrs){
                if(!processed.containsKey(nbr)){
                    pair np = new pair();
                    np.vname = nbr;
                    np.psf = rp.psf + nbr;
                    queue.addLast(np);
                }
            }
        }
        return false;
    }
    public boolean dfs(String src,String dst){           //depth first search
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<pair> stack = new LinkedList<>();
        pair sp = new pair();
        sp.vname = src;
        sp.psf = src;
        stack.addFirst(sp);
        while(!stack.isEmpty()){
            pair rp = stack.removeFirst();
            if(processed.containsKey(rp.vname)){
                continue;
            }
            processed.put(rp.vname,true);

            if(containsEdge(rp.vname,dst)){
                return true;
            }
            vertex rpvtx = vtces.get(rp.vname);
            ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
            for (String nbr : nbrs){
                if(!processed.containsKey(nbr)){
                    pair np = new pair();
                    np.vname = nbr;
                    np.psf = rp.psf + nbr;
                    stack.addFirst(np);
                }
            }
        }
        return false;
    }
    public void bft(){                //breadth first traversal
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for (String key : keys) {
            if(processed.containsKey(key)){
                continue;
            }
            pair sp = new pair();
            sp.vname = key;
            sp.psf = key;
            queue.addLast(sp);
            while (!queue.isEmpty()) {
                pair rp = queue.removeFirst();
                if (processed.containsKey(rp.vname)) {
                    continue;
                }
                processed.put(rp.vname, true);
                System.out.println(rp.vname+" "+rp.psf);
                vertex rpvtx = vtces.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        pair np = new pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        queue.addLast(np);
                    }
                }
            }
        }
    }
    public void dft(){           //depth first traversal
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<pair> stack = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for (String key : keys) {
            pair sp = new pair();
            sp.vname = key;
            sp.psf = key;
            stack.addFirst(sp);
            while (!stack.isEmpty()) {
                pair rp = stack.removeFirst();
                if (processed.containsKey(rp.vname)) {
                    continue;
                }
                processed.put(rp.vname, true);
                System.out.println(rp.vname+" "+rp.psf);
                vertex rpvtx = vtces.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        pair np = new pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        stack.addFirst(np);
                    }
                }
            }
        }
    }
    public boolean isCyclic(){                //breadth first traversal
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for (String key : keys) {
            if(processed.containsKey(key)){
                continue;
            }
            pair sp = new pair();
            sp.vname = key;
            sp.psf = key;
            queue.addLast(sp);
            while (!queue.isEmpty()) {
                pair rp = queue.removeFirst();
                if (processed.containsKey(rp.vname)) {
                    return true;
                }
                processed.put(rp.vname, true);
                vertex rpvtx = vtces.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        pair np = new pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        queue.addLast(np);
                    }
                }
            }
        }
        return false;
    }
    public boolean isConnected(){                //breadth first traversal
        int flag = 0;
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for (String key : keys) {
            if(processed.containsKey(key)){
                continue;
            }
            flag++;
            pair sp = new pair();
            sp.vname = key;
            sp.psf = key;
            queue.addLast(sp);
            while (!queue.isEmpty()) {
                pair rp = queue.removeFirst();
                if (processed.containsKey(rp.vname)) {
                    continue;
                }
                processed.put(rp.vname, true);
                vertex rpvtx = vtces.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        pair np = new pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        queue.addLast(np);
                    }
                }
            }
        }
        if(flag >=2){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean isTree(){
        return isConnected() && !isCyclic();
    }
    public ArrayList<ArrayList<String>> getConnected(){                //breadth first traversal
        ArrayList<ArrayList<String>> vertices = new ArrayList<>();
        HashMap<String,Boolean> processed = new HashMap<>();
        LinkedList<pair> queue = new LinkedList<>();
        ArrayList<String> keys = new ArrayList<>(vtces.keySet());
        for (String key : keys) {
            if(processed.containsKey(key)){
                continue;
            }
            ArrayList<String> vertice = new ArrayList<>();
            pair sp = new pair();
            sp.vname = key;
            sp.psf = key;
            queue.addLast(sp);
            while (!queue.isEmpty()) {
                pair rp = queue.removeFirst();
                if (processed.containsKey(rp.vname)) {
                    continue;
                }
                vertice.add(rp.vname);
                processed.put(rp.vname,true);
                vertex rpvtx = vtces.get(rp.vname);
                ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
                for (String nbr : nbrs) {
                    if (!processed.containsKey(nbr)) {
                        pair np = new pair();
                        np.vname = nbr;
                        np.psf = rp.psf + nbr;
                        queue.addLast(np);
                    }
                }
            }
            vertices.add(vertice);
        }
        return vertices;
    }
    private class PrimsPair implements Comparable<PrimsPair>{
        String vname;
        String acqvname;
        int cost;

        @Override
        public int compareTo(PrimsPair o) {
            return o.cost-this.cost;
        }
    }
    public Graph prims(){
        Graph mst = new Graph();
        HashMap<String,PrimsPair> map = new HashMap<>();
        HeapGeneric<PrimsPair> heap = new HeapGeneric<>();
        for (String key : vtces.keySet()){
            PrimsPair np = new PrimsPair();
            np.vname = key;
            np.acqvname = null;
            np.cost = Integer.MAX_VALUE;
            heap.add(np);
            map.put(key,np);
        }
        while(!heap.isEmpty()){
            PrimsPair rp = heap.remove();
            map.remove(rp.vname);

            if(rp.acqvname == null){
                mst.addVertex(rp.vname);
            }
            else{
                mst.addVertex(rp.vname);
                mst.addEdge(rp.vname,rp.acqvname, rp.cost);
            }
            for (String nbr : vtces.get(rp.vname).nbrs.keySet()){
                if(map.containsKey(nbr)){
                    int oc = map.get(nbr).cost;
                    int nc = vtces.get(rp.vname).nbrs.get(nbr);
                    if(nc<oc){
                        PrimsPair gp = map.get(nbr);
                        gp.acqvname = rp.vname;
                        gp.cost = nc;
                        heap.updatePriority(gp);
                    }
                }
            }
        }

        return mst;
    }

    private class DijkstraPair implements Comparable<DijkstraPair>{
        String vname;
        String psf;
        int cost;

        @Override
        public int compareTo(DijkstraPair o) {
            return o.cost-this.cost;
        }
    }
    public HashMap<String,Integer> dijkstra(String src){
        HashMap<String,Integer> ans = new HashMap<>();
        HashMap<String,DijkstraPair> map = new HashMap<>();
        HeapGeneric<DijkstraPair> heap = new HeapGeneric<>();
        for (String key : vtces.keySet()){
            DijkstraPair np = new DijkstraPair();
            np.vname = key;
            np.psf = "";
            np.cost = Integer.MAX_VALUE;
            if(key.equals(src)){
                np.psf = key;
                np.cost = 0;
            }
            heap.add(np);
            map.put(key,np);
        }
        while(!heap.isEmpty()){
            DijkstraPair rp = heap.remove();
            map.remove(rp.vname);
            ans.put(rp.vname,rp.cost);
            for (String nbr : vtces.get(rp.vname).nbrs.keySet()){
                if(map.containsKey(nbr)){
                    int oc = map.get(nbr).cost;
                    int nc = rp.cost + vtces.get(rp.vname).nbrs.get(nbr);
                    if(nc<oc){
                        DijkstraPair gp = map.get(nbr);
                        gp.psf = rp.psf + nbr;
                        gp.cost = nc;
                        heap.updatePriority(gp);
                    }
                }
            }
        }

        return ans;
    }
    public class DisjointSet{
        HashMap<String, Node> map = new HashMap<>();
        private class Node{
            String data;
            Node parent;
            int rank;
        }
        public void create(String value){
            Node nn = new Node();
            nn.data = value;
            nn.parent = nn;
            nn.rank = 0;
            map.put(value,nn);
        }
        public void union(String value1,String value2){
            Node n1 = map.get(value1);
            Node n2 = map.get(value2);

            Node re1 = find(n1);
            Node re2 = find(n2);
            if(re1.data == re2.data){
                return;
            }
            else{
                if(re1.rank == re2.rank){
                    re2.parent = re1;
                    re1.rank++;
                }
                else{
                    if(re1.rank>re2.rank){
                        re2.parent = re1;
                        re1.rank++;
                    }
                    else{
                        re1.parent = re2;
                        re2.rank++;
                    }
                }
            }
        }
        public String find(String value){
            return find(map.get(value)).data;
        }
        private Node find(Node node){
            if(node.parent == node){
                return node;
            }
            Node rr = find(node.parent);
            return rr;
        }
    }
    private class EdgePair implements Comparable<EdgePair>{
        String v1;
        String v2;
        int cost;

        @Override
        public int compareTo(EdgePair o) {
            return this.cost-o.cost;
        }
        public String toString(){
            return (v1+"-"+v2+":"+cost);
        }
    }
    public ArrayList<EdgePair> getAllEdges(){
        ArrayList<EdgePair> edges = new ArrayList<>();
        for (String vname: vtces.keySet()){
            vertex vtx = vtces.get(vname);
            for (String nbr : vtx.nbrs.keySet()){
                EdgePair ep = new EdgePair();
                ep.v1 = vname;
                ep.v2 = nbr;
                ep.cost = vtx.nbrs.get(nbr);
                edges.add(ep);
            }
        }
        return edges;
    }
    public void kruskal(){
        ArrayList<EdgePair> edges = getAllEdges();
        Collections.sort(edges);
        System.out.println(edges);
        DisjointSet set = new DisjointSet();
        for (String vname:vtces.keySet()){
            set.create(vname);
        }
        for (EdgePair edge: edges){
            String re1 = set.find(edge.v1);
            String re2 = set.find(edge.v2);
            if(re1.equals(re2)){
                continue;
            }
            else{
                System.out.println(edge);
                set.union(edge.v1,edge.v2);
            }
        }
    }
    public HashMap<String,Integer> bellmanFord(String src) throws Exception{
        ArrayList<EdgePair> edges = getAllEdges();
        HashMap<String,Integer> map = new HashMap<>();
        for (String vname : vtces.keySet()){
            map.put(vname,100000);
            if(src.equals(vname)){
                map.put(vname,0);
            }
        }
        int v = vtces.size();
        for (int i = 1; i <=v ; i++) {
            for (EdgePair edge:edges){
                int oc = map.get(edge.v2);
                int nc = map.get(edge.v1) + edge.cost;
                if(oc>nc){
                    if(i<=v-1) {
                        map.put(edge.v2, nc);
                    }
                    else{
                        throw new Exception("-ve wt cycle present");
                    }
                }
            }
        }
        return map;
    }
}
