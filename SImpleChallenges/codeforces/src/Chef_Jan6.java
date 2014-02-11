import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 9/1/14
 * Time: 10:50 AM
 * To change this template use File | Settings | File Templates.
 */
public class Chef_Jan6 {
    public static void main(String[] args) throws IOException {

        class States{
        int right;int down;
        States(int r,int d){
        right=r;
        down=d;
        }
        }

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        int n,m,k;
        int row,col;
        for (int i = 0; i < cases; i++) {
            String tokens[] = (br.readLine()).split(" ");
            n=Integer.parseInt(tokens[0]) ;
            m=Integer.parseInt(tokens[1]) ;
            k=Integer.parseInt(tokens[2]) ;
            boolean a[][] = new boolean[n][m];
            States st[][]=new States[n][m] ;
            for (int j = 0; j < k; j++) {
                String token[] = (br.readLine()).split(" ");
                row=Integer.parseInt(token[0]) ;
                col=Integer.parseInt(token[1]) ;
                a[row][col]=true;
            }
            for(int j=0;j<n;j++){
                for(int p=m-1;p>=0;p--) {
                      if(a[j][p]==false) {
                          if(p==m-1)
                              st[j][p].right=1;
                          else
                              st[j][p].right=st[j][p+1].right++;
                      }
                    else
                          st[j][p].right=0;
                }
            }
        for(int p=0;p<m;p++)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(a[j][p]==false)
                {
                    if(j==n-1)
                    {
                        st[j][p].down=1;
                    }
                    else
                        st[j][p].down=st[j+1][p].down++;
                }
                else{
                    st[j][p].down=0;
                }
            }
        }
            for(int p=0;p<m;p++)
            {
                for(int j=n-1;j>=0;j--)
                {

                }
            }
        }
    }
}

