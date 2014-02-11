import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Hashtable;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 12/1/14
 * Time: 9:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm223_B {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n = Integer.parseInt(br.readLine());
        String tokens[]=(br.readLine()).split(" ");
        int a[]=new int[n];
        int []freq=new int[5001];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(tokens[i]);
        }
       ArrayList<Integer> dec= new ArrayList<Integer>();
        ArrayList<Integer> last= new ArrayList<Integer>();
        Arrays.sort(a);
         int count1=0;int count2=0;
        for(int i=n-1;i>=0;i--){
              if(freq[(a[i])]==0){
                  freq[(a[i])]=1;
                  last.add(a[i]);
                  count1++;
              }

                else  if(freq[(a[i])]==1){
                      freq[(a[i])]=2 ;
                      dec.add(a[i]);
                      count2++;
                  }
        }
        int flag=0;
        if(count2>0 && count1>0 && dec.get(0).equals(last.get(0)))
        {
           flag=1;
            System.out.println(count1+count2-1);
        }
        else
        System.out.println(count1+count2);
        int c=0;
        for(int i=count2-1;i>=0;i--){
            System.out.print(dec.get(i)+" ");
          //  c++ ;
        }
        for(int i=0;i<count1;i++){
            if(!(i==0 && flag==1) )     {
                System.out.print(last.get(i)+" ");
           // c++   ;
            }
        }
        System.out.println();
    }
}
