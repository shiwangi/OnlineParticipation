import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 24/11/13
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Hc_2 {
    static class Player implements Comparable<Player>{
        String name;
        int shot;
        int height;
        Player(String n,int s,int h)
        {
            name=n;shot=s;h=height;
        }

        @Override
        public int compareTo(Player o) {
            if(o.shot-shot==0)
                return o.height-height;  //To change body of implemented methods use File | Settings | File Templates.
            else
                return o.shot-shot;
        }
    }
    static class P implements Comparable<P>{
        String name;
        int base;
        int time;
        P(String n,int b,int t)
        {
            name=n;base=b;time=t;
        }

        @Override
        public int compareTo(P o) {
            if(o.time-time==0)
                return base-o.base;  //To change body of implemented methods use File | Settings | File Templates.
            else
                return time-o.time;
        }
    }
    class N implements Comparable<N>{
        String name;

        N(String n)
        {
            name=n;
        }

        @Override
        public int compareTo(N o) {

            return name.compareTo(o.name);
        }
    }
    class Q implements Comparable<Q>{
        String name;
        int base;
        int time;
        Q(String n,int b,int t)
        {
            name=n;base=b;time=t;
        }

        @Override
        public int compareTo(Q o) {
            if(o.time-time==0)
                return o.base-base;  //To change body of implemented methods use File | Settings | File Templates.
            else
                return o.time-time;
        }
    }
    public PriorityQueue<N> tr(PriorityQueue<P> out_play,PriorityQueue<N> fin,int m,int n, int p)
    {

        PriorityQueue<Q> in_play=new PriorityQueue<Q>();

        for(int j=0;j<p;j++)
        {
            P ob=out_play.poll();
            ob.time++;

            in_play.add(new Q(ob.name,ob.base,ob.time));
        }
        if(n>2*p){
        for(int j=0;j<m;j++)
        {

            Q aa=in_play.poll(); Q current;
            Iterator<Q> iter = in_play.iterator();
            while (iter.hasNext()) {
                current = iter.next();
                current.time++;

            }
            P ob=out_play.poll();
            ob.time++;
            out_play.add(new P(aa.name,aa.base,aa.time))  ;

            in_play.add(new Q(ob.name,ob.base,ob.time));

        }
        }
        for(int j=0;j<p;j++)
        {
            Q ob=in_play.poll();
             fin.add(new N(ob.name));
        }
        return fin;
    }
    public static void main(String[] args) throws IOException {


        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());
        Hc_2 h=new Hc_2();
        for (int i = 0; i < cases; i++) {

            String tok[] = (br.readLine()).split(" ");
            int n = Integer.parseInt(tok[0]);
            int m= Integer.parseInt(tok[1]);
            int p = Integer.parseInt(tok[2]);
            PriorityQueue<Player> queue= new PriorityQueue<Player>();
            PriorityQueue<P> queue1= new PriorityQueue<P>();
            PriorityQueue<P> queue2= new PriorityQueue<P>();

            PriorityQueue<N> fin=new PriorityQueue<N>();
            for(int j=0;j<n;j++)
            {
                String toks[]=(br.readLine()).split(" ");
                String nam = toks[0];
                int s= Integer.parseInt(toks[1]);
                int hh = Integer.parseInt(toks[2]);

                queue.add(new Player(nam,s,hh))  ;

            }
            for(int j=0;j<n;j++)
            {
                Player k=queue.poll();
                if(j%2==0)
                    queue1.add(new P(k.name, j, 0));
                else
                queue2.add(new P(k.name,j,0));
            }

              fin=  h.tr(queue1, fin, m, n, p);
           fin= h.tr(queue2,fin,m,n,p);
            System.out.print("Case #"+(i+1)+": ");

            for(int j=0;j<2*p;j++)
            {
                System.out.print(fin.poll().name +" ");
            }
            System.out.println();
        }

        }
}
