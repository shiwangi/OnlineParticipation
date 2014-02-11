public class FibonacciPositioning
{
	public double getFPosition(int n)
	{

    long a,b=1; long t=1;
        if(n==1)
            return 2;
        int c=2;
        while(t<n)
        {
            c++;
            a=b;b=t;
            t=a+b;
             if(t==n)
                return c;
        }
       return c-1+((double)(n-b)/(double)(t-b));

	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, double p1) {
		System.out.print("Test " + testNum + ": [" + p0);
		System.out.println("]");
		FibonacciPositioning obj;
		double answer;
		obj = new FibonacciPositioning();
		long startTime = System.currentTimeMillis();
		answer = obj.getFPosition(p0);
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
			res = answer == answer && Math.abs(p1 - answer) <= 1e-9 * Math.max(1.0, Math.abs(p1));
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
		
		int p0;
		double p1;
		
		// ----- test 0 -----
		p0 = 1;
		p1 = 2.0D;
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 5;
		p1 = 5.0D;
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 4;
		p1 = 4.5D;
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 90000009;
		p1 =39.68445321652186D;
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// The fibonacci sequence is a sequence of integers in which each number is equal to the sum of the two preceding numbers.  The first two integers in the sequence are both 1. Formally:
	// 
	//  F1 = 1  
	//  F2 = 1 
	//  Fi = Fi-1 + Fi-2 for each i > 2 
	// 
	// The beginning of this sequence is 1,1,2,3,5,8,13,21.
	// We'll define the fibonacci position of an integer greater than or equal to 1 as follows:
	// 
	//  The fibonacci position of 1 is 2 (since F2 = 1) 
	//  The fibonacci position of any integer n > 1 such that Fi = n is i 
	//  The fibonacci position of any integer n > 1 such that it is strictly between Fi and Fi+1 is i+(n-Fi)/(Fi+1-Fi) (informally, this means it is linearly distributed between Fi and Fi+1) 
	// 
	// As examples, if FP(n) is the fibonacci position of n,
	// FP(1)=2 (first rule) 
	// FP(5)=5 (second rule F5 = 5) 
	// FP(4)=4.5 (third rule, is right in the middle of F4 = 3 and F5 = 5)
	// Given an integer n, return its fibonacci position as a double.
	// 
	// DEFINITION
	// Class:FibonacciPositioning
	// Method:getFPosition
	// Parameters:int
	// Returns:double
	// Method signature:double getFPosition(int n)
	// 
	// 
	// NOTES
	// -The returned value must be accurate to 1e-9 relative or absolute.
	// 
	// 
	// CONSTRAINTS
	// -n will be between 1 and 100000000 (108), inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 1
	// 
	// Returns: 2.0
	// 
	// 1)
	// 5
	// 
	// Returns: 5.0
	// 
	// 2)
	// 4
	// 
	// Returns: 4.5
	// 
	// Examples from the problem statement.
	// 
	// 3)
	// 100
	// 
	// Returns: 11.2
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
