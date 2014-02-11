import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 19/1/14
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class SOl2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine());
        int ans[]=new int [100001];
        int c=10;
        int count=0;
        int digit=1;
        ans[0]=0;
        count++;
        int a=10;
        for(int i=1;i<=100000;i++){

            if(count==c){
                if(digit==1)
                    c=90;
                else
                    c=c*10;
                count=0;digit++;
              //  System.out.println("here"+i)  ;
                a=a*10;
            }
            count++;
            ans[i]=(digit*i)+ans[i-1];
        }

       outer: for(int i=0;i<cases;i++){
            int n=Integer.parseInt(br.readLine());
           //System.out.println(ans[998]+" "+ ans[999]);
            for(int j=0;j<100000;j++){
                if(ans[j]>=n){
                    System.out.println(j);
                    continue outer;
                }
            }
        }  }
}
