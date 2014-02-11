import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/17/13
 * Time: 2:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class ss {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);

        String tok=(br.readLine());
         char c[]= tok.toCharArray();char tmp;
        System.out.println(c);


               int i=0;
               for(int j=tok.length()-1;j>=0;j--)
               {

               if(i<j){
                   tmp = c[i];

                     c[i]=c[j];
                   c[j]=tmp;
               }i++;

        }
        System.out.println(c);
        int k=0;
        for(i=0;i<tok.length();i++)
        {
            if(c[i]==' ' || i==tok.length()-1)
            {
                if(i==tok.length()-1) ++i;
               int j=k;
                    for(int l=i-1;l>=0;l--)
                    {

                        if(j<l){
                            tmp = c[j];

                            c[j]=c[l];
                            c[l]=tmp;
                        }
                        j++;
                    }
                k=i+1;
            }

        }
        System.out.println(c);
}
}
