import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 24/11/13
 * Time: 10:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class HC_1 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        for (int i = 0; i < cases; i++) {
            int n = Integer.parseInt(br.readLine());
            int start = 0;
            char b[][]=new char[n][n];
            int flag=0;
            int j=0;
            int last=0;
            for(int l=0;l<n;l++)
            {
                String s = br.readLine();
                if(flag==0){
                start=s.indexOf('#');
                if(start!=-1) {
                    last=s.lastIndexOf('#');
                   flag=1; j=l;
                }
                }
                for(int m=0;m<n;m++)
                {
                    b[l][m]=s.charAt(m) ;
                }

            }

               char a[][]=new char[n][n];
                int count=last-start;flag=0;
                for(int l=0;l<n;l++)
                {
                    for(int m=0;m<n;m++)
                    {
                        if(l>=j && m>=start && m<=last && l<=j+count)
                            a[l][m]='#';
                        else
                        a[l][m]='.';
                        if(a[l][m]!=b[l][m])
                        {
                            flag=1;
                            break;
                    }
                }

                }
            if(flag==1)
                System.out.println("CASE #"+(i+1)+": NO");
            else
                System.out.println("CASE #"+(i+1)+": YES" );
        }


    }
}
