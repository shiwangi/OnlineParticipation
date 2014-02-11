import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/14/13
 * Time: 9:32 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm1883 {

        public static void main(String[] args) throws IOException {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(input);

            String tok[]=(br.readLine()).split(" ");
            long x=Long.parseLong(tok[0]);
            long y=Long.parseLong(tok[1]);
            long k=Long.parseLong(tok[2]);

            long count=0;int flag=0;

            if(Math.max(x,y)>=k) flag=1;
            else if(x<=0 && y<=0 ) flag=2;

            if(flag==0){
                if ( x< y && x<0) {
                    long absA = -x;
                    count+= absA/y;
                    x = -(absA % y);
                }
                if ( y< x && y<0) {
                    long absA = -y;
                    count+= absA/x;
                    y= -(absA % x);
                }

                    while(x+y<k)
                    {
                        if(x<y)
                            x=x+y;
                        else
                            y=x+y;
                        count++;
                    }


               }

            if(flag==1)
                System.out.println(0);
            else  if(flag==2)
                System.out.println(-1);
            else
                System.out.println(++count);
        }
    }