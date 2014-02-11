import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 1/10/13
 * Time: 8:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm203 {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tok[] = (br.readLine()).split(" ");

        int m,n;
        n = Integer.parseInt(tok[0]);
        m = Integer.parseInt(tok[1]);

        String toks[] = (br.readLine()).split(" ");
        int correct[]=new int[n];
        int max_correct=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
                correct[i]=Integer.parseInt(toks[i]);
            if(max_correct<correct[i])
                max_correct=correct[i];
        }

        int wrong[]=new int[m];
        int min_wrong=Integer.MAX_VALUE;
        String toks2[] = (br.readLine()).split(" ");
        for(int i=0;i<m;i++)
        {
            wrong[i]=Integer.parseInt(toks2[i]);
            if(wrong[i]<min_wrong)
                min_wrong=wrong[i];
        }
       // System.out.println("-1");
        int flag=0;
        for(int i=max_correct;i<min_wrong;i++)
        {
                flag=0;
            for(int j=0;j<n;j++)
            {
                if((2*correct[j])<=i) {
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            {
                System.out.println(i);
                break;
            }
        }
        if(flag==0)
        {
            System.out.println("-1");
        }
}
}
