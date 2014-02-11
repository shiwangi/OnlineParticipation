import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/11/13
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);

        int n;
        while(((n=Integer.parseInt(br.readLine()))!=42)) {


            System.out.println(n);

        }
}

}