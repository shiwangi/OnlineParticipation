import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 1/11/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Q_partition {

    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine());

        for(int l=0;l<cases;l++)
        {
            int n=Integer.parseInt(br.readLine());
            int c=0;
            String tokens[]=(br.readLine()).split(" ");
            long a[]=new long[n];

            for(int i=0;i<n;i++)
            {
                a[i]=Long.parseLong(tokens[i]);
            }
            int p=Integer.parseInt(br.readLine());
            for(int i=0;i<n;i++)
            {
                if(a[i]<a[p-1])
                c++;
            }

            System.out.println(c+1);
        }
}
}
