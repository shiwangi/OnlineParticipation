import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/12/13
 * Time: 7:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Abby1 {
    public static void main(String[] args) throws IOException {
        Map<Integer, Boolean> cache;
        cache = new HashMap<Integer, Boolean>();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String s = br.readLine();
        BigInteger ans = new BigInteger("1");
        int p = 10;
        BigInteger ten = new BigInteger("10");
        int l = s.length();
        char c, ss;
        long a = 1;
        ss = s.charAt(0);

        if (ss == '?') {
            a = 9;
        } else if (64 < ss && ss < 75) {
            a = 9;
            p = 9;
        }
        int q = 0;
        int hzh = 0;
        s=s.replaceAll("[0-9]", "");
        l = s.length();
        s= s.replaceAll("[?]", "");
        q=l-s.length();
        s=s.replaceAll(String.valueOf(ss), "");
        l=s.length();
        for(int i=0;i<l;i++)
        {

            c=s.charAt(i);

                if(hzh==10)
                    continue;
                else if(!(cache.containsKey((int)c)))
                {
                    cache.put((int)c,true);
                    hzh++;
                }

        }

        for (int i = 0; i < hzh; i++) {
            a *= p;
            p--;
        }
        ans = ans.multiply(new BigInteger(String.valueOf(a)));
        ans = ans.multiply(ten.pow(q));
        System.out.println(ans);
    }

}