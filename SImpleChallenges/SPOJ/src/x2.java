import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/9/13
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class x2 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
            String tokens[]= (br.readLine()).split(" ");

            int []p=new int[n];
            for(int i=0;i<n-1;i++)
            {
                p[i]=Integer.parseInt(tokens[i]);
            }
            int m=Integer.parseInt(br.readLine());
        String token[]= (br.readLine()).split(" ");
            int []a=new int[m];
            for(int i=0;i<m;i++)
            {
                a[i]=Integer.parseInt(token[i]);

            }
    int j;
         int flag;

       do{

            flag=0;
            j=0;
            while(j<m)
            {
              a[j]=p[a[j]-1]+1;
                j++;

            }
        for(int i=0;i<m-1;i++)
        {
            if(a[i]!=a[i+1])
            {
                flag=1;
                i=0;
                break;
            }

        }

        }while(flag==1);
        System.out.println(a[0]-1);

}
}
