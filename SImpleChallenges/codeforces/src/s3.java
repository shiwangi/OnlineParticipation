import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 13/12/13
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class s3 {
    static int binarySearch(int arr[], int value, int min, int max) {
        int pos = max;

        while (max >= min ) {
            int mid = min + (max - min) / 2;

            if (arr[mid] == value) {
                while(arr[mid+1]==value)mid++;
                return mid;
            }
            else if (mid-max==0|| (arr[mid] < value && arr[mid+1] > value))
                return mid;
            else if (arr[mid] < value) {
                min = mid + 1;
            } else if (arr[mid] > value) {
                max = mid - 1;
            }

        }

        return pos;
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(input);
        int n = Integer.parseInt(br.readLine());
        int a[] = new int[n];
        int count[] = new int[n];
        //int max=Integer.parseInt(br.readLine());max=max*2;
        for (int l = 0; l < n; l++) {
            a[l] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(a);
        int lst_counted = n - 1;
        int hide=0;
        for (int j = n - 1; j >= 0; j--) {
            int b = binarySearch(a, a[j] / 2, 0, j);

            if (b>=lst_counted) {
                if (lst_counted > 0) {
                    if (a[--lst_counted] < a[b]) {
                        count[lst_counted]++; hide++;
                    }
                }
            }
            else{
                count[b]++;
                hide++;
                lst_counted=b;
            }
        }
        System.out.println(n-hide);
    }
}