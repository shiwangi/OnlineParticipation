import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/7/13
 * Time: 9:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rating {
    public static void main(String[] args) throws IOException {
        int afas=0;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String tokens[]=(br.readLine()).split(" ");
        int n=Integer.parseInt(tokens[0]);
        int k=Integer.parseInt(tokens[1]);
         int flag;
        String token[]=(br.readLine()).split(" ");
        int [] a=new int[n];

        for(int i=0;i<n;i++)
        {
            a[i]=(Integer.parseInt(token[i]));
        }
        do{
        int [] d=new int[n];


        for(int i=0;i<n;i++)
        {
            if(a[i]==-1) {

                continue;}
            for(int j=0;j<i;j++)  {
                if(a[j]==-1)
                    continue;
                d[i]+=(a[(j)]*(j)-(n-(i+1))*a[(i)]) ; }//System.out.print(d[i]+ " ");
        }
        flag=0;
        for(int i=0;i<n;i++)
        {
            afas=1;
            if(a[i]==-1)
                continue;
            if(d[i]<k)
            {

                a[(i)]=-1;

                System.out.println((i+1));

                flag=1;break;
            }
        }
    } while(flag==1);
        if(afas==0)
            System.out.println((0));
    }
}