import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 8/14/13
 * Time: 8:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Fairy {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tok[] = (br.readLine()).split(" ");
        //ArrayList<Integer> a =new ArrayList<Integer>();
        //ArrayList<Integer> b =new ArrayList<Integer>();
        int m = Integer.parseInt(tok[0]);
        int n = Integer.parseInt(tok[1]);
        int []a=new int[n];
        int []b=new int[n];
        int p,q,t;
        for(int i=0;i<n;i++)
        {
            String toks[] = (br.readLine()).split(" ");
            p = Integer.parseInt(toks[0]);
            q = Integer.parseInt(toks[1]);
            if(p>q)
            {
                t = p;
                p=q;
                q=t;
            }
            a[i]=p;
            b[i]=q;
        }
}
}
