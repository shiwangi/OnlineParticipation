import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 19/1/14
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class Sol4 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int sum[]=new int[100001];
        int n=Integer.parseInt(br.readLine());
        int a[]=new int[n];
        for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);
       for(int i=0;i<n;i++){

           for(int j=i;j<n;j++){
              if(sum[Math.abs(a[i]-a[j])] !=1)
                  sum[Math.abs(a[i]-a[j])]=0;
           }

       }
            }

        }
