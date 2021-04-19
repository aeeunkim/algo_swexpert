package algo0419;

import java.util.Scanner;

public class Solution_방향전환8382 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		int dx[]= {0,0,-1,1};
		int dy[]= {1,-1,0,0};
		for(int i=1;i<=T;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2 =sc.nextInt();
			int x=Math.abs(x1-x2);
			int y=Math.abs(y1-y2);
			int t=(x+y)/2;
			int res = 2*t + Math.abs(x-t)+Math.abs(y-t);
			System.out.println("#"+i+" "+res);
		}
	}

}
