import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/24/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Fb_byteland {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String token[]= (br.readLine()).split(" ");
        int n=Integer.parseInt(token[0]);
        int m=Integer.parseInt(token[1]);
        int []cost=new int[n+1];
        String []army=new String[n+1];
        for(int i=1;i<=n;i++)
        {
            String tokens[]= (br.readLine()).split(" ");
            army[i]= tokens[0];
            cost[i]=Integer.parseInt(tokens[1]);
           // System.out.println(army[i]);
        }
        int [][]path=new int[n+1][n+1];  int x,y;
        for(int i=1;i<=m;i++)
        {
            String tokens[]= (br.readLine()).split(" ");
            x=Integer.parseInt(tokens[0]);
            y=Integer.parseInt(tokens[1]);
            if(army[x].equals(army[y])==false)
            {
            path[x][y]=1; path[y][x]=1;
            }
        }
        int cost_tot=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                if((path[i][j]==1))
                {
                    cost_tot+=cost[j];
                     for(int k=1;k<=n;k++)
                     {    path[j][k]=0; path[k][j]=0;}
                }
            }
        }

              System.out.println(cost_tot);

    }
}
