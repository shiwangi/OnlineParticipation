import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/11/13
 * Time: 10:39 AM
 * To change this template use File | Settings | File Templates.
 */
public class Seq6 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int x[]=new int[10000];
           int n;   int p;
        for(int i=1;i<10000;i++)
        {
           x[i]=i+x[i-1];
        }
        while(((n=Integer.parseInt(br.readLine()))!=0)) {

            long count=1;
          for(int i=2;i<=n;i++)
            {
                 p=n-x[i-1];
                 if(p<=0)
                     break;
                else if(p%i==0)
                    count++;
            }
            System.out.println(count*2);

}
    }
}
