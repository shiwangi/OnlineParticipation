import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 12/1/14
 * Time: 8:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm223_A {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n = Integer.parseInt(br.readLine());
        String tokens[]=(br.readLine()).split(" ");
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
             a[i]=Integer.parseInt(tokens[i]);
        }
        int i=0;int j=n-1;
        int sum1=0,sum2=0;
        boolean turn=true;
        while(i<=j)  {
            if(turn){
                if(a[i]>a[j]){
                    sum1+=a[i];
                    i++;
                }
                else {
                    sum1+=a[j];
                    j--;
                }
                turn=!turn;
            }
            else{
                if(a[i]>a[j]){
                    sum2+=a[i];
                    i++;
                }
                else {
                    sum2+=a[j];
                    j--;
                }
                turn=!turn;
            }
        }

        System.out.println(sum1+" "+sum2);
        }

    }
