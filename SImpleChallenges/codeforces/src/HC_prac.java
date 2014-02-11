import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 15/12/13
 * Time: 7:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class HC_prac {
    static int same_set(long c, ArrayList<Long> board1, ArrayList<Long> board2)
    {
        long h;
        for(int i=0;i<c;i++)
        {
           h=board1.get(i);
            if(board2.indexOf(h)>=c)
                return 0;
        }
        return 1;
    }
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String tokens[]=(br.readLine()).split(" ");
        int n=Integer.parseInt(tokens[0]);
        int m=Integer.parseInt(tokens[1]);
        String token[]=(br.readLine()).split(" ");
        long x1=Long.parseLong(token[0]);
        long a1=Long.parseLong(token[1]);
        long b1=Long.parseLong(token[2]);
        long c1=Long.parseLong(token[3]);
        long r1=Long.parseLong(token[4]);
        String token1[]=(br.readLine()).split(" ");
        long x2=Long.parseLong(token1[0]);
        long a2=Long.parseLong(token1[1]);
        long b2=Long.parseLong(token1[2]);
        long c2=Long.parseLong(token1[3]);
        long r2=Long.parseLong(token1[4]);
        ArrayList<Long> board1=new ArrayList<Long>();
        board1.add(x1);
        ArrayList<Long> board2=new ArrayList<Long>();long calc;
        board2.add(x2);
        long f1[]=new long[n];
        long f2[]=new long[m];
        int ans[][]=new int[n][m];
        long large=(m>n)?m:n;
        long last1,last2;
        for(int i=1;i<large;i++)
        {
             if(i<n)    {
             calc=(a1 * board1.get((i-1) % n) + b1 * board2.get((i-1) % m) + c1) % r1 ;
            if(board1.indexOf(calc)==-1)
            {
                board1.add(calc);
                f1[i]=f1[i-1]+1;
            }
            else
                f1[i]=f1[i-1];

             }
            if(i<m)
            {
                calc=(a2 * board1.get((i-1) % n) + b2 * board2.get((i-1) % m) + c2) % r2 ;
                if(board2.indexOf(calc)==-1)
                {
                    board2.add(calc);
                    f2[i]=f2[i-1]+1;
                }
                else
                    f2[i]=f2[i-1];
            }
        }

        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(ans[i][j-1]==1 && f2[j-1]==f2[j]) {
                ans[i][j] =1;
                count++;
                }
               else if(ans[i][j-1]==1 && f2[j-1]!=f2[j])
                    break;
                else{
                    if(f1[i]==f2[j])
                    {
                       if(same_set(f1[i],board1,board2)==1)
                        ans[i][j] =1;
                        else
                        ans[i][j] =0;
                    }
                    else
                        ans[i][j] =0;
                }
            }
        }
        System.out.println(count);

    }
}