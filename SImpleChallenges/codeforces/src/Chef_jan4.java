import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 5/1/14
 * Time: 9:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Chef_jan4{

    static class Deg implements Comparable<Deg> {
        int n, degree;

        Deg(int node, int deg) {
            n = node;
            degree = deg;
        }

        @Override
        public int compareTo(Deg o) {
            return degree - o.degree;  //To change body of implemented methods use File | Settings | File Templates.
        }
    }


    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        int x, y;

        for (int i = 0; i < cases; i++) {
            String tokens[] = (br.readLine()).split(" ");
            int nodes = Integer.parseInt(tokens[0]);
            int edges = Integer.parseInt(tokens[1]);
            Deg degree[] = new Deg[nodes];
            ArrayList<Integer> arr[]=new ArrayList[nodes];
            for (int j = 0; j < nodes; j++) {
                degree[j] = new Deg(j, 0);
               arr[j]=new ArrayList<Integer>();
            }
            for (int j = 0; j < edges; j++) {
                String token[] = (br.readLine()).split(" ");
                x = Integer.parseInt(token[0]) - 1;
                y = Integer.parseInt(token[1]) - 1;
                if (!arr[x].contains(y)) {

                    arr[x].add(y);
                    arr[y].add(x);
                    degree[x].degree++;
                    degree[y].degree++;
                }
            }
            if (nodes % 2 == 0) {
                Arrays.sort(degree);
                int visited[] = new int[nodes];
                int ans = 0;
                outer:
                for (int j = 0; j < nodes; j++) {

                    if (degree[j].degree >= 1 && visited[j]==0) {

                        for (int k = j+1; k < nodes; k++) {

                            if (arr[degree[j].n].contains(degree[k].n)) {

                                degree[k].degree=1;
                                degree[j].degree=1;
                                arr[degree[j].n]=new ArrayList<Integer>();
                                arr[degree[k].n]=new ArrayList<Integer>();
                                arr[degree[k].n].add(degree[j].n) ;
                                arr[degree[j].n].add(degree[k].n) ;
                                for (int h = 0; h < nodes; h++) {
                                    if (arr[degree[h].n].contains(degree[k].n) && degree[h].n != degree[j].n) {
                                        arr[degree[h].n].remove(degree[k].n);
                                        degree[h].degree--;
                                    }
                                    if (arr[degree[h].n].contains(degree[j].n) && degree[h].n != degree[k].n) {
                                        arr[degree[h].n].remove(degree[j].n);
                                        degree[h].degree--;
                                    }
                                }
                                visited[degree[j].n] = 1;
                                visited[degree[k].n] = 1;
                                Arrays.sort(degree);
                                j = -1;
                                continue outer;
                            }
                        }



                    }
                }
                for (int j = 0; j < nodes; j++) {
                    if (degree[j].degree != 1) {
                        ans = 1;
                        break;
                    }
                }
                if (ans == 1)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            }
            else
                System.out.println("NO");
        }
    }
}
