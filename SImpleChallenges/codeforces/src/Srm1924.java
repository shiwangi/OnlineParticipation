import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/23/13
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Srm1924 {

    class Node{
    int x;int y;int num;

    }

    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String []token = (br.readLine()).split(" ");
        int rows = Integer.parseInt(token[0]);
        int cols = Integer.parseInt(token[1]);
        int[][] a = new int[rows][cols];
        String m;char c;
        Node[] breeders=new Node[rows*cols];
        int count=0;int start_x=0,start_y=0,end_x=0,end_y=0;
        for(int i=0;i<rows;i++)
        {

            m=br.readLine();
            for(int j=0;j<cols;j++)
            {
              c=m.charAt(j);
              if(c>48 && c<=57)
              {

                  breeders[count].num=c-48;
                  breeders[count].x=i;
                  breeders[count].y=j;
                  count++;
              }
              if(c=='S'){
                   start_x=i;
                  start_y=j;
              }
                else if(c=='E'){
                  end_x=i;
                  end_y=j;
              }
                else if(c=='T'){
                  a[i][j]=-1;
              }
            }
        }
        int ans=0;
        int res=dij(a,start_x,start_y,end_x,end_y);
        for(int i=0;i<count;i++){
            if(dij(a,breeders[i].x,breeders[i].y,end_x,end_y)<=res)
                ans+=breeders[i].num;
        }
}

public static int dij(int [][]a,int start_x,int start_y,int end_x,int end_y){
     int []dx={1,0,-1,0};
    int []dy={0,1,0,-1};


  return 0;
}
}
