import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 30/12/13
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Goodbye1 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String tokens[]=(br.readLine()).split(" ");
        int n=Integer.parseInt(tokens[0]);
        int m=Integer.parseInt(tokens[1]);
        int count=0;
        while(n!=0)
        {
            count++;
            n--;
            if(count%m==0)
            {
                n++;
            }
        }
        System.out.println(count);
    }
}
