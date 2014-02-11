import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/13/13
 * Time: 3:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Orders {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());

        for (int j = 0; j < cases; j++) {
            int n = Integer.parseInt(br.readLine());
            int[] p = new int[n];
            int[] ans = new int[n];int bigger[]=new int[n+1];
            String token[] = (br.readLine()).split(" ");
            for (int i = 0; i < n; i++)
                p[i] = Integer.parseInt(token[i]);
            for(int i=n-1;i>=0;i--)
            {

                ans[i]=i+1-p[i];
                  while(bigger[ans[i]]!=0)
                    ans[i]+=bigger[ans[i]];

                for(int k=ans[i];k<n;k++)
                    bigger[k]++;
            }



                for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();

        }
    }
}