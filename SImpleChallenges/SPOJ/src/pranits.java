import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/9/13
 * Time: 10:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class pranits {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        int m=Integer.parseInt(br.readLine());
        int p=1;
        for(int i=1;i<=m;i++)
        {
            p*=i;
        }
        for(int i=10;i>=7;i--)
        {
            while((p/i) %i==0)  { System.out.println(p);
                p/=i; }
        }
        System.out.println(p);
        }

}
