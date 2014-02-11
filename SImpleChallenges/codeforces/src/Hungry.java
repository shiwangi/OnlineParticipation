import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/4/13
 * Time: 6:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hungry {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String s=br.readLine();
        int a[]=new int[10000001];

        int n=Integer.parseInt(s);int i;
        int c=0;

           for(i=2;i<=10000000;i++)
           {
               if(a[i]==0 && c<n){
              for(int j=i*2;j<=10000000;j+=i)
                  a[j]=1;
                System.out.print(i+" ");c++;
               }
           }


}
    }
