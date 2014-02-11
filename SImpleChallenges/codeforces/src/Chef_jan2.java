import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 3/1/14
 * Time: 9:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Chef_jan2 {
    static class S implements Comparable<S>{
        long l,m;
        S(long g,long j)
        {
            l=g;m=j;
        }

        @Override
        public int compareTo(S o) {
            if(l==o.l)
            {
                if(m>o.m)
                    return 1;
                else if(m<o.m)
                    return -1;
                else return 0;
            }
            else
                return 1;
        }
    }
    static TreeMap<S,Long> h;
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
        String tokens[] = (br.readLine()).split(" ");
        long l,d,s,c;
            h=new TreeMap<S, Long>();
        l = Long.parseLong(tokens[0]);
        d = Long.parseLong(tokens[1]);
        s = Long.parseLong(tokens[2]);
        c = Long.parseLong(tokens[3]);
            //System.out.print(power(1+c,d-1));
        if(s*(power(1 + c, d - 1))>=l)
            System.out.println("ALIVE AND KICKING");
        else
            System.out.println("DEAD AND ROTTING");
    }
    }
    private static long power(long l, long l1) {
       if(h.containsKey(new S(l,l1))){
                return h.get(new S(l,l1));
       }

        if(l1==1)
        {
            return l;
        }
        if(l1==0)
        {
            return 1;
        }
        long cal1=power(l,(l1)/2);
        long cal2=power(l,(l1+1)/2);
        long x= (((cal1>=1000000000)?1000000000:cal1)*((cal2>=1000000000)?1000000000:cal2));
        x=(x>=1000000000)?1000000000:x;
        h.put(new S(l,l1),x);
        return x;
    }
}
