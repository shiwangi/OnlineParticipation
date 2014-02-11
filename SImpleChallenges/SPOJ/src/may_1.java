import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/10/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class may_1 {
    public static int isPossible(int num,int []a,int index)
    {


      return 0;
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        for (int j = 0; j < cases; j++) {
            String tokens[] = (br.readLine()).split(" ");
            int n = Integer.parseInt(tokens[0]);
            int m = Integer.parseInt(tokens[1]);
            int[] a = new int[m];
            int[] p = new int[n];
            String token[] = (br.readLine()).split(" ");
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(token[i]);

            }
            String token2[] = (br.readLine()).split(" ");
            p[0] = Integer.parseInt(token2[0]);
            int c = 0;
            int count = 1;
            int res = 0;
            for (int i = 1; i < n; i++) {
                p[i] = Integer.parseInt(token2[i]);
                if (p[i] == p[i - 1]) {
                    count++;
                    if (i == n - 1) {
                        res += isPossible(count, a, 0);
                    } else {

                        res += isPossible(count, a, 0);
                        c++;
                        count = 1;

                    }
                }


                System.out.println(res);

            }


        }
    }
}