import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/8/13
 * Time: 4:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class Abcdef {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        int[] arr=new int[n];
        int count=0;
       for(int i=0;i<n;i++)
       {
          arr[i]=Integer.parseInt(br.readLine());
       }

        int []ans=new int[n*n*n];
        int []ans2=new int[n*n*n];

        int i=0;
        for(int a=0;a<n;a++)
        {
            for(int b=a;b<n;b++)
            {
                for(int c=0;c<n;c++)
                {

                                ans[i]=((arr[a]*arr[b])+arr[c]);

                                ans2[i]=(arr[c]*(arr[a]+arr[b]));
                                i++;
                                   if(a!=b)
                                   {
                                       ans[i]=ans[i-1];
                                       ans2[i]=ans2[i-1];
                                       i++;
                                   }

                }
            }
        }


        int k=0;int r=1,s=1;
        Arrays.sort(ans);
        Arrays.sort(ans2);
        outer: for(int l=0;l<i;l++)
        {

                while(l!=i-1 && ans[l]==ans[l+1]){ r++; l++;}

            inner: for(int m=k;m<i;m++)
            {

                if(ans[l]<ans2[m])
                {
                    r=1;s=1;continue outer;
                }
                if(ans[l]==ans2[(m)]){

                    while(m!=i-1 && ans2[m]==ans2[m+1]){
                        s++; m++;
                    }

                     //System.out.println(ans[l]+" " +r +" "+s);
                    count+=r*s;
                     k=m+1; r=1;s=1;
                     continue outer;
                 }
                else
                {
                    while(m!=i-1 && ans2[m]==ans2[m+1]){
                         m++;
                    }continue inner;
                }

            }
        }

        System.out.println(count);

}
}
