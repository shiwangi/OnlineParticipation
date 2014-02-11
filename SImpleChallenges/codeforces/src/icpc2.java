import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 2/11/13
 * Time: 10:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class icpc2 {
    static int binarySearch(int arr[], int value, int min, int max){
        int pos = -1;

        while (max >= min && pos == -1) {
            int mid = min+(max-min)/2;

            if(arr[mid] ==  value){
                pos = mid;
            }else if(arr[mid] < value){
                min = mid +1;
            }else if(arr[mid] > value){
                max = mid -1;
            }

        }
        if(pos!=-1)
        arr[pos]=-1;
        return pos;
    }
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(input);
        int cases=Integer.parseInt(br.readLine());
        for(int i=0;i<cases;i++)
        {
            int n=Integer.parseInt(br.readLine());
            String tokens[]=(br.readLine()).split(" ");
            int a[]=new int[n];
            for(int j=0;j<n;j++)
            {
                a[j]=Integer.parseInt(tokens[j]);
            }
            int no=Integer.parseInt(br.readLine());
            String token[]=(br.readLine()).split(" ");int num;
            int b[]=new int[no];
            int sim=0;
            if(n>no)
                num=n;
            else
            num=no;
            for(int j=0;j<no;j++)
            {
                b[j]=Integer.parseInt(token[j]);
                if(binarySearch(a,b[j],0,n-1)!=-1)
                    sim++;


            }
            System.out.println(num-sim);
        }

    }
}
