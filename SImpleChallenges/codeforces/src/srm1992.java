import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 9/7/13
 * Time: 2:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm1992 {

    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tok[] = (br.readLine()).split(" ");
        int m,n,s,f;
        n = Integer.parseInt(tok[0]);
        m = Integer.parseInt(tok[1]);
        s = Integer.parseInt(tok[2]);
        f = Integer.parseInt(tok[3]);
        int dx;
        if(f<s)
            dx=-1;
        else
            dx=1;
        int t,l,r;
        int k=0;
        int time_now=1;
        while(s!=f){
            if(k>=m)
                break;
            String toks[] = (br.readLine()).split(" ");
            k++;
            t = Integer.parseInt(toks[0]);
            l = Integer.parseInt(toks[1]);
            r = Integer.parseInt(toks[2]);
        while(t!=time_now && s!=f)
        {
            s=s+dx;
            if(dx==-1)
                System.out.print("L");
            else
                System.out.print("R");
            time_now++;
        }
        if((s!=f) && (!((s>=l && s<=r)||(  (s+dx)>=l && (s+dx)<=r))))
        {
            s=s+dx;
            if(dx==-1)
            System.out.print("L");
            else
                System.out.print("R");
            time_now++;
        }
        else if(s!=f){
                System.out.print("X");
            time_now++;
        }
        }
        while(s!=f)
        {
            s=s+dx;
            if(dx==-1)
                System.out.print("R");
        }
        System.out.println();
}
}
