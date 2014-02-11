import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 17/1/14
 * Time: 9:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class H_2 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n = Integer.parseInt(br.readLine());
        String tokens[] = (br.readLine()).split(" ");
        int hopes = 1;

        if (n == 1) {
            System.out.println("-1");
        }
        else {

            int a[] = new int[n];
            int min_diff = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }
            Arrays.sort(a);

            for (int i = 1; i < n; i++) {

                if (a[i] - a[i - 1] < min_diff)
                    min_diff = a[i] - a[i - 1];

            }

            if (hopes != 0) {
                ArrayList<Integer> ans = new ArrayList<Integer>();
                int flag = 0;
                if (n == 2) {
                    if (min_diff == 0) {
                        System.out.println("1");
                        System.out.println(a[0]);
                        hopes = 0;
                    } else {
                        ans.add(a[0] - min_diff);
                        if (min_diff % 2 == 0) {
                            ans.add(a[0] + min_diff / 2);
                        }

                        ans.add(a[1] + min_diff);
                    }
                } else {
                    for (int i = 1; i < n; i++) {

                        if ((a[i] - a[i - 1] != min_diff )&& ((a[i] - a[i - 1]) == (2 * min_diff))) {
                            if (flag == 0) {
                                flag = 1;
                                ans.add(a[i - 1] + min_diff);
                            } else {
                                System.out.println("0");
                                hopes = 0;
                                flag = 1;
                                break;
                            }
                        } else if (a[i] - a[i - 1] != min_diff) {
                            System.out.println("0");
                            hopes = 0;
                            flag = 1;
                            break;
                        }


                    }
                    if (flag == 0) {
                        if (min_diff == 0) {
                            System.out.println("1");
                            System.out.println(a[0]);
                            hopes = 0;
                        } else {
                            ans.add(a[0] - min_diff);
                            ans.add(a[n - 1] + min_diff);
                        }
                    }
                }

                if (hopes == 1) {
                    int sz = ans.size();
                    System.out.println(sz);
                    for (int i = 0; i < sz; i++) {
                        System.out.print(ans.get(i) + " ");
                    }
                    System.out.println();
                }

            }
        }

    }
}

