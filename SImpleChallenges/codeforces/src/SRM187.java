import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/7/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SRM187 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);

        int cases = Integer.parseInt(br.readLine());
        int [] a=new int[cases];
        int []b=new int[cases];
         int c=0;
        for(int i=0;i<cases;i++)
        {
            String tokens[]=(br.readLine()).split(" ");
            a[i]=Integer.parseInt(tokens[0]);
            b[i]=Integer.parseInt(tokens[1]);
        }
        for(int i=0;i<cases;i++)
        {
            int flag=0;
            for(int j=0;j<cases;j++)
            {
                if(b[j]==a[i] &&j!=i)
                    flag=1;
            }
            if(flag==0)
                c++;
        }
        System.out.println(c);

}
}
