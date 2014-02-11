import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/20/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm1922 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tokens[] = (br.readLine()).split(" ");
        int cities = Integer.parseInt(tokens[0]);
        int not_poss = Integer.parseInt(tokens[1]);
        System.out.println((cities-1));
        int a[]=new int [cities+1];
        for(int i=0;i<not_poss;i++)
        {
            String token[] = (br.readLine()).split(" ");
            a[Integer.parseInt(token[0])]=1;
            a[Integer.parseInt(token[1])]=1;

        } int x=0;
        for(int i=1;i<=cities;i++) {
            if(a[i]==0){
                x=i;
                break;
            }
        }
        for(int i=1;i<=cities;i++) {
            if(i!=x)
            {
                System.out.println(x +" "+ i);
            }
        }

}
}
