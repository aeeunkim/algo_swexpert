import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_3238_이항계수구하기 {

static long n,r;
static int p;
static long[] nCr;
public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <=T; t++) {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        r = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        nCr = new long[p+1];
        System.out.println("#"+t+" "+nCr(n,r,p));
    }
}
static long power(long x, long y, long p)  { 
    long res = 1L; 
    x = x % p; 
    //=> 3^7 > 7 3 1   3^7 --> 3^1*3^2*3^4             
    while (y > 0) {    
        if (y % 2 == 1) 
            res = (res * x) % p; 
        y = y >> 1; // y = y/2 
        x = (x * x) % p; 
    } 
    return res; 
} 
static long modInverse(long n, long p) { 
    return power(n, p-2, p); 
} 
private static long nCr(long n, long r, int p) {
     if (r == 0) 
            return 1L; 
        long[] fac=new long[p];
        fac[0]=1;
        for (int i = 1; i < fac.length; i++) {
            fac[i]=i*fac[i-1]%p;
        }
        if(n<p) {
            return (fac[(int)n]* modInverse(fac[(int)r], p) % p * modInverse(fac[(int)(n-r)], p)  % p) % p; 
        }else {
            long ret=1;
            while(n>0 || r>0){
                long a=n%p;
                long b=r%p;
                if(a<b) ret=0;
                if(ret==0) break;
                ret*=fac[(int)a];
                ret%=p;
                ret*=modInverse((fac[(int)b]*fac[(int)a-(int)b])%p, p);
                ret%=p;
                n/=p;
                r/=p;
            }
            return ret;
        }
}
}
