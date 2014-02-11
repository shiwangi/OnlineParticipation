import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 12/1/14
 * Time: 10:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm223_C {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n = Integer.parseInt(br.readLine());
        int choice;
        int num;

        TreeMap<Integer,Integer> tree=new TreeMap<Integer, Integer>();
        int idx=0;
        int l,times;
        for(int i=0;i<n;i++){
            String tokens[]=(br.readLine()).split(" ");
             choice=Integer.parseInt(tokens[0]);
            if(choice==1){
               num=Integer.parseInt(tokens[1]);
               tree.put(idx,num);
                idx++;
            }
            else{
                l=Integer.parseInt(tokens[1]);
                times=Integer.parseInt(tokens[2]);
                tree.put(idx,8);
                idx++;
            }
        }


    }
}
