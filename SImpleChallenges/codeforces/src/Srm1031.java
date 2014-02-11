import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/25/13
 * Time: 6:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm1031
{
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
       int n =Integer.parseInt (br.readLine());
        String m=br.readLine();char s;int flag;
        int l=m.length(); int ans=0;
    for(int i=0;i<l;i++)  {
        if(i%n == n-3){
            int c=0;
            s=m.charAt(i);
            flag=0;
            while(c!=2)
            {
                c++;
                if(i>=l-1){
                    flag=1;
                    break;
                }
                if(s!=m.charAt(++i))
                {
                    flag=1;break;
                }
            }
            if(i<l-1)
            if(flag==0)
                ans++;
        }

    }
        System.out.println(ans);
    }
}
