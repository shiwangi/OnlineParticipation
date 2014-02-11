import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/4/13
 * Time: 6:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class Plates {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String s=br.readLine();

        long n=Long.parseLong(br.readLine());
        int len=s.length();int i; long ans=0;long tot_len;tot_len=len*n-len;
        //System.out.println(tot_len);
for( i=len-1;i>=0;i--)
{
    if(s.charAt(i)=='0' || s.charAt(i)=='5')
    {

        ans=((ans%1000000007)+(((long)(Math.pow(2,i)))%1000000007))%1000000007;

    }

 }
        long sol=0;
        if(n==1)
            System.out.println((long)ans);
        else
        {
            while(tot_len>=0)
            {
                sol= ( (sol%1000000007)+(((long)(Math.pow(2,tot_len)))%1000000007))%1000000007;
                tot_len-=len;
            }

             System.out.println((ans*((sol)))%1000000007);
}       }
}
