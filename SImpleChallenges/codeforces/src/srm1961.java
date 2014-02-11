import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 8/16/13
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm1961 {
    static int gcd(int a,int b){
        {
            if (b==0) return a;
            return gcd(b,a%b);
        }
    }
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tok[] = (br.readLine()).split(" ");
        int m = Integer.parseInt(tok[0]);
        int n= Integer.parseInt(tok[1]);
        long k = Integer.parseInt(tok[2]);
        int incorrect=m-n;
        long end=incorrect*(k-1);
        if(end<k)
            System.out.println(n);
        else{
            long c=0,p=k;
           do {
                c=(c% 1000000009+k% 1000000009 )% 1000000009;
                c =(c* 2);
                p+=k;
            }   while(p<=end);
            c=((c% 1000000009)+((n-end +(end%k))% 1000000009)) %1000000009;

            System.out.println(c);
        }



}
}
