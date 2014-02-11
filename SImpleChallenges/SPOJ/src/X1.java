import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/9/13
 * Time: 1:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class X1 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine());
        for(int j=0;j<cases;j++)
        {
        String tokens[]= (br.readLine()).split(" ");
        int n=Integer.parseInt(tokens[0]);
        int []a=new int[n];
        for(int i=0;i<n;i++)
        {
           a[i]=Integer.parseInt(tokens[i+1]);
        }
        Arrays.sort(a);int sum=0;int max=0;int min=a[n-1]+a[n-2];
            for(int i=0;i<n/2;i++)
            {
                sum=a[i]+a[n-i-1];
                if(sum>max)
                    max=sum;
                if(sum<min)
                    min=sum;
            }
        System.out.println(max-min);
        }
}
}
