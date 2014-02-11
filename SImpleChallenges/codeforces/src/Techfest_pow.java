import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 27/10/13
 * Time: 1:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Techfest_pow {
    static void binary_search(ArrayList<Long> a,int start,int end, long temp)
    {
        int size=end-start;
        //if(start<0)
        //{
         //   a.add(temp);
        //}
        if(size==0)
        {
            if(a.get(start)<temp)
                   a.add(temp);
            else
            a.add(start,temp);
            return;
        }
        else if(size==1)
        {

            if(a.get(start)>temp)
                a.add(start,temp);
            else if(a.get(end)>temp)
                a.add(end,temp);
            else
                a.add(temp);
            return;
        }
        else{
            if(a.get(start+size/2)>temp)
                binary_search(a,start,start+size/2,temp);
            else
                binary_search(a,start+size/2,end,temp);
        }
    }
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());

        String token[]=(br.readLine()).split(" ");
        ArrayList<Long> a=new ArrayList<Long>();
        long temp;
        for(int i=0;i<n;i++)
        {
        a.add(i,Long.parseLong(token[i]));
        }
        for(int i=0;i<n-1;i++)
        {
            if(a.get(i).equals(a.get(i+1)))
            {
                temp=a.get(i)+1;


                a.remove(i);
                a.remove(i);

                n=n-2 ;
                if(n==0 || i>n-1)
                    a.add(temp);
                else

                        binary_search(a,i,n-1,temp);
          //  System.out.println("after adding"+ n+"\n ");
                i--;

                n++;
            //   for(int j=0;j<n;j++)
              //  {
                //    System.out.print(a.get(j)+ " ");
                //}





            }

        }
       System.out.println(a.get(n-1)-n+1);
    }
}
