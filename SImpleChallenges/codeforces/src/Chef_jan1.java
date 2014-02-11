import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 3/1/14
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Chef_jan1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        String s;  int f;
        for(int i=0;i<n;i++)
        {
            f=0;
           s=br.readLine();
           int l=s.length();
           for(int j=0;j<=l-3;j++)
           {
              if(s.charAt(j)=='0' && s.charAt(j+1)=='1' && s.charAt(j+2)=='0')
              {
                  f=1;break;
              }
               else if(s.charAt(j)=='1' && s.charAt(j+1)=='0' && s.charAt(j+2)=='1')
              {
                  f=1;break;
              }
           }
            if(f==1)
                System.out.println("Good");
            else
                System.out.println("Bad");
        }
    }
}
