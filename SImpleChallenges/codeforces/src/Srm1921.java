import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/20/13
 * Time: 6:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm1921 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tokens[] = (br.readLine()).split(" ");
        int row = Integer.parseInt(tokens[0]);
        int col = Integer.parseInt(tokens[1]);
        int[][] a = new int[row][col];
                                     int flag=0;int c=0;
        for (int i = 0; i < row; i++) {

             flag=0;
            String m = (br.readLine());
            for (int j = 0; j < col; j++) {
                if ((m.charAt(j)) == '.') {
                    a[i][j] = 1;
                }
                else{
                    a[i][j]=2; flag=1;
                }
            }
            if(flag==0)
            {
                for (int k = 0; k < col; k++) {
                    if (a[i][k]==1) {
                        a[i][k] = 0;
                        c++;
                    }
                }
             }
        }
        flag=0;
        int ok=0;
        for(int i=0;i<col;i++)
        {
            ok=0;flag=0;
            for(int j=0;j<row;j++)
            {
                if(a[j][i]==1)
                    ok=1;
                if(a[j][i]==2)
                    flag=1;
            }
            if(ok==1 && flag!=1)
            {
               // System.out.println("here");
                for (int k = 0; k < row; k++) {
                    if (a[k][i]==1) {
                        a[k][i] = 0;
                        c++;
                    }
                }
            }
        }
        System.out.println(c);

}
}
