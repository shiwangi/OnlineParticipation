import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class HexagonalBoard
{
	public int minColors(String[] board)
	{
        int l=board.length;
        int m=board[0].length();
		   int [][]a=new int[l][m];

        int dx[]={-1,-1,0,1,1, 0,-1};
        int dy[]={ 0, 1,1,0,-1,-1,0};
        for(int i=0;i<l;i++)
        {
            for (int j=0;j<m;j++)
            {
               a[i][j]=(board[i].charAt(j)=='X')?1:0;
            }
        }
        int count=0;int max=0;int xs=0; int check;
        for(int i=0;i<l;i++)
        {
            for (int j=0;j<m;j++)
            {
                   count=0; check=0;
                if(a[i][j]==1){
                        count=1;
               for(int k=0;k<7;k++)
               {
                   if(i+dx[k]>=0 && i+dx[k]<l && j+dy[k]>=0 && j+dy[k]<m)  {
                   if(a[i+dx[k]][j+dy[k]]==1 ){
                       if(check==1)
                          return 3;
                       else{
                           count=2;
                           check=1;
                       }

                   }
                   else
                       check=0;
                    }
                   else
                       check=0;
               }
               if(count>max)
                   max=count;

                }
            }
        }
        if(max==0 && xs>0)
            return 1;
        return max;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p0[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		HexagonalBoard obj;
		int answer;
		obj = new HexagonalBoard();
		long startTime = System.currentTimeMillis();
		answer = obj.minColors(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p1);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p1;
		}
		if (!res) {
			System.out.println("DOESN'T MATCH!!!!");
		} else if ((endTime - startTime) / 1000.0 >= 2) {
			System.out.println("FAIL the timeout");
			res = false;
		} else if (hasAnswer) {
			System.out.println("Match :-)");
		} else {
			System.out.println("OK, but is it right?");
		}
		System.out.println("");
		return res;
	}
	public static void main(String[] args) {
		boolean all_right;
		all_right = true;
		
		String[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new String[]{"---","---","---"};
		p1 = 0;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new String[]{"-X--","---X","----","-X--"};
		p1 = 1;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new String[]{"XXXX","---X","---X","---X"};
		p1 = 2;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new String[]{"XX-XX--","-XX-XXX","X-XX--X","X--X-X-","XX-X-XX","-X-XX-X","-XX-XX-"};
		p1 = 3;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// The pony Applejack has an N by N hexagonal board. The following picture shows the hexagonal board when N = 1, 2, 3, and 4.
	// 
	// 
	// 
	// 
	// 
	// She wants to color some cells of the board. You are given a String[] board. If the j-th character of the i-th element of board is 'X', she wants to color the cell (i, j). If she colors two cells that share an edge, she must use different colors for those cells. Return the minimal number of colors she needs.
	// 
	// DEFINITION
	// Class:HexagonalBoard
	// Method:minColors
	// Parameters:String[]
	// Returns:int
	// Method signature:int minColors(String[] board)
	// 
	// 
	// CONSTRAINTS
	// -board will contain between 1 and 50 elements, inclusive.
	// -Each element of board will contain exactly N characters, where N is the number of elements in board.
	// -Each character in board will be either 'X' or '-'.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {"---",
	//  "---",
	//  "---"}
	//  
	// 
	// Returns: 0
	// 
	// She won't color any cells, so she won't need any colors.
	// 
	// 1)
	// {"-X--",
	//  "---X",
	//  "----",
	//  "-X--"}
	// 
	// Returns: 1
	// 
	// She can color all cells with the same color.
	// 
	// 2)
	// {"XXXX",
	//  "---X",
	//  "---X",
	//  "---X"}
	// 
	// Returns: 2
	// 
	// For example, she can color cells in the following way:
	// 
	// Color cells (0, 0), (0, 2), (1, 3), and (3, 3) red.
	// Color cells (0, 1), (0, 3), and (2, 3) blue.
	// 
	// 
	// 
	// 3)
	// {"XX-XX--"
	// ,"-XX-XXX"
	// ,"X-XX--X"
	// ,"X--X-X-"
	// ,"XX-X-XX"
	// ,"-X-XX-X"
	// ,"-XX-XX-"}
	// 
	// Returns: 3
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
