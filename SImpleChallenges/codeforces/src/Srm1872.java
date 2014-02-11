import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/7/13
 * Time: 9:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm1872 {


    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String tokens[]=(br.readLine()).split(" ");
        int n=Integer.parseInt(tokens[0]);
        int m=Integer.parseInt(tokens[1]);

        String token[]=(br.readLine()).split(" ");
       int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(token[i]);
        }
        int ans=0;
        for(int j=0;j<m;j++)
        {
        String tok[]=(br.readLine()).split(" ");
        int t=Integer.parseInt(tok[0]);
            //System.out.println(t);
        switch (t)
        {
            case 1: a[Integer.parseInt(tok[1])-1]=Integer.parseInt(tok[2])-ans;
                break;
            case 2:ans+=Integer.parseInt(tok[1]);
                   // System.out.println(ans);
                    break;
            case 3: System.out.println(a[Integer.parseInt(tok[1])-1]+ans);
                break;
        }
        }
}
}
