import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 13/12/13
 * Time: 7:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class S2 {
    static long binarySearch(long cost, int cost_init, long x, long k,long w){
        int pos = -1;
                    long s=0;long l=x;
        while (true) {
            x=s+(l-s)/2;
            if((cost+cost_init*l)*k>=w && pos == -1){
            l=x-1;

            }
            else if((cost+cost_init*l)*k==w && pos == -1){
               return l;
            }else if((cost+cost_init*l)*k<=w && (cost+cost_init*(l+1))*k>=w){
                return l;
            }else {

                s=x+1;


            }

        }

        //return x;
    }
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(input);
        //int cases=Integer.parseInt(br.readLine()); int flag=0;

            String tokens[]=(br.readLine()).split(" ");
            long w=Long.parseLong(tokens[0]);
            long m=Long.parseLong(tokens[1]);
            long k=Long.parseLong(tokens[2]);
            int cost_init=tokens[1].length();
            long cost=cost_init;
            long x= (long) (Math.pow(10,cost_init) );
            long xs=x;
        x=x-m-1;
            long count=0;
            while(cost*k<=w)
            {
                if(cost*k==w)
                {
                    count++;break;
                }
                 if(x>0)
                 {
                     if((cost+cost_init*x)*k<=w){
                         cost+=cost_init*x;

                         count+=x;
                         cost_init++;
                         x=10*xs;
                         if(x==100){
                             x-=10;
                         }
                         xs=x;
                         continue;
                     }
                     else{
                         x=binarySearch(cost,cost_init,x,k,w);
                         cost+=cost_init*x;
                         count+=x;
                         count++;   break;
                     }
                 }
                else{
                    cost_init++;
                     x=10*xs;
                     xs=x;
                 }

            }
            System.out.println(count);

        }


        }

