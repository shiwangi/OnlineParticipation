import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 17/1/14
 * Time: 9:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class H1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String s=br.readLine();
        int len=s.length();
        String[] token=new String[2];
        int i;
        token[0]="";
        for(i=0;i<len;i++)
        {
            if(s.charAt(i)=='|')
                break;
            else
                token[0]+= s.charAt(i);
        }
        token[1]=s.substring(i+1);

       // System.out.println(token[0]+" "+token[1]);
        int l1=token[0].length();
        int l2=token[1].length();
        int x=Math.abs(l2-l1);
        String ss;
        ss=br.readLine();
        int l=ss.length();
        if(l-x<0)
            System.out.println("Impossible");
        else{
            if((l-x)%2==0)
            {

                if(l1<l2){
                    token[0]=token[0]+ss.substring(0,x);


                }
                else             {
                    token[1]=token[1]+ss.substring(0,x);
               //     System.out.println("hereLE");
                }


            int remain=l-x;
            if(remain>0) {
                token[0]=token[0]+ss.substring(x,x+(l-x)/2);
                token[1]=token[1]+ss.substring(x+(l-x)/2) ;

            }
                System.out.println(token[0]+"|"+token[1]);
        }
            else
                System.out.println("Impossible");

        }

    }
}
