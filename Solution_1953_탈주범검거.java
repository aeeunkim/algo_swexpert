package algo0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
		
	static int N,M,R,C,L,map[][];
	static int dr[] = {-1, 0, 0, 1};
	static int dc[] = {0,-1,1,0};
	static String type[] = {
		null,
		"0312",//상하좌우
		"03",//상하
		"12",//좌우
		"02",//상우
		"32",//하우
		"31",//하좌
		"01",//상좌
	}; //다르게 짜는걸 보여주려고 이렇게 한거임
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			L=Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(in.readLine()," ");
				for(int j=0;j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+t+" "+bfs());
		}
	}

	private static int bfs() {
		int result=0, time=1;
		Queue<int[]> que = new LinkedList<int[]>();
		boolean[][] V= new boolean[N][M];
		
		que.offer(new int[] {R,C});
		V[R][C]=true;
		++result;
		while(time++<L) {
			int size = que.size();
			while(size-->0) {
				int[] cur = que.poll();
				int r=cur[0];
				int c=cur[1];
				String info = type[map[r][c]];//현구조물의 타입으로 이동가능한 방향의 정보
				
				for(int d=0, length = info.length();d<length;d++) {
					int dir=info.charAt(d) - '0';
					int nr = r+dr[dir];
					int nc = c+dc[dir];
					if(nr>=0 && nr<N && nc>=0 &&nc<M &&map[nr][nc]>0  && type[map[nr][nc]].contains(Integer.toString(3-dir))&&V[nr][nc]) {
						que.offer(new int[] {nr,nc});
						V[nr][nc]=true;
						++result;
					}
				}
			}
			
		}
		return result;
	}

}
