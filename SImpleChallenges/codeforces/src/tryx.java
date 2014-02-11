import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 1/10/13
 * Time: 10:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class tryx {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        int count[]=new int[n];
        String tok[] = (br.readLine()).split(" ");int h[]=new int[n];
        int []t=new int[n];
               for(int i=0;i<n;i++)
               {
                         h[i]=Integer.parseInt(tok[i]);
               }
        String toks[] = (br.readLine()).split(" ");
        for(int i=0;i<n;i++)
        {
            t[i]=Integer.parseInt(toks[i]);
            count[t[i]]++;
        }

    }

    }
