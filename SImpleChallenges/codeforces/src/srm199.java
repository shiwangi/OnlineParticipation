import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 9/7/13
 * Time: 1:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm199 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        String tok[] = (br.readLine()).split(" ");
        int a[] = new int[cases];
        int count[] = new int[8];
        int f = 0;
        for (int i = 0; i < cases; i++) {
            a[i] = Integer.parseInt(tok[i]);
            count[a[i]]++;
        }
        int c3 = count[3];
        int c2 = count[2];
        int c6 = count[6];
        int c4 = count[4];
        if (count[1] != cases / 3) {
            System.out.println("-1");
            f = 1;
        } else if ((count[5] != 0 || count[7] != 0)) {
            System.out.println("-1");
            f = 1;
        } else if ((count[2] != count[4] + (count[6] - count[3])) || count[4]>count[2]) {
            System.out.println("-1");
            f = 1;
        }
        count[2] = count[2] - count[4];
        count[6] = count[6] - count[2];
        if (count[3] != count[6] && f == 0) {
            System.out.println("-1");
            f = 1;
        }
        if (f == 0) {
            for (int i = 0; i < cases / 3; i++) {
                System.out.print("1 ");
                if (c2 > 0) {
                    System.out.print("2 ");
                    c2--;
                    if (c4 > 0) {
                        System.out.println("4");
                        c4--;
                    } else {
                        System.out.println("6");
                        c6--;
                    }
                } else if (c3 > 0) {
                    System.out.print("3 ");
                    c3--;
                    System.out.println("6");
                    c6--;
                }
            }
        }


    }
}
