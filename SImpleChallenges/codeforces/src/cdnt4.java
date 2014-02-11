import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 9/2/14
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class cdnt4 {
    static int req=0,res=0;


    static int solve(ArrayList<Integer> a,int p){
        if(p==req){
            return res;
        }
        else {
            int min=Integer.MAX_VALUE;
            for(int k=1;k<n;k++){
                if((arr[k]-arr[k-1])<min){
                    min=  (arr[k]-arr[k-1]);
                }
            }
        }
            res=Math.min()


    }
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++){

            String token[]=(br.readLine()).split(" ");
            int n=Integer.parseInt(token[0]);
            int kk=Integer.parseInt(token[1]);
            int arr[]=new int[n];
            String tokens[]=(br.readLine()).split(" ");
            for(int j=0;j<n;j++){
                  arr[j]=Integer.parseInt(tokens[j]);
            }
            Arrays.sort(arr);
            int cost=0;
            req=n-kk;
            for(int j=0;j<;j++){
                //fi min diff

                cost+=min;
            }
            System.out.println(cost);
        }
    }


}
