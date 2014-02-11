import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/7/13
 * Time: 1:23 PM
 * To change this template use File | Settings | File Templates.
 */
class Subs {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());int l1,l2;int max;  char c;int count;
        for(int i=0;i<cases;i++)
        {
            String  x=br.readLine();
            String  y=br.readLine();
            l1=x.length();
            l2=y.length();
            //  System.out.println(l1+" "+l2);
            max=l2/l1;int j;
            outer:for( j=max;j>0;j--)
            {
                int x_traversal=0;
                int y_traversal=0;
                int flag=0;
                while(x_traversal!=l1){
                    count=0;
                    c=x.charAt(x_traversal);
                    x_traversal++;
                    while(count<j)
                    {
                        if(y_traversal==l2){
                            flag=1;break;
                        }
                       if(y.charAt(y_traversal)==c)
                        count++;
                        y_traversal++;

                    }
                    if(flag==1)
                        continue outer;


                }
                if(flag==0)
                         break;
            }
                   System.out.println(j);

            }

        }
    }

