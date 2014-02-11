import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 13/12/13
 * Time: 7:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class S1 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(input);
       // int cases=Integer.parseInt(br.readLine());
        int flag=0;
        int []count=new int[10];
        int k=0;
            int max=Integer.parseInt(br.readLine());max=max*2;
            for(int l=0;l<4;l++){
            String m=(br.readLine());

            for(int j=0;j<4;j++)
            {
               if(m.charAt(j)!='.')
               {

                     k=Integer.parseInt(Character.toString(m.charAt(j)));
                   count[k]++;
                   if(count[k]>max)
                   {
                       flag=1;
                   }
               }
            }
            }
            if(flag==0)
            {
                System.out.println("YES");
            }
            else
                System.out.println("NO");



    }
}