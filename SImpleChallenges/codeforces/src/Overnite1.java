import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 18/1/14
 * Time: 5:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Overnite1 {
    static int []memo;
              static  int MAX=37261;
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int primes[]=new int[37261];
        memo=new int[41];

        int ans[]=new int[MAX];
        ans[0]=0;
            int i,j;
            for(i=0;i<MAX;i++) primes[i] = 1;
            for(i=2;i<=(int)Math.sqrt(MAX);i++)
                if (primes[i]==1)
                    for(j=i;j*i<MAX;j++) primes[i*j] = 0;
            for (i=1;i<MAX;i++){
                  ans[i]=primes[i]+ans[i-1];
            }
        Arrays.fill(memo, -1);
        int cases = Integer.parseInt(br.readLine());
        for( i=0;i<cases;i++){
            int n = Integer.parseInt(br.readLine());
            int m=solve(n);
           System.out.println(m);
            System.out.println(ans[m]-1);
        }

}

    private static int solve(int n) {
        if(memo[n]!=-1)
            return memo[n];
        int res=0;
        if(n==0)
        {
               res= 0;
        }

       else if(n>=4){
            for(int i=1;i<=n-3;i++){
                int x=solve(i-1) ;
                int y=solve(n-(i+3));
                if(x==0){
                    res+=y;
                }
                else if(y==0){
                    res+=x;

                }
              else
                    res+=x*y;
            }
            res++;
        }
        else{
            res= 1;
        }
        memo[n]=res;
        return res;
    }
}
