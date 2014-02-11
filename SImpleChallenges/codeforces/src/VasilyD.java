import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 8/12/13
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class VasilyD {
    static int fac(int m, int n) {
        int a, b;
        int p = 1, p1 = 1;
        if (m > n) {
            a = m;
            b = n;
        } else {
            a = n;
            b = m;
        }
        for (int i = 2; i <= a; i++) {
            p *= i;
            if (i == b)
                p1 = p;
        }
        return p * p1;
    }

    String[] stat=new String [1000000];
    static int j = 0;

     void solve(String s, int m, int n) {
            if (m == 1 && n == 0) {
                stat[j] = s + "0";
                j++;
                return ;
            } else if (n == 1 && m == 0) {
                stat[j] = s + "1";
                j++;
                return;
            } else {
               // System.out.println(s);
                solve(s.concat("0"), m - 1, n);
                solve(s.concat("1"), m, n - 1);
            }

    }
   String find(String s)
    {
        int length=s.length();
       while(length!=1)
       {
           if(s.substring(length-2,length).equals("00"))
                s=s.substring(0,length-2)+"1";
           else
               s=s.substring(0,length-2)+"0";
           length=s.length();
       }
        return s;
    }
    public static void main(String[] args) throws IOException {
        VasilyD d=new VasilyD();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tok[] = (br.readLine()).split(" ");
        int m = Integer.parseInt(tok[0]);
        int n = Integer.parseInt(tok[1]);
        int k = Integer.parseInt(tok[2]);
        d.solve("",m,n);
        int ans=0;
         for(int i=0;i<d.j;i++)
         {
          ans= ((Integer.parseInt(d.find(d.stat[i])))==k)?ans+1:ans;
         }
        System.out.println(ans);

        //if the returned value if =k then add to the answer.
    }
}
