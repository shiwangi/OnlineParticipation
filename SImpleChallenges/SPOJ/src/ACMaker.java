import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/18/13
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class ACMaker {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int insig = Integer.parseInt(br.readLine());
        String []words=new String[insig];
        for(int i=0;i<insig;i++)
        {
             words[i]=br.readLine();
        }
        String m="";
        while(!(m=br.readLine()).equals("LAST CASE"))
        {
            String tokens[]=(m).split(" ");
            int length=tokens[0].length();
            int sentence=tokens.length-1;
            int ans=1;
             for(int j=1;j<=sentence;j++)
             {
                 solve(words,tokens[j].substring(length - sentence - 1, length),0);
             }
             System.out.println(ans);
        }
    }

    static int solve(String[] words,String check, int max)
    {
        for(int i=0;i<words.length;i++)
        {

        }
        //if we take i letters from tokens num of ways would be :
        for(int i=1;i<check.length();i++)
        {

        }
         return 0;
} }
