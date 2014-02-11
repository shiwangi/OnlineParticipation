import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: shiwangi
 * Date: 7/20/13
 * Time: 1:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tower {
    public static void main(String[] args) throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String tokens[] = (br.readLine()).split(" ");
        int row = Integer.parseInt(tokens[0]);
        int col = Integer.parseInt(tokens[1]);
        int[][] a = new int[row][col];

        int c = 0, hash = 0;
        int ans = 0;
        for (int i = 0; i < row; i++) {
            String m = (br.readLine());
            for (int j = 0; j < col; j++) {
                if ((m.charAt(j)) == '.') {
                    a[i][j] = 0;
                    c++;
                }//empty -- can be built.
                else {
                    hash++;
                    a[i][j] = -1; //hole
                    if (c > 2)
                        ans = ans + (2 * (c - 2));
                    c = 0;
                }
            }
            if (c > 2)
                ans = ans + (2 * (c - 2));
            c = 0;
        }
        System.out.println(row * col - hash + ans);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((j == col - 1 || a[i][j+1] == -1) && a[i][j] == 0) {
                    if (i == 0 && j == 0) {
                        a[i][j] = 2; //blue tower
                        System.out.println("B" +" "+ (i+1) + " " + (j+1));
                    } else if (i == 0) {
                        if (a[i][j - 1] == 2) {
                            a[i][j] = 3; //red tower
                            System.out.println("R" + " " + (i+1) + " " + (j+1));
                        } else {
                            a[i][j] = 2; //blue tower
                            System.out.println("B" + " "+(i+1 )+ " " + (j+1));
                        }
                    } else if (j == 0) {
                        if (a[i - 1][j] == 2) {
                            a[i][j] = 3; //red tower
                            System.out.println("R" + " " + (i+1 )+ " " + (j+1));
                        } else {
                            a[i][j] = 2; //blue tower
                            System.out.println("B" +" "+ (i+1) + " " + (j+1));
                        }
                    } else if (a[i][j - 1] == 2 || a[i - 1][j] == 2) {
                        a[i][j] = 3; //red tower
                        System.out.println("R" + " " + (i+1 )+ " " + (j+1));
                    } else {

                        a[i][j] = 2; //blue tower
                        System.out.println("B" +" "+ (i+1) + " " + (j+1));

                    }


                } else if (a[i][j] == 0) {
                    a[i][j] = 2; //blue tower
                    System.out.println("B" +" "+ (i+1) + " " + (j+1));
                }

            }

        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if(a[i][j]==2){
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    if (a[i][j - 1] == 2) {
                        a[i][j] = 3; //red tower
                        System.out.println("D" + " " + (i+1) + " " + (j+1));
                        System.out.println("R" + " " + (i+1 )+ " " + (j+1));
                    }

                } else if (j == 0) {
                    if (a[i - 1][j] == 2) {
                        a[i][j] = 3; //red tower
                        System.out.println("D" + " " + (i+1) + " " + (j+1));
                        System.out.println("R" + " " + (i+1 )+ " " + (j+1));
                    }

                } else if (a[i][j - 1] == 2 || a[i - 1][j] == 2) {
                    a[i][j] = 3; //red tower
                    System.out.println("D" + " " + (i+1) + " " + (j+1));
                    System.out.println("R" + " " + (i+1 )+ " " + (j+1));
                }
            }
            }
        }
    }
}
