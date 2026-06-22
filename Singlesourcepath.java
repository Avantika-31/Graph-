package graph;

import java.util.Arrays;
public class Singlesourcepath {
    int V;
    int[][] graph;
    Singlesourcepath(int V) {
        this.V = V;
        graph = new int[V][V];
    }
    public int minCostVertex(int[] cost, boolean[] visited) {
        int minCost = Integer.MAX_VALUE; int minVertex = Integer.MAX_VALUE;
        for(int i = 0; i < V; i++) {
            if(cost[i] < minCost && !visited[i]) {
                minCost = cost[i];
                minVertex = i;
            }
        }
        return minVertex;
    }
    public void dijkstra(int[][] graph, int start) {
        int[] cost = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        for(int i = 0; i < V-1; i++) {
            int u = minCostVertex(cost, visited);       // cost --> MIN | !visited[i]
            visited[u] = true;
            // find neighbors of 'u'
            for(int v=0; v < V; v++) {
                if(graph[u][v] != 0 && !visited[v] && cost[u] + graph[u][v] < cost[v]) {
                    cost[v] = cost[u] + graph[u][v];
                }
            }
        }
        for(int i=0; i < V; i++)
            System.out.println("Cost from " + start + " to " + i + " - " + cost[i]);
    }
    public static void main(String[] args) {
        int V = 9;
        Singlesourcepath obj = new Singlesourcepath(V);
        obj.graph = new int[][] {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        // obj.prims(obj.graph, 0);
        obj.dijkstra(obj.graph, 8);
    }
}

