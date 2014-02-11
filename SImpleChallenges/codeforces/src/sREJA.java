import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 9/1/14
 * Time: 6:13 PM
 * To change this template use File | Settings | File Templates.
 */

public class sREJA {
    static int visited[];
    static Element []arr;
    static int degree[];
    static int nodes;
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
    static class Element{
       ArrayList<Integer> connections;
        Element(){

            connections=new ArrayList<Integer>();
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        int x, y;

        for (int i = 0; i < cases; i++) {
            String tokens[] = (br.readLine()).split(" ");
            nodes = Integer.parseInt(tokens[0]);
            int edges = Integer.parseInt(tokens[1]);
            arr=new Element[nodes];
            visited=new int[nodes];
            degree=new int[nodes];
            for (int j = 0; j < nodes; j++) {
                arr[j]=(new Element());
            }
            for (int j = 0; j < edges; j++) {
                String token[] = (br.readLine()).split(" ");
                x = Integer.parseInt(token[0]) - 1;
                y = Integer.parseInt(token[1]) - 1;
                if (!arr[x].connections.contains(y)) {
                    arr[x].connections.add(y);
                    arr[y].connections.add(x);
                    degree[x]++;
                    degree[y]++;
                }
            }
            int j=findnodewithmindegree();
            int partner,size;
            int friend,flag=0;
            if(nodes%2==0){
            do
            {
                     if(degree[j]>=1){
                          partner=findmindegconnection(j);
                         visited[j]=1;
                         visited[partner]=1;
                          //removing j ka farzi connections.
                         size=arr[j].connections.size();
                         for(int k=0;k<size;k++){
                               friend=arr[j].connections.get(k);
                             if(friend!=partner){
                                 arr[j].connections.remove(k);
                                 k--;
                                 arr[friend].connections.remove(arr[friend].connections.indexOf(j));
                                 size--;
                                 degree[friend]--;
                                 degree[j]--;
                             }
                         }
                         size=arr[partner].connections.size();
                         for(int k=0;k<size;k++){
                             friend=arr[partner].connections.get(k);
                             if(friend!=j){
                                 arr[partner].connections.remove(k);
                                 size--;
                                 k--;
                                 arr[friend].connections.remove(arr[friend].connections.indexOf(partner));
                                 degree[friend]--;
                                 degree[partner]--;
                             }
                         }
                        j=findnodewithmindegree();
                     }
                else{
                         flag=1;
                         break;
                     }

            }while(j<nodes);
            if(flag==1)
                System.out.println("NO");
            else{
                System.out.println("YES");
            }
            }
            else{
                System.out.println("NO");
            }
        }
    }

    private static int findnodewithmindegree() {

       int min=Integer.MAX_VALUE;
        int ans=nodes+1;

        for(int i=0;i<nodes;i++)
        {
            if(visited[i]==0){
            if(degree[i]<min){
                min=degree[i];
                ans=i;
            }
            }
        }
        return ans;
    }

    private static int findmindegconnection(int n) {
        int size=arr[n].connections.size();
        int min=Integer.MAX_VALUE;
        int ans=nodes+1;
        for(int i=0;i<size;i++)
        {
              if(degree[arr[n].connections.get(i)]<min)
              {
                  min= degree[arr[n].connections.get(i)];
                  ans=arr[n].connections.get(i);
              }
        }
        return ans;
    }
}

