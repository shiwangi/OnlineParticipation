import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 30/12/13
 * Time: 9:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Goodbye2 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        String tokens[]=(br.readLine()).split(" ");
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(tokens[i]) ;
        }
        int stillleft=0;
        if(a[0]>0)
        {
            System.out.print("P");
            a[0]--;
            if(a[0]>0)
            {
                stillleft=1;
            }
        }
        do{
            stillleft=0;
            if(a[0]>0)
            {
                stillleft=1;
            }
        for(int i=1;i<n;i++)
        {
            System.out.print("R");
             if(a[i]>0)
             {
                 System.out.print("P");
                 a[i]--;
                 if(a[i]>0)
                 {
                     stillleft=1;
                 }
             }
        }
        if(stillleft==1)
        {

            stillleft=0;
            if(a[n-1]>0)
                stillleft=1;
            for(int j=n-2;j>=0;j--)
            {
                System.out.print("L");
                if(a[j]>0)
                {
                    System.out.print("P");
                    a[j]--;
                    if(a[j]>0)
                    {
                        stillleft=1;
                    }
                }
            }
        }
        }while(stillleft==1);
        System.out.println();
    }
}
