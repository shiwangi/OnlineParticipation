import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 18/1/14
 * Time: 5:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Overnite2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n = Integer.parseInt(br.readLine());
        String tokens[]=(br.readLine()).split(" ");
        int a[]=new int[n];
        int []freq=new int[5001];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(tokens[i]);
        }
    }
}
