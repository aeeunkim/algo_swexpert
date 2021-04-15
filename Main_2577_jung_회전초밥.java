package algo0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2577_jung_회전초밥 {
	static int N,d,k,c,arr[],num[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		arr=new int[N];
		num=new int[d+1];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(in.readLine());
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			int cnt=0;
			for(int j=0;j<k;j++) {
				int index = i+j;
				if(index>=N) index = index-N;
				if(num[arr[index]]>0)continue;
				if(num[arr[index]]>1500)break;
				num[arr[index]]+=1;
				cnt++;
			}
			if(num[c]==0) cnt++;
			max=Math.max(max, cnt);
			for(int j=0;j<k;j++) {
				int index =i+j;
				if(index>=N) index = index-N;
				num[arr[index]]=0;
			}
		}
		System.out.println(max);
	}

}
