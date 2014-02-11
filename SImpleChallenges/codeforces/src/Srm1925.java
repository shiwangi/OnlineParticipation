import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/20/13
 * Time: 8:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm1925 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String []token = (br.readLine()).split(" ");
        int nodes = Integer.parseInt(token[0]);
        int edges = Integer.parseInt(token[1]);
        int[][] a = new int[nodes+1][nodes+1];
        for (int i = 0; i < edges; i++) {
            String []tokens = (br.readLine()).split(" ");
            a[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[1])] =1;
            a[Integer.parseInt(tokens[1])][Integer.parseInt(tokens[0])] =1;
        }
        int []c=new int[nodes+1];int count=0;
        int s[][]=new int[nodes+1][nodes+1]; int flag=0;
       outer: for(int i=1;i<=nodes;i++)
        {
            for(int j=1;j<=nodes;j++)
            {
                if(c[i]==2 ){
                    continue outer;
                }
                else if(c[j]==2)
                    continue ;
                if(a[i][j]==0 && i!=j && s[j][i]!=1){
                   s[i][j]=1;
                    System.out.println(i+ " "+j);
                    count++;
                    c[i]++;c[j]++;
                }
                if(count==edges)
                {
                    flag=1;
                    break  outer;
                }

            }
        }
        count=0;
        if(flag==0)
            System.out.println("-1");

        else{
            outr: for(int i=1;i<=nodes;i++)
            {
                for(int j=1;j<=nodes;j++)
                {
                    if(s[i][j]==1) {
                        System.out.println(i+" "+j);
                        count++;
                    }
                    if(count==edges)
                        break outr;
                }
        }
    }
}
}
