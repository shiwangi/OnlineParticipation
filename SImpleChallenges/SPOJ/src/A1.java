import sun.misc.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 23/10/13
 * Time: 8:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class A1 {
    static int check(char A[][], int m, int n, int k, int l, int x, int y) {
        int flag = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (A[m + i][n + j] != A[k + i][l + j]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) break;
        }
        if (flag == 0)
            return 1;
        else return 0;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());

        for (int i = 0; i < cases; i++) {
            String token[] = (br.readLine()).split(" ");
            int m = Integer.parseInt(token[0]);
            int n = Integer.parseInt(token[1]);
            char a[][] = new char[m][n];
            for (int j = 0; j < m; j++) {
                String str = br.readLine();
                for (int k = 0; k < n; k++) {
                    a[j][k] = str.charAt(k);
                }
            }
            int trim_col = 0;
            int trim_row = 0;
            int max=Integer.MIN_VALUE;
            outer:
            while (trim_row < m) {
                while (trim_col < n ) {
                    int edit_row = 0;
                    int edit_col = 1;
                    while (edit_row < m-trim_row) {
                        while (edit_col < n-trim_col) {
                            int x = 0;
                            int y = 0;
                            while (x <=edit_row) {
                                while (y <= edit_col) {
                                    if(x==0 && y==0 )
                                        y=1;

                                    if (check(a,  trim_row, trim_col,  x, y, m - trim_row - edit_row, n - trim_col - edit_col) == 1) {

                                        if(max<(( m-trim_row - edit_row) * (n-trim_col - edit_col)))
                                            max=(( m-trim_row - edit_row) * (n-trim_col - edit_col));

                                    }
                                    y++;
                                }
                                x++;
                                y = 0;
                            }
                            edit_col++;
                        }
                        edit_row++;
                        edit_col = 0;
                    }
                    trim_col++;
                }
                trim_row++;
                trim_col = 0;
            }
          System.out.println(max);
        }

    }
}


