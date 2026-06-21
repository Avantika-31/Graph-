package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bfsgraph {
    int v;
    int [][] garphs= new int[v][v];
    Bfsgraph(int v){
        this.v=v;
        this.garphs=new int[v][v];
    }
    public void Breadthfirstsearch(int start) {
        boolean[] visited = new boolean[v];
        Arrays.fill(visited, false);
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start]=true;
        while (!que.isEmpty()) {
            int temp = que.poll();
            System.out.println(temp + " ");
            for (int i = 0; i < v; i++) {
                if (garphs[temp][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Bfsgraph g= new Bfsgraph(5);
        Scanner src= new Scanner(System.in);
        int v = src.nextInt();
        Dfsgraph obj = new Dfsgraph(v);

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                obj.graph[i][j] = src.nextInt();
            }
        }
    }

    }

