package graph;
import java.util.*;

public class PrimsList {
    static int spanningTree(int V, int[][] edges) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build Graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        boolean[] vis = new boolean[V];

        // {weight, node}
        PriorityQueue<int[]> pq =
                new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0});

        int mstWeight = 0;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int wt = curr[0];
            int node = curr[1];

            if (vis[node]) continue;

            vis[node] = true;
            mstWeight += wt;

            for (int[] nbr : adj.get(node)) {

                int nextNode = nbr[0];
                int nextWt = nbr[1];

                if (!vis[nextNode]) {
                    pq.offer(new int[]{nextWt, nextNode});
                }
            }
        }

        return mstWeight;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        int[][] edges = new int[E][3];

        System.out.println("Enter edges (u v w):");

        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        int ans = spanningTree(V, edges);

        System.out.println("Weight of MST = " + ans);

        sc.close();
    }
}