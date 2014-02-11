import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/14/13
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm1881 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);

        String tok[]=(br.readLine()).split(" ");
        long num=Long.parseLong(tok[0]);
        long k=Long.parseLong(tok[1]);
        if(k<=(num+1)/2)
        {
            System.out.println(2*(k-1)+1);
        }
        else
        {
            System.out.println((k-(num+1)/2)*2);
        }
}
}
