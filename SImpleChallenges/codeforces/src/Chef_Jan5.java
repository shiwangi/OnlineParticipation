import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/1/14
 * Time: 1:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class Chef_Jan5 {
    static BigInteger rem;
    static long pro(long a,long b)
    {
          BigInteger x=BigInteger.valueOf(a) ;
        BigInteger y=BigInteger.valueOf(b);
        return ((x.multiply(y)).mod(rem)).longValue();
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        int n;
        long x, y, z;
        String s;
        int tmp;
        for (int i = 0; i < cases; i++) {
            n = Integer.parseInt(br.readLine());
            String tokens[] = (br.readLine()).split(" ");
            long a[] = new long[n];
            for (int j = 0; j < n; j++) {
                a[j] = Long.parseLong(tokens[j]);
            }
            String token[] = (br.readLine()).split(" ");
            x = Long.parseLong(token[0]);
            y = Long.parseLong(token[1]);
            z = Long.parseLong(token[2]);
            rem=BigInteger.valueOf(z);
            s = br.readLine();
            long coeff_x = 1;
            long constant = 0;
            int here = 0;
            int end = n - 1;
            boolean rev = false;
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == 'A') {
                    constant = (constant % z + x % z) % z;
                    System.out.print((pro(a[here],coeff_x) + constant) % z + " ");
                    if (rev == true)
                        here--;
                    else
                        here++;

                } else if (s.charAt(j) == 'M') {

                    coeff_x = pro(coeff_x,y);
                    constant = pro(constant,y);
                    System.out.print((pro(a[here],coeff_x) + constant) % z + " ");
                    if (rev == true)
                        here--;
                    else
                        here++;
                } else {
                    System.out.print((pro(a[end],coeff_x) + constant) % z + " ");

                    if (end > here)
                        end--;
                    else
                        end++;
                    tmp = here;
                    here = end;
                    end = tmp;
                    rev = !rev;


                }
            }
            System.out.println();
        }
    }
}
