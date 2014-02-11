import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/14/13
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm1882 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String s=br.readLine();
        int pos=-5,posm=0;    long c=0; int heavy;
        posm=s.indexOf("metal",0);
         long a=0;
        while(posm!=-1)
        {

        while(pos<posm)
        {
        heavy=s.indexOf("heavy",pos+5);

            if(heavy==-1 || heavy>posm)
                    break;
        pos=heavy;
            c++;
        }
            posm=s.indexOf("metal",posm+5);
            if(posm!=-1)
                a+=c;
        }
        System.out.println(c+a);
}
}
