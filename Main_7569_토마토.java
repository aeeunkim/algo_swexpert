package algo0414;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7569_토마토 {
	static class Point{
		int x,y,z;

		public Point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
	}
	static int M,N,H,cnt;
	static int arr[][][];
	static int dist[][][];
	static int[]dx= {1,0,0,-1,0,0};
	static int[]dy= {0,1,0,0,-1,0};
	static int[]dz= {0,0,1,0,0,-1};
	static Queue<Point> que = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M=sc.nextInt();
		N=sc.nextInt();
		H=sc.nextInt();
		arr=new int[H][N][M];
		dist=new int[H][N][M];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					arr[i][j][k]=sc.nextInt();
					if(arr[i][j][k]==1) que.add(new Point(i,j,k));
				}
			}
		}
		bfs();
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(arr[i][j][k]==0 && dist[i][j][k]==0)
						cnt=-1;
				}
			}
		}
		System.out.println(cnt);
		
	}
	private static void bfs() {
		while(!que.isEmpty()) {
			Point p = que.poll();
			int x=p.x;
			int y=p.y;
			int z=p.z;
			cnt=Math.max(cnt, dist[x][y][z]);
			for(int d=0;d<6;d++) {
				int mx = x+dx[d];
				int my= y+dy[d];
				int mz= z+dz[d];
				if(check(mx,my,mz)) {
					if(dist[mx][my][mz]==0 && arr[mx][my][mz]==0) {
						que.offer(new Point(mx,my,mz));
						dist[mx][my][mz]=dist[x][y][z]+1;
						//cnt=Math.max(cnt, dist[mx][my][mz]);
					}
				}
			}
		}
	}
	private static boolean check(int mx, int my, int mz) {
		if(mx<0 || my<0 || mz<0 || mx>=H || my >=N||mz>=M)return false;
		return true;
	}
}
