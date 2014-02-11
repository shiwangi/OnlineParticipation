import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 8/22/13
 * Time: 11:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Longest {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        String tok[] = (br.readLine()).split(" ");
        int []a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(tok[i]);
        }
        int max=1;int key=0;
        int []ans=new int[n]; ans[0]=1;int flag;
        for(int i=1;i<n;i++)
        {
            if(a[i]>a[key])
            {
                max++;
                key=i;
                ans[i]=max;
            }

            else{
                flag=0;
                for(int j=i-1;j>=0;j--)
                {
                    if(a[i]>a[j])
                    {
                        ans[i]=ans[j]+1;
                        if(max<ans[i])
                        {
                             key=i;
                            max=ans[i];

                        }
                        flag=1;
                        break;
                    }
                }
            if(flag==0)
            {
                ans[i]=1;
            }
            }
        }
        System.out.println(max);


    }
}
