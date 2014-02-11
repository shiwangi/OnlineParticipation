import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 1/10/13
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm2 {

    public static class point implements Comparable<point>{
        int x;int y;


        @Override
        public int compareTo(point o) {
            return (Math.abs(this.x))+(Math.abs(this.y))-((Math.abs(o.x))+(Math.abs(o.y)));  //To change body of implemented methods use File | Settings | File Templates.
        }
    }
    public static int check_y(int y)
    {
        if(y>=0)
        {
            if(y!=0)
                System.out.println(1+" "+y+" U");
            System.out.println("2");
            if(y!=0)
                System.out.println(1+" "+y+" D");
        }
        else if(y<0)
        {
            System.out.println(1+" "+Math.abs(y)+" D");
            System.out.println("2");
            System.out.println(1+" "+Math.abs(y)+" U");
        }

       return 0;
    }

    public static int solve(int x,int y)
    {
        if(x>0)
        {
            System.out.println(1+" "+x+" R");
            check_y(y);
            System.out.println(1+" "+Math.abs(x)+" L");
            System.out.println("3");
        }
        else if(x<0)
        {
            System.out.println(1+" "+Math.abs(x)+" L");
            check_y(y);
            System.out.println(1+" "+Math.abs(x)+" R");
            System.out.println("3");
        }
        else if(x==0)
        {
            check_y(y);
            System.out.println("3");
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        srm2 s=new srm2();
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n=Integer.parseInt(br.readLine()); int res=0;
        point store[]=new point[n] ;

        for(int i=0;i<n;i++)
        {
            store[i]=new point();
        }
        for(int i=0;i<n;i++)
        {
        String tok[] = (br.readLine()).split(" ");
           store[i].x=Integer.parseInt(tok[0]);
            store[i].y=Integer.parseInt(tok[1]);
            res+=(((Math.abs(store[i].x)>0)?1:0 )+((Math.abs(store[i].y)>0?1:0)))*2+1+1;
        }
        System.out.println(res);
        Arrays.sort(store);
        for(int i=0;i<n;i++)
        {
                  solve(store[i].x,store[i].y);
        }
    }
}
