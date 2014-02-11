import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/20/13
 * Time: 7:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm1923 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String token = (br.readLine());
        int row = Integer.parseInt(token);
        int col = row;
        int[][] a = new int[row][col];
        int ok = 0;
        int row_terror = 0, col_terror = 0;
        for (int i = 0; i < row; i++) {
            String m = (br.readLine());
            ok = 0;
            for (int j = 0; j < col; j++) {
                if ((m.charAt(j)) == '.') {
                    a[i][j] = 0;
                    ok = 1;
                } else {
                    a[i][j] = 2;
                }
            }
            if (ok != 1)
                row_terror = 1;
        }
        for (int i = 0; i < col; i++) {
            ok = 0;
            for (int j = 0; j < row; j++) {
                if (a[j][i] == 0) {
                    ok = 1;
                }
            }
            if (ok != 1)
                col_terror = 1;
        }
        if (row_terror == 1 && col_terror == 1)
            System.out.println("-1");
        else {
            if (row_terror == 1) {
                outer:
                for (int i = 0; i < col; i++) {

                    for (int j = 0; j < row; j++) {
                        if (a[j][i] == 0) {
                            System.out.println((j + 1) + " " + (i + 1));
                           // System.out.println("here");
                            continue outer;
                        }
                    }
                }
            }
            else if (col_terror == 1) {
                outer:
                for (int i = 0; i < row; i++) {

                    for (int j = 0; j < col; j++) {
                        if (a[i][j] == 0) {
                            System.out.println((i + 1) + " " + (j + 1));
                            continue outer;
                        }
                    }
                }

            } else {
                outer:
                for (int i = 0; i < row; i++) {

                    for (int j = 0; j < col; j++) {
                        if (a[i][j] == 0) {
                            System.out.println((i + 1) + " " + (j + 1));
                            continue outer;
                        }
                    }
                }
            }


        }
    }
}

