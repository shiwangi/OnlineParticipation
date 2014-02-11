import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 19/1/14
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++){
            String tokens[]=(br.readLine()).split(" ");

            int h=Integer.parseInt(tokens[0]);
            int girls[]=new int[h];
            int k=Integer.parseInt(tokens[1]);
            int boys[]=new int[h];
            String tok1[]=(br.readLine()).split(" ");
            String tok2[]=(br.readLine()).split(" ");
            for(int j=0;j<h;j++){
                  girls[j]=Integer.parseInt((tok1[j]));
                boys[j]=Integer.parseInt((tok2[j]));
            }


            Arrays.sort(girls);
            Arrays.sort(boys);
            int cost=0;
            for(int j=0;j<h;j++){
                 cost+= boys[h-1-j]*girls[j];
            }
            if(cost<=k)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

}
