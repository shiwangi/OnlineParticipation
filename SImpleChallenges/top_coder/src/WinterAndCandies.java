import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class WinterAndCandies
{
	public int getNumber(int[] type)
	{
		       int []count=new int[50];
        for(int i=0;i<type.length;i++)
        {
            count[type[i]] ++;
        }
        int l=type.length;
        int ans[]=new int[l+1];
        ans[1]=count[1];
        int res=ans[1];
        for(int i=2;i<=l;i++)
        {
            ans[i]=ans[i-1]*count[i];
            res+=ans[i];
        }
        return res;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, boolean hasAnswer, int p1) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}");
		System.out.println("]");
		WinterAndCandies obj;
		int answer;
		obj = new WinterAndCandies();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumber(p0);
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
		
		int[] p0;
		int p1;
		
		// ----- test 0 -----
		p0 = new int[]{1,3,2};
		p1 = 3;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1,1,2};
		p1 = 4;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{1,3,2,5,7,4,5,4};
		p1 = 9;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1,1,2,2,3,3,4,4,5,5};
		p1 = 62;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{2};
		p1 = 0;
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// 
	// It's winter time!
	// You have some candies arranged in a row and now you want to choose some of them and give them to your friend.
	// 
	// 
	// 
	// 
	// You are given a int[] type.
	// Each candy has a type, which is some positive integer.
	// For each i, type[i] represents the type of i-th candy.
	// You want to choose some non-empty subset of candies with the following property:
	// if the number of candies you choose is K, their types must be precisely all the numbers from 1 to K, inclusive.
	// Return the number of different ways to do that.
	// (Two ways are considered different if there exists some candy that is chosen in only one of them.)
	// 
	// 
	// DEFINITION
	// Class:WinterAndCandies
	// Method:getNumber
	// Parameters:int[]
	// Returns:int
	// Method signature:int getNumber(int[] type)
	// 
	// 
	// NOTES
	// -The answer will always fit in a signed 32-bit integer.
	// 
	// 
	// CONSTRAINTS
	// -type will contain between 1 and 50 elements, inclusive.
	// -Each element of type will be between 1 and 50, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {1, 3, 2}
	// 
	// Returns: 3
	// 
	// There are 7 possible non-empty subsets in this case:
	// 
	// 
	// (1)
	// 
	// 
	// (3)
	// 
	// 
	// (2)
	// 
	// 
	// (1, 3)
	// 
	// 
	// (1, 2)
	// 
	// 
	// (3, 2)
	// 
	// 
	// (1, 3, 2)
	// 
	// 
	// Out of them, only first, fifth and seventh are valid. Thus, the answer is 3.
	// 
	// 1)
	// {1, 1, 2}
	// 
	// Returns: 4
	// 
	// Note that the chosen subset can never contain two elements with the same type.
	// 
	// 2)
	// {1, 3, 2, 5, 7, 4, 5, 4}
	// 
	// Returns: 9
	// 
	// 
	// 
	// 3)
	// {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}
	// 
	// Returns: 62
	// 
	// 
	// 
	// 4)
	// {2}
	// 
	// Returns: 0
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
