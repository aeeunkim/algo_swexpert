import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class problem1828_정올 {
	static int num;
	static int cnt;
	static class food implements Comparable<food>{
		int start, end;
		public food(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(food o) {
			int diff=this.end-o.end;
			return diff!=0? diff: this.start-o.start;
		}
		@Override
		public String toString() {
			return "food [start=" + start + ", end=" + end + "]";
		}
		
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num=sc.nextInt();
		food [] f =new food[num];
		for(int i=0;i<num;i++) {
			f[i]=new food(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(f);
		ArrayList<food> list = new ArrayList<food>();
		list.add(f[0]);
		cnt+=1;
		for(int i=1,size=f.length;i<size;i++) {
			if(list.get(list.size()-1).end<f[i].start){
				list.add(f[i]);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
