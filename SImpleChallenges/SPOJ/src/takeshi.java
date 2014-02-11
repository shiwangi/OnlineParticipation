import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 6/9/13
 * Time: 2:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class takeshi {
    public static void main(String[] args) throws IOException {
     int n,l,d;
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);
        String tokens[]= (br.readLine()).split(" ");
        String tokens2[]= (br.readLine()).split(" ");
        String tokens3[]= (br.readLine()).split(" ");
        n=Integer.parseInt(tokens[0]);
        d=Integer.parseInt(tokens[1]);
        l=Integer.parseInt(tokens[2]);
        double  []p=new double[n];
        int []a=new int[n];
        for(int i=0;i<n;i++)
        {
            p[i]=Double.parseDouble(tokens2[i]);
        }
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(tokens3[i]);
        }


    mergeSort_srt(a,p,0,n-1);
        double []soln=new double[l+1];
        //Arrays.fill(soln,1);
        int flag=0;
        int t=0;int i,key=0;
        while(t<n && a[t]<=d )
        {  soln[a[t]]=p[t];t++;}
    outer:for( i=0;i<n;i++)
    {
        for(int j=a[i]-d;j<a[i];j++) {
            if(j>=0)

                soln[a[i]]= Math.max(soln[j]*p[i],soln[a[i]]);

        }
        if(l-a[i]<=d)
        {
            flag=1;key=i;
            break outer;
        }

    }

        NumberFormat formatter = new DecimalFormat("#0.00000");
         if(flag==1)
             System.out.println(formatter.format(soln[a[key]]));
        else
            System.out.println("IMPOSSIBLE");




}

    public static void mergeSort_srt(int array[],double a[],int lo, int n){
        int low = lo;
        int high = n;
        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;
        mergeSort_srt(array,a, low, middle);
        mergeSort_srt(array,a, middle + 1, high);
        int end_low = middle;
        int start_high = middle + 1;
        while ((lo <= end_low) && (start_high <= high)) {
            if (array[low] < array[start_high]) {
                low++;
            } else {
                int Temp = array[start_high];double to=a[start_high];
                for (int k = start_high- 1; k >= low; k--) {
                    array[k+1] = array[k];
                    a[k+1]=a[k];
                }
                array[low] = Temp;
                a[low]=to;
                low++;
                end_low++;
                start_high++;
            }
        }
    }

    public static double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("");
        return Double.valueOf(twoDForm.format(d));
    }
}

