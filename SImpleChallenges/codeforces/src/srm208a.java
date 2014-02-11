import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 25/10/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm208a {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        int a[]=new int[n];

        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(br.readLine());
        }
        int flag=0;

        for(int j=0;j<n-1;j+=1)
        {
            for(int i=0;i<j;i+=1)
            {

            if((a[j]<a[i+1] && a[j]>a[i] && a[j+1] >a[i+1])|| (a[j+1]<a[i+1] && a[j+1]>a[i] && a[j] >a[i+1]))
            {
                flag=1;
                break;
            }
            }
        }

       if( flag==1)
            System.out.println("yes");
        else
                    System.out.println("no");

    }
}
