import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 30/12/13
 * Time: 9:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class GoodBye3 {
    public static void main(String[] args) throws IOException {
        TreeMap<Long,Boolean> cache=new TreeMap<Long, Boolean>();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        String tokens[]=(br.readLine()).split(" ");
        long a[]=new long[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Long.parseLong(tokens[i]) ;
            if(cache.containsKey(a[i])==false){
                System.out.print(a[i]+ " ");
                cache.put(a[i],true);
            }
            else{
                a[i]++;
                while(cache.containsKey(a[i])){
                    a[i]++;
                }
                System.out.print(a[i]+ " ");
                cache.put(a[i],true);
            }
        }
        System.out.println();
}
}
