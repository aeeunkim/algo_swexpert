package algo0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기2 {
	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
	private static int N,W,H,min;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC= Integer.parseInt(in.readLine());
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			W=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			
			for(int i = 0;i<H;i++) {
				st = new StringTokenizer(in.readLine()," ");
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			min=Integer.MAX_VALUE;
			go(0,map);
			System.out.println("#"+t+" "+min);
		}

	}
	//중복순열로 구술 떨어뜨리기
	//boolean: true면 모두 깨진 상황임
	private static boolean go(int cnt, int[][] map) { // cnt는 구슬을 떨어뜨린 횟수이다. , map: cnt-1까지의 map
		int result= getRemain(map);
		
		if(result==0) {//모두 빈칸 깨뜨릴 벽돌이 없다.
			min=0;
			return true;
		}
		//위에 것은 더이상 하나도 안봐도되는걸로 말해주면 된다.
		//밑은 또 돌아야 된느거고
		if(cnt==N) {
			min = Math.min(min, result);
			return false;
		}
		
		int[][] newMap = new int[H][W];
		//매열마다 구슬을 덜어뜨리는 시도
		for(int c=0;c<W;c++) {
			int r=0;
			while(r<H && map[r][c]==0) ++r;
			if(r==H) {//맞는 벽돌 없음( 모두 빈칸)
				continue; //다음열로 떨어뜨리기

			}else {
				//기존 cnt-1 구슬까지의 상태로 초기화
				copy(map, newMap);
				//벽돌 깨뜨리기
				boom(newMap,r,c);
				//벽돌 내리기
				down(newMap);
				//다음 구슬 던지기
				if(go(cnt+1,newMap))return true;
			}
		}
		return false;
	}
	private static int getRemain(int[][] map) {
		int count=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(map[i][j]>0)++count;
			}
		}
		return count;
	}
	private static void down(int[][] map) {
		for(int c=0;c<W;c++) {
			int r=H-1;
			while(map[r][c]==0) --r;
			if(r<0) continue;//다 빈칸이엇어요 그럼 옆열로 가기

			r=H-1;
			while(r>0) { // 자신의 위치에 내리기
				int nr = r-1;
				while(nr>0 && map[nr][c]==0) --nr;
				map[r][c] = map[nr][c];
				map[nr][c]=0;
			}
			--r;
		}
		
	}
	private static void boom(int[][] map, int r, int c) {
		Queue< Point> que = new LinkedList<Point>();
		if(map[r][c]>1)
			que.offer(new Point(r,c,map[r][c]));
		map[r][c]=0; // 제거처리(방문처리 효과)
		while(!que.isEmpty()) {
			Point p = que.poll();
			for(int d=0;d<4;d++) {
				int nr= p.r;
				int nc=p.c;
				for(int k=1;k<p.cnt;k++) {
					nr+=dr[d];
					nc+=dc[d];
					if(nr>=0 && nr<H && nr>=0 && nc<W && map[nr][nc]!=0) {
						if(map[nr][nc]>1) { //계속 파괴
							que.offer(new Point(nr,nc,map[nr][nc]));
						}
						map[nr][nc]=0;
					}
				}
			}
		}
		
	}
	private static void copy(int[][] map, int[][] newMap) { //reference 받은거라 return안해도됨
		for(int i=0;i<H;i++){
			for(int j=0;j<W;j++)
				newMap[i][j]=map[i][j];
		}
	}

}
