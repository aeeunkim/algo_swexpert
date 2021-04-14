package algo0414;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17144_미세먼지안녕 {
	static int R,C,T;
	static int arr[][];
	static int dx[]= {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R=sc.nextInt();
		C=sc.nextInt();
		T=sc.nextInt();
		int gonggi=-1;
		arr=new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				arr[i][j]=sc.nextInt();
				if(gonggi==-1 && arr[i][j]==-1)
					gonggi=i;
			}
		}
		//확산
		Queue<int[]>que = new LinkedList<int[]>(); //미세먼지
		for(int t=0;t<T;t++) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(arr[i][j]!=0 &&arr[i][j]!=-1)
						que.offer(new int[] {i,j,arr[i][j]});
				}
			}
			while(!que.isEmpty()) {
				int[] q = que.poll();
				int x=q[0];
				int y=q[1];
				int temp=q[2];
				for(int d=0;d<4;d++) {
					int mx=x+dx[d];
					int my=y+dy[d];
					if(check(mx,my)&&arr[mx][my]!=-1) {
						arr[mx][my]+=temp/5;
						arr[x][y]-=temp/5;
					}
				}
			}
			//공기청정기
			int down=gonggi+1;
			int top=gonggi;
			for(int g=down+1;g<R-1;g++)
				arr[g][0]=arr[g+1][0];
			
			for(int g=0;g<C-1;g++)
				arr[R-1][g]=arr[R-1][g+1];
			
			for(int g=R-1;g>down;g--)
				arr[g][C-1]=arr[g-1][C-1];
			
			for(int g=C-1;g>1;g--)
				arr[down][g]=arr[down][g-1];
			
			arr[down][1]=0;
			
			for(int g=top-1;g>0;g--)
				arr[g][0] = arr[g-1][0];
			
			for(int g=0;g<C-1;g++)
				arr[0][g]=arr[0][g+1];
		
			for(int g=0;g<top;g++)
				arr[g][C-1]=arr[g+1][C-1];
			
			for(int g=C-1;g>1;g--)
				arr[top][g] = arr[top][g-1];
		
			arr[top][1]=0;
		}
		int result=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				result+=arr[i][j];
			}
		}
		System.out.println(result+2);
	}
	private static boolean check(int mx, int my) {
		if(mx<0 || my<0 || mx>=R || my >=C)return false;
		return true;
	}

}
