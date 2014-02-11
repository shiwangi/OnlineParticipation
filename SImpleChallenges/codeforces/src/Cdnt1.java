import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 9/2/14
 * Time: 9:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Cdnt1 {
    static int gcd(int m,int n){
        if(n==0)
            return m;
        else
            return gcd(n,m%n);
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine());
        int m,n;
        for(int i=0;i<cases;i++){
            String tokens[]=(br.readLine()).split(" ");
            m=Integer.parseInt(tokens[0]);

            n=Integer.parseInt(tokens[1]);
            System.out.println(gcd(m,n));
        }

    }

}
