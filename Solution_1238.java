import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1238 {
    static int [][] graph;
    static int start,max;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t= 1; t <= 10; t++) {
        	max=0;
            int len = sc.nextInt();
            start = sc.nextInt();
            graph = new int[101][101];
            for(int i = 0; i < len/2; i++) 
                graph[sc.nextInt()][sc.nextInt()] = 1;
            bfs();
            System.out.println("#" + t + " " +max);
        }
    }
    
	   static void bfs() {
        int [] V = new int[101];
        int cnt = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        V[start] = 1;

        while(!que.isEmpty()) {
            int current = que.poll();
            for(int i = 1; i< 101; i++) {
				if (graph[current][i] == 1 && V[i] == 0) {
					V[i] = V[current] + 1;
					que.offer(i);
				}
            }
            cnt = V[current];
        }

        for(int i = 1 ; i< 101; i++) {
            if(cnt == V[i])
            	max = max > i ? max : i;
        }
    }

}