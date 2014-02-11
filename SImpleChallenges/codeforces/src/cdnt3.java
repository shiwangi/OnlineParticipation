import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 9/2/14
 * Time: 10:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class cdnt3 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++){


            int nodes=Integer.parseInt(br.readLine());
            int node[]=new int[nodes];
            int val[]=new int[nodes];
            for(int j=0;j<nodes;j++) {
                String tokens[]=(br.readLine()).split(" ");
                node[j]=Integer.parseInt(tokens[0]);

                val[j]=Integer.parseInt(tokens[1]);


            }
            for(int j=0;j<nodes;j++){
                int pro=1;


                for(int k=0;k<nodes;k++){
                    if(node[k]!=node[j]){
                        pro=(pro*node[k])%1000000007;
                    }
                }
                if(pro==val[j])  {
                    System.out.println(node[j]);
                    break;
                }
            }
        }

}
}
