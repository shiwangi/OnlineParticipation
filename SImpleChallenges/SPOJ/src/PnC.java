import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/6/13
 * Time: 12:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class PnC {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
       outer: while(true){
        String s=br.readLine();
         if(s.equals("0"))
             break;
        char []c=s.toCharArray();
        int len=c.length; long single=1;long dbl=0;long temp;

        for(int i=1;i<len;i++)
        {
          if((c[i-1]=='1' && c[i]!=48)|| (c[i-1]=='2' && c[i]>48 && c[i]<=54))
          {
              temp=dbl;
              dbl=single;
              single+=temp;
          }
          else if((c[i-1]=='1' || c[i-1]=='2') && c[i]==48)
          {
              dbl=single;
              single=0;
          }
          else if(c[i]==48)
          {
              System.out.println(0);
              continue outer;
          }
            else{
              single+=dbl;
              dbl=0;
          }
        }
        System.out.println(single+dbl);
        }
}
}