package graph;

import java.util.Arrays;
import java.util.Scanner;

import java.util.*;

class Dfsgraph {
    int v;
    int[][] graph;
    Dfsgraph(int v) {
        this.v = v;
        this.graph = new int[v][v];
    }
    // -------function for dfs
    public void dfs(int start) {
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        dfsutil(start, visited);
    }

    public void dfsutil(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for (int i = 0; i < v; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfsutil(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);

        int v = src.nextInt();
        Dfsgraph obj = new Dfsgraph(v);

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                obj.graph[i][j] = src.nextInt();
            }
        }

        obj.dfs(0);
    }

}


