import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/25/13
 * Time: 7:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm1932 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String []token = (br.readLine()).split(" ");
        int n = Integer.parseInt(token[0]);
        int k = Integer.parseInt(token[1]);
        int a[]=new int[n];
        String []tokens= (br.readLine()).split(" ");
        int sum1=0,sum2=0;int c=0;int c2=0;
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(tokens[i]);
            if(c<k){
                sum1+=a[i];c++;
            }
            if(c>=k && c2<k)
            {
                 sum2+=a[i];c2++;
            }
        }
          int key=0;int key2=k;
        for(int i=k+1;i<n-k;i++)
        {
            if(sum2<=sum2-a[i-1]+a[i+k-1]) {
             //   sum2=sum;
                sum2= sum2-a[i-1]+a[i+k-1];
                key2=i;
            }
        }
        if(key==n-k){
            sum2=sum2-a[n-1]+a[n-k-1];
            key2=n-k-1;
        }
        for(int i=n-k-1;i>=0;i--)
        {



            if(i!=key && sum2<=sum2-a[i+k]+a[i] ) {
                //   sum2=sum;
                sum2= sum2-a[i+k]+a[i];
                key2=i;
            }
        }
        System.out.println(key+" "+key2);
    }
}
