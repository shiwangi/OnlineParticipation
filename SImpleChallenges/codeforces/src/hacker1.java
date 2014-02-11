import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 8/12/13
 * Time: 8:32 AM
 * To change this template use File | Settings | File Templates.
 */
public class hacker1 {
    static int c=0;
     String swap(String labels, int c  ) {
         if(c<labels.length()-1)
            return labels.charAt(c)+labels.substring(1,c)+labels.charAt(0) +labels.substring(c+1);
         else
             return labels.charAt(c)+labels.substring(1,c)+labels.charAt(0) ;

     }
     String solve(long fac[], String labels, long boxes,int l){
        if(boxes>fac[l-1])
        {
               return solve(fac,swap(labels,++c),boxes-fac[l-1],l);// ...50! ways..
        }
        else
            return labels.charAt(0)+ solve(fac,labels.substring(1,l),boxes-fac[l-1],--l);
    }
    public static void main(String[] args) throws IOException {
        long fac[]=new long[51];
        fac[0]=1;
        for(int i=1;i<=25;i++)
        {
            fac[i]=fac[i-1]*i;
           System.out.println(fac[i]);
        }
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        hacker1 h=new hacker1();
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            String tokens[]=(br.readLine()).split(" ");
            String labels=(tokens[0]);
           int l=labels.length();
            long boxes=Long.parseLong(tokens[1]);
            String ans="";
            if(fac[l]>boxes)
                ans=h.solve(fac,labels,boxes,l);
            System.out.println(ans);
            }



        }
}
