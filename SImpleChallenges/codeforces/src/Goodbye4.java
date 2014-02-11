import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 30/12/13
 * Time: 9:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Goodbye4 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tokens[] = (br.readLine()).split(" ");
        long k, x, n, m;
        k = Long.parseLong(tokens[0]);
        x = Long.parseLong(tokens[1]);
        n = Long.parseLong(tokens[2]);
        m = Long.parseLong(tokens[3]);

        long res;
        String s = "";
        String s2 = "";

        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j <= m / 2; j++) {
                res = solve(k, i, j);
                if (res == x) {
                    long bakar = n - i*2;

                    while ((bakar) != 0) {
                        s += "B";
                        bakar--;
                    }
                    bakar = m - j*2;
                    while ((bakar) != 0) {
                        s2 += "B";
                        bakar--;
                    }

                    while (i != 0) {
                        s += "AC";
                        i--;
                    }
                    while (j != 0) {
                        s2 += "AC";
                        j--;
                    }
                    System.out.println(s);
                    System.out.println(s2);
                    return;
                }
                if(i*2<n && j*2<m && k>2){
                    res = solve(k, i+1, j);
                    if (res == x) {
                        long bakar=n-i*2;
                        while ((bakar - 1) != 0) {
                            s += "B";
                            bakar--;
                        }
                        bakar = m - j*2;

                        while ((bakar - 1) != 0) {
                            s2 += "B";
                            bakar--;
                        }
                        while (i != 0) {
                            s += "AC";
                            i--;
                        }
                        while (j != 0) {
                            s2 += "AC";
                            j--;
                        }
                        s = s + "A";
                        s2 = "C" + s2;
                        System.out.println(s + " " + s2);
                        return;

                    }
                }
            }
        }
        System.out.println("Happy new year!");

    }

    private static long solve(long k, int i, int j) {

        if (k == 1)
            return i;
        if (k == 2)
            return j;
        long last = j;
        long last2 = i;
        long t;
        while ((k - 2) > 0) {
            t = last2;
            last2 = last;
            last = t + last2;
            k--;
        }
        return last;
    }
}