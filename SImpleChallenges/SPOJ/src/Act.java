import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/6/13
 * Time: 10:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class Act {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        int cases = Integer.parseInt(br.readLine());int num_p;
        for(int i=0;i<cases;i++)
        {
           String tokens[]=(br.readLine()).split(" ");
           num_p=Integer.parseInt(tokens[0]);
            int wins[]=new int[num_p];
            int match[]=new int[num_p];
            ArrayList<Integer> l=new ArrayList<Integer>();

            int set[]=new int[num_p];
            char []s=tokens[1].toCharArray();
            int matches=s.length;
            int flag=0,f=0,t=0;
            for(int j=0;j<matches;j++)
            {
                for(int m=0;m<l.size();m++)
                {
                    if(l.get(m)!=s[j]-65){
                    wins[l.get(m)]--;
                    l.remove(m);m--; }
                }
                wins[s[j]-65]++;flag=0;
                for(int k=0;k<num_p;k++)
                {

                    if(k!=s[j]-65){
                    if(wins[k]>2)
                    {  flag=1;break;} }
                }
                if((flag==0 && wins[s[j]-65]==4) || wins[s[j]-65]>4)
                {
                    wins=new int[num_p];
                  //  System.out.print("i won a matchh");
                  match[s[j]-65]++;
                    if(match[s[j]-65]>=6)
                    {

                        f = 0;t=0;
                        for(int k=0;k<num_p;k++)
                        {

                            if(k!=s[j]-65){

                                  if(match[k]!=0)
                                      t = 1;
                                if(match[s[j]-65]-match[k]<2)
                                {  f=1;break;} }
                        }
                        if(f==0 && t==0)
                        {
                            match=new int[num_p];
                            set[s[j]-65]+=2;
                        }
                        else if(f==0){
                            match=new int[num_p];
                            set[s[j]-65]++;}
                        if(set[s[j]-65]>=3)
                            System.out.println(s[j]);
                    }

                }
                else if(wins[s[j]-65]>3)
                    l.add(s[j]-65);

            }

        }
}
}
