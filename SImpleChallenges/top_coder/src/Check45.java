import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 21/12/13
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class Check45 {
   static String a;
    public static int solve(int state,int isFour,int p)
    {
        if(p==101)
            return 1;
        int res=0;
        if(state==1){
        if(isFour==0)
        {
            for(int i=0;i<=8;i++)
            {
                res+=solve(1,0,p+1);
            }
            res+=solve(1,1,p+1);
        }
        else{
            for(int i=0;i<=7;i++)
            {
                res+=solve(1,0,p+1);
            }
            res+=solve(1,1,p+1);
        }
        }
        else{
            if(isFour==0)
            {
                for(int i=a.charAt(p)-'1';i>=0;i++)
                {
                    if(i==4)
                        res+=solve(1,1,p+1);
                    else
                         res+=solve(0,1,p+1);
                }
               if( a.charAt(p)-'0'==4)
                res+=solve(1,0,p+1);
                else
                   res+=solve(0,0,p+1);

            }
            else{
                for(int i=a.charAt(p)-'1';i>=0;i++)
                {
                    if(i==4)
                        res+=solve(1,1,p+1);
                    if(i==5)
                        continue;
                    else
                        res+=solve(0,1,p+1);
                }
                if( a.charAt(p)-'0'==4)
                    res+=solve(1,0,p+1);
                if( a.charAt(p)-'0'==5)
                    res+=0;
                else
                    res+=solve(0,0,p+1);


            }
        }
        return res;
    }
    public static void main(String args[]) throws IOException
    {
     a="10094320492353857438";
        //such that it doesnot have 45

        System.out.println(solve(0,0,1));
    }
}
