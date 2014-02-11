import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 12/1/14
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Chef_Jan7 {
    static class Elements implements Comparable<Elements>{
        int index;
        int val;
        Elements(int i,int v){
            index=i;
            val=v;
        }

        @Override
        public int compareTo(Elements o) {
            return val-o.val;
        }
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n = Integer.parseInt(br.readLine());
        Elements arr[]=new Elements[n];
        int x, y;
        String tokens[] = (br.readLine()).split(" ");
        for (int i = 0; i <n; i++) {
               arr[i]=new Elements(i,Integer.parseInt(tokens[i]));
        }
        Arrays.sort(arr);




        }
}
