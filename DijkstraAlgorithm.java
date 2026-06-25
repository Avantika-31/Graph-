import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.*;
    public class DijkstraAlgorithm {
        int V;
        List<List<int[]>> graph = new ArrayList<>();
        DijkstraAlgorithm(int V) { this.V = V; }

        public void addEdge(int u, int v, int w) {
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        public void displayGraph() {
            for(int u=0; u < graph.size(); u++) {
                System.out.print(u + " : ");
                for(int v=0; v < graph.get(u).size(); v++) {
                    System.out.print("{ " + graph.get(u).get(v)[0] + " , " + graph.get(u).get(v)[1] + " } ");
                }
                System.out.println();
            }
        }

        public void dijkstraAlgorithm(List<List<int[]>> graph, int start) {

            PriorityQueue<int[]> pq =
                    new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

            int[] cost = new int[V];
            Arrays.fill(cost, Integer.MAX_VALUE);

            cost[start] = 0;
            pq.offer(new int[]{start, 0});

            while (!pq.isEmpty()) {

                int[] curr = pq.poll();

                int u = curr[0];
                int dist = curr[1];

                if (dist > cost[u])
                    continue;

                for (int[] next : graph.get(u)) {

                    int des = next[0];
                    int weight = next[1];

                    if (cost[u] + weight < cost[des]) {

                        cost[des] = cost[u] + weight;

                        pq.offer(new int[]{des, cost[des]});
                    }
                }
            }

            System.out.println("Shortest distances from source " + start);
            for (int i = 0; i < V; i++) {
                System.out.println(i + " -> " + cost[i]);
            }
        }

        public static void main(String[] args) {
            DijkstraAlgorithm obj = new DijkstraAlgorithm(9);
            for(int i=0; i < obj.V; i++)
                obj.graph.add(new ArrayList<>(i));
            obj.addEdge(0, 1, 4);
            obj.addEdge(0, 7, 8);
            obj.addEdge(1, 7, 11);
            obj.addEdge(1, 2, 8);
            obj.addEdge(7, 8, 7);
            obj.addEdge(7, 6, 1);
            obj.addEdge(2, 8, 2);
            obj.addEdge(2, 3, 7);
            obj.addEdge(2, 5, 4);
            obj.addEdge(6, 8, 6);
            obj.addEdge(6, 5, 2);
            obj.addEdge(5, 3, 14);
            obj.addEdge(5, 4, 10);
            obj.addEdge(3, 4, 9);

            // System.out.println(obj.graph);
            obj.displayGraph();
            obj.dijkstraAlgorithm(obj.graph,0);
        }
    }

