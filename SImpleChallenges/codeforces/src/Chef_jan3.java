import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 4/1/14
 * Time: 12:45 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;

public class Chef_jan3 {
    static S a[];

    static class S implements Comparable<S> {
        int start, end, pos;

        S(int s, int e, int p) {
            start = s;
            end = e;
            pos = p;
        }
        @Override
        public int compareTo(S o) {
            if ((pos - o.pos) > 0)
                return 1;
            if ((pos - o.pos) < 0)
                return -1;
            if (start - o.start > 0)
                return 1;
            if (start - o.start < 0)
                return -1;
            return 0;    //To change body of implemented methods use File | Settings | File Templates.
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        int si, ei, pi;
        for (int i = 0; i < cases; i++) {
            String tokens[] = (br.readLine()).split(" ");
            int n = Integer.parseInt(tokens[0]);
            a = new S[n];
            for (int j = 0; j < n; j++) {
                String token[] = (br.readLine()).split(" ");
                si = Integer.parseInt(token[0]);
                ei = Integer.parseInt(token[1]);
                pi =Integer.parseInt(token[2]);
                a[j] = new S(si, ei, pi);
            }
            Arrays.sort(a);
            int ans = 0;
            if(n==1)
            {
                ans=1;
            }
            else if(n>1){
            int res=1;
           int last_end = a[0].end;
            for (int j = 1; j < n; j++) {
                if (a[j].pos == a[j - 1].pos) {
                    if (last_end <= a[j].start) {
                        last_end = a[j].end;
                        res++;
                    }
                    else if (last_end > a[j].end) {
                        last_end = a[j].end;
                    }
                    if (j == n - 1) {
                        ans += res;
                    }
                } else {
                    ans += res;
                    res=1;
                    last_end = a[j].end;
                    if (j == n - 1) {
                        ans += res;
                    }
                }
            }
            }
            System.out.println(ans);
        }
    }

}
