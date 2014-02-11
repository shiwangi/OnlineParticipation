import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/8/13
 * Time: 12:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class Coins {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        long ans[] = new long[100001];
          for (int i = 1; i <= 100000; i++) {
            ans[i] = Math.max(i, ans[i / 2] + ans[i / 3] + ans[i / 4]);
        }

       String s;
       int n;
       while((s=br.readLine())!=null) {
            n = Integer.parseInt(s);
            System.out.println(solve(n, ans));

        }
    }
    public static long solve(int num, long[] ans) {
        if (num <= 100000)
            return ans[num];
        else
            return Math.max(num, solve(num / 2, ans) + solve(num / 3, ans) + solve(num / 4, ans));
    }
}
