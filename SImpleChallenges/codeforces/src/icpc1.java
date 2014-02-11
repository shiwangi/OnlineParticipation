import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 2/11/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class icpc1 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine()); int flag=0;
        for(int i=0;i<cases;i++)
        {
            String tokens[]=(br.readLine()).split(" ");

        int n=Integer.parseInt(tokens[0]);
           String k=tokens[1];

        String s="" ;
            int ans[]=new int[n+1];
            ans[0]=0;  int len,l=0;
        for(int j=1;j<=n;j++)
        {
            String x=String.valueOf(j);
            s=s+x;
            int add_l= x.length();
            int m=k.length();
            len=add_l+l;


            l=len;
            flag=0; int c=0;
                   int id=0; int hh=0;
            if(add_l>m )
            {
                while(hh<add_l-1){
              id= x.indexOf(k,hh);
                if(id!=-1)
                {
                    hh=id+1; c++;
                }
                else
                    break;
                }
            }

            while(m>0)
            {
                if(len-1<0)
                {
                    flag=1;
                    break;
                }
                   if(s.charAt(len-1)!=k.charAt(m-1))
                   {
                       flag=1;
                       break;
                   }
                m--;len--;
            }
            if(flag==1)
                ans[j]=ans[j-1]+c;
            else
                ans[j]=ans[j-1]+1+c;
        }

System.out.println(ans[n]);


        }
    }
}
