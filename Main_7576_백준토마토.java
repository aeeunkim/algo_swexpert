package algo0414;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576_백준토마토 {
	static class point{
		int x,y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int dx[]= {0,0,-1,1};
	static int dy[]= {1,-1,0,0};
	static int N,M,cnt;
	static int arr[][];
	static int dist[][];
	static Queue<point> que = new LinkedList<point>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		arr=new int[M][N];
		dist=new int[M][N];
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=sc.nextInt();
				if(arr[i][j]==1)
					que.add(new point(i,j));
			}
		}
		bfs();
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==0 && dist[i][j]==0)
					cnt=-1;
			}
		}
		System.out.println(cnt);
	}
	private static void bfs() {
		while(!que.isEmpty()) {
			point p = que.poll();
			int x= p.x;
			int y=p.y;
			for(int d=0;d<4;d++) {
				int mx=x+dx[d];
				int my=y+dy[d];
				if(check(mx,my)) {
					if(arr[mx][my]==0 && dist[mx][my]==0) {
						que.add(new point(mx,my));
						dist[mx][my]=dist[x][y]+1;
						cnt=Math.max(cnt, dist[mx][my]);
					}
				}
			}
		}
	}
	private static boolean check(int mx, int my) {
		if(mx<0 || my<0 || mx>=M|| my>=N) return false;
		return true;
	}

}
