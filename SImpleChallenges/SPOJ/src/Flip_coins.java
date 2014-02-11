import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 9/2/13
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Flip_coins {

    Map<Integer,Integer> cache;
    int update(int a,int b)
    {
        return 0;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tokens[]=(br.readLine()).split(" ");
        Flip_coins flip=new Flip_coins();
        int n= Integer.parseInt(tokens[0]);
        int q= Integer.parseInt(tokens[1]);
        int a,b,c;
        for(int i=0;i<q;i++)
        {
            String token[]=(br.readLine()).split(" ");
            a= Integer.parseInt(token[0]);
            b= Integer.parseInt(token[1]);
            c= Integer.parseInt(token[2]);
            if(a==0)
                flip.update(b, c);
        }

    }
}
