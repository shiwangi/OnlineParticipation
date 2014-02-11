import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/21/13
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Words {
    public static void main(String[] args) throws IOException {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(input);
    int cases = Integer.parseInt(br.readLine());
        int n;

    for(int i=0;i<cases;i++)
    {

        int []freq_s=new int[26];    int []freq_e=new int[26];
        Arrays.fill(freq_s,-2); Arrays.fill(freq_e,-2);
         n= Integer.parseInt(br.readLine());
        for(int j=0;j<n;j++){
        String m=(br.readLine());
            freq_s[m.charAt(0)-97]++;
            freq_e[m.charAt(m.length()-1)-97]++;
        }
        int c=0; int count=0;int flag=0;
        for(int j=0;j<26;j++){
            if(freq_s[j]!=-2 || freq_e[j]!=-2) {
              if(freq_s[j]!=freq_e[j]) {
                  if(freq_e[j]>freq_s[j])
                    c+=freq_e[j]-freq_s[j];
                  else if(freq_e[j]<freq_s[j])
                      count+=freq_s[j]-freq_e[j];

              }     }
            if(c>1 || count>1){
                flag=1;break;
            }
        }
        if(flag==1)
            System.out.println("The door cannot be opened.");
        else
            System.out.println("Ordering is possible.");
}
    }
}
