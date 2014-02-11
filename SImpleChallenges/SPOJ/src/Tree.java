import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 4/10/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Tree {
    ArrayList<Node> l;
    int []visited;
    class Node{
        ArrayList<Node> children =new ArrayList<Node>();
    }
    Tree(int n)
    {
       l=new ArrayList<Node>(n);
        for(int i=0;i<n;i++)
        {
            l.add(new Node());
        }
        visited=new int[n];
    }
    public int insert_edge(int v,int u)
    {
        (l.get(v-1)).children.add(l.get(u-1));
        return 0;
    }
    public int check_loop()
    {
        Queue q=new ConcurrentLinkedQueue();
        q.add(l.get(0));
        while(!q.isEmpty())
        {
            Node x= (Node) q.poll();
            System.out.println("m here"+(l.indexOf(x)+1));
            if(visited[l.indexOf(x)]==0)
            visited[l.indexOf(x)]=1;
            else
            {
                return 1;
            }
            while(x.children.iterator().hasNext())
            {
                q.add(x.children.iterator().next());
            }

        }
        return 0;

    }
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tokens[]=(br.readLine()).split(" ");
        int n= Integer.parseInt(tokens[0]);
        Tree obj=new Tree(n);
        int edges= Integer.parseInt(tokens[1]);
        if(n!=edges+ 1 ) {
            System.out.println("NO");
            return;
        }
        for(int i=0;i<edges;i++)
        {
            String token[]=(br.readLine()).split(" ");
            int v= Integer.parseInt(tokens[0]);
            int u= Integer.parseInt(tokens[1]);
            obj.insert_edge(v,u)  ;
        }
        int res=obj.check_loop();
        if(res==1)
            System.out.println("NO");
        else
            System.out.println("YES");
}
}
