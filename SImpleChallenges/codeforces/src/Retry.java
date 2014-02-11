import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 8/22/13
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Retry {
    static int gcd(int a,int b){
        {
            if (b==0) return a;
            return gcd(b,a%b);
        }
    }
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tok[] = (br.readLine()).split(" ");
        int a = Integer.parseInt(tok[0]);
        int b= Integer.parseInt(tok[1]);
        int c = Integer.parseInt(tok[2]);
        int d=Integer.parseInt(tok[3]) ;
             int t1,t2;
        if(c>a || d>b)
        {
            if((float)c/(float)a>(float)d/(float)b)
            {
                t1=a;t2=c;a=a*t2;b=b*t2;c=c*t1;d=d*t1;
            }
            else
            {
                t1=b;t2=d;a=a*t2;b=b*t2;c=c*t1;d=d*t1;
            }
        }
        else
        {
            if((float)a/(float)c>(float)b/(float)d)
            {
                t1=b;t2=d;a=a*t2;b=b*t2;c=c*t1;d=d*t1;
            }
            else{
                t1=a;t2=c;a=a*t2;b=b*t2;c=c*t1;d=d*t1;
            }
        }
       // System.out.println(a+" " +b+" "+c+" "+d);
         int num=a*b-c*d;
        int deno=a*b;
        int f=gcd(num,deno);
      //  if(num==0)
           // System.out.println("0");
        //else
        System.out.println(num/f+"/"+deno/f);
        }
}
