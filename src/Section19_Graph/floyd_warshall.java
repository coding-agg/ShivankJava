package Section19_Graph;

public class floyd_warshall {
    public static void main(String[] args) {
        int v = 4;
        int[][] graph = {{0,3,10000,7},{8,0,2,10000},{5,10000,0,1},{2,10000,10000,0}};
        int[][] dist = new int[v][v];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[0].length; j++) {
                dist[i][j] = graph[i][j];
            }
        }
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                if(i == k){
                    continue;
                }
                for (int j = 0; j < v; j++) {
                    if(j == k){
                        continue;
                    }
                    int oc = dist[i][j];
                    int nc = dist[i][k] + dist[k][j];
                    if(oc>nc){
                        dist[i][j] = nc;
                    }
                }
            }
            
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();

        }

    }
}
