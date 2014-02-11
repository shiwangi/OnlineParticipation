import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/6/13
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Acs {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int col[]=new int[5678];
        int row[]=new int[1234];
        for(int i=0;i<1234;i++)
        {
            row[i]=i;

        }
        for(int j=0;j<5678;j++)
        {
            col[j]=j;
        }
         String m;
        while((m=br.readLine())!=null){

        String[] s=(m).split(" ");
        char[] cc= s[0].toCharArray();  int x,y,temp;

        switch(cc[0])
        {
            case 'R':
                x=Integer.parseInt(s[1]);
                 y=Integer.parseInt(s[2]);
                //System.out.println(x+" "+y);
                x--;y--;
                temp=row[x];
                row[x]=row[y];row[y]=temp;
                  break ;
            case 'C':
                 x=Integer.parseInt(s[1]);
                 y=Integer.parseInt(s[2]);
                x--;y--; temp=col[x];
                col[x]=col[y];col[y]=temp;
                break ;
            case 'Q': x=Integer.parseInt(s[1]);
                y=Integer.parseInt(s[2]);
                x--;y--;
                    System.out.println(((row[x])*5678 +1)+(col[y]));

                break;
            case 'W': x=Integer.parseInt(s[1]); x--;
                        int r=x/5678;
                        int c=x%5678;
                for(int i=0;i<1234;i++)
                {
                    if(row[i]==r)
                        System.out.print(i+1+" ");
                }
                for(int i=0;i<5678;i++)
                {
                    if(col[i]==c)
                        System.out.println(i+1);
                }
                   break;
        }
}
    }
}
