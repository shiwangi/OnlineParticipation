import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/14/13
 * Time: 10:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ants {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);

        String tok[]=(br.readLine()).split(" ");
        long n=Long.parseLong(tok[0]);
        long q=Long.parseLong(tok[1]);
        while(n>4)
        {
        long x=n/4;

        }

        for(int i=0;i<q;i++)
        {
            String toks[]=(br.readLine()).split(" ");
            long a=Long.parseLong(toks[0]);
            long b=Long.parseLong(toks[1]);
            System.out.println();
        }
}
}
