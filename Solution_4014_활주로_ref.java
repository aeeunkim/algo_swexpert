package algo0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로_ref {
	static int N,X,map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		for(int t=1;t<=TC;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st=new StringTokenizer(in.readLine()," ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+t+" "+process());
		}
	}
	private static int process() {
		int count=0;
		for (int i = 0; i < N; i++) {
			if(makeRoad(map[i])) ++count;
			if(makeRoad(tmap[i])) ++count;
		}
		return count;
	}
	

	private static boolean makeRoad(int[] road) {
		int beforeHeight = road[0], size = 0; //size는 연속된 동일 개수
		int j=0;//탐색열 위치
		while(j<N) {
			if(beforeHeight == road[j]) {
				++size;
				++j;
			}else if(beforeHeight+1 == road[j]) {//오르막 경사로 설치 가능한지 판단
				if(size<X)return false;//경사로 설치 불가
				beforeHeight++;
				size=1;
				++j;
			}else if(beforeHeight-1==road[j]) {//내리막 경사로 설치 가능한지 판단
				int count=0;
				for(int k=j;k<N;k++) {
					if(road[j]!=beforeHeight-1)break;
					if(++count==X)break;
				}
				if(count<X) return false;//경사로 설치 불가
				beforeHeight--;
				size=0;
				j+=X;
			}else {
				return false;
			}
			
		}
		return true;
	}
}
