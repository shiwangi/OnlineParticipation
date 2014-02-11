import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 5/30/13
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class max
{
    int solve(int[][]m,int i,int j,int k,int l)
    {
        if(i==k && j==l)
            return m[i][j];
        else
        return max(m,i,j,k,l)+solve(m,i,j+1,k-1,l)+solve(m,i+1,j,k,l-1)+solve(m,i,j,l-1,k-1)+solve(m,i+1,j+1,k,l);
    }
    public  int max(int [][]m,int a ,int b,int c,int d)
    {
        int max=0;
           for(int i=a;i<=c;i++)
           {
               for(int j=b;j<=d;j++)
               {
                   if(m[i][j]>max)
                       max=m[i][j];
               }
           }

        return max;
    }
    public static void main(String[] args) throws IOException {
        max ss = new max();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input); String d;

        int cases = Integer.parseInt(br.readLine());int size=(int)Math.sqrt(cases);
        int [][]m=new int[size][size];
        d=br.readLine();    int c=0;
        String token[]=d.split(" ");
      //  System.out.println(token[3]);
        for (int i = 0; i <size; i++) {
            for (int j = 0; j <size; j++){
            m[i][j]= Integer.parseInt(token[c]);c++;
                //System.out.println(m[i][j]);
            } }
            int res = ss.solve(m,0,0,size-1,size-1);
            System.out.println( res);

    }
}
