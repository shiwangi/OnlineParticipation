import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 5/30/13
 * Time: 8:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class x {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
       // String m="";
        int num = Integer.parseInt(br.readLine());
        if(num>0)
            System.out.println(num);
        else
        {
            if(((-num) %10)> (-num/10 )%10)
                System.out.println(num/10);
            else{
                System.out.println((num/100)* 10 +num%10);
            }
        }

    }

}
