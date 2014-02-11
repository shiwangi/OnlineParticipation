import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 25/10/13
 * Time: 8:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class srm208b
{
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(input);
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> stack=new ArrayList<Integer>();
        ArrayList<Integer> queue=new ArrayList<Integer>();
        ArrayList<Integer> deck=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            int act=Integer.parseInt(br.readLine());
            if(act !=0)
            {
                if(stack.isEmpty() || stack.get(stack.size()-1)<act)
                {
                    stack.add(act);
                    System.out.println("pushStack");
                }

                else if(deck.isEmpty() || deck.get(0)<act)
                {
                    deck.add(act,0);
                    System.out.println("pushFront");
                }
                else if( deck.get(deck.size()-1)<act)
                {
                    deck.add(act);
                    System.out.println("pushBack");
                }
                else if(queue.isEmpty() || queue.get(0)>act)
                {
                    queue.add(act);
                    System.out.println("pushQueue");
                }
            }
            else{
                int a=0,b=0,c=0,d=0;
                if(queue.isEmpty()){
                     a=-1;
                }
                else
                    a=queue.get(0);
                if(stack.isEmpty())
                {
                   b=-1;
                }
                else
                    b=stack.get(stack.size()-1);
                if(deck.isEmpty())
                {
                    c=-1;d=-1;
                }
                else{
                    c=deck.get(0);
                    d=deck.get(deck.size()-1);
                }
                if(a==-1 && b==-1 && c==-1 && d==-1)
                    System.out.println(0);
                 else{




                if(a>b){
                    if(a>c)
                    {
                        if(a>d)
                        {
                            System.out.println(a+" popQueue");
                            queue.remove(0);
                        }
                        else{
                            System.out.println(d+" popBack");
                            deck.remove(deck.size()-1);
                        }
                    }
                    if(c>d)
                    {
                        System.out.println(c+" popFront");
                        queue.remove(0);
                    }
                    else{
                        System.out.println(d+" popBack");
                        deck.remove(0);
                    }
                }
                else{
                    if(b>c)
                    {
                        if(b>d)
                        {
                            System.out.println(b+" popStack");
                            stack.remove(stack.size()-1);
                        }
                        else{
                            System.out.println(d+" popBack");
                           deck.remove(deck.size()-1);
                        }
                    }
                    else{
                        if(c>d)
                        {
                            System.out.println(c+" popFront");
                           deck.remove(0);
                        }
                        else{
                            System.out.println(d+" popBack");
                           deck.remove(deck.size()-1);
                        }

                    }
                }

            }
            }
        }
}
}
