package algo0414;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_2564_경비원 {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		int cnt=sc.nextInt();
		Stack<int[]> st = new Stack<>();
		for(int i=0;i<cnt+1;i++) {
			int dir=sc.nextInt();
			int k=sc.nextInt();
			if(dir==1) 
				st.add(new int[] {0,k});
			else if(dir==2) 
				st.add(new int[] {M,k});
			else if(dir==3) 
				st.add(new int[] {k,0});
			else if(dir==4) 
				st.add(new int[] {k,N});
		}
		int total=0;
		int p[] = st.pop();
		int y=p[0];
		int x=p[1];
		while(!st.isEmpty()) {
			int store[] = st.pop();
			int s_y=store[0];
			int s_x=store[1];
			int mi_y=Math.abs(y-s_y);
			int mi_x=Math.abs(x-s_x);
			System.out.println(mi_x + " "+mi_y);
			if(mi_y==M) {
				int m_x;
				if(x>mi_x) 
					m_x = Math.min(N-x, s_x);
				else
					m_x=Math.min(N-s_x, x);
				System.out.println(m_x+"mx");
				mi_x+=2*m_x;
			}
			else if(mi_x==N) {
				int m_y;
				if(y>mi_y)
					m_y=Math.min(M-y, s_y);
				else
					m_y=Math.min(M-s_y, y);
				mi_y+=m_y*2;
			}
			total+=mi_y+mi_x;
			System.out.println(total);
		}
		System.out.println(total);
	}

}
