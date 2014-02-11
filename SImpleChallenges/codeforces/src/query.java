import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 5/30/13
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class query {

    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input); String s,d;
        s=br.readLine();
      int l,m;   char x;
        int cases = Integer.parseInt(br.readLine()); int soln[]=new int[s.length()]; int count=0;int i;
        for( i=0;i<s.length()-1;i++)
        {
            soln[i]=count;
                   if(s.charAt(i)==s.charAt(i+1))
                       count++;

               }
            soln[i]=count;

                     int res;
        for (int k = 0; k < cases; ++k) {
            d=br.readLine();
            String token[]=d.split(" ");
            l= Integer.parseInt(token[0]);
            m= Integer.parseInt(token[1]);
            res=soln[m-1]-soln[l-1];
            System.out.println(res);
        }
    }

}
