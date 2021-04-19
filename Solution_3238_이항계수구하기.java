package algo0419;

import java.util.Scanner;

public class Solution_3238_이항계수구하기 {
	static long n,r,p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		for (int t = 1; t <=T; t++) {
			n=sc.nextLong();
			r=sc.nextLong();
			p=sc.nextLong();
			
			long a= factorial(n);
			long b = (factorial(n-r) * factorial(r) %p);
			long result=a*pow(b,p-2)%p;
			//long bottom=(fac[r] & fac[n-r]) % p;
			System.out.println("#"+t+" "+result);
		}
	}
	static long factorial(long d) {
		long ret=1;
		while(d>1) {
			ret=(ret*d) %p;
			d--;
		}
		return ret;
	}
	
	static long pow(long c,long d) {
		long ret=1;
		long aa=c;
		while(d>0) {
			if(d%2==1)ret=ret*aa%p;
			d=d/2;
			aa=(aa*aa)%p;
		}
		return ret;
	}
}
