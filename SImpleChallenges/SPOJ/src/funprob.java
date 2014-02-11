import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/9/13
 * Time: 12:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class funprob {
    public static double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.#####");
        return Double.valueOf(twoDForm.format(d));
    }
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(5);

        if(m<n)
            System.out.println(roundTwoDecimals(0));
        else if(m==n) {
            System.out.println ( "here"+roundTwoDecimals((double) m / (double) Math.pow(2, m + n)));
        }
}  }
