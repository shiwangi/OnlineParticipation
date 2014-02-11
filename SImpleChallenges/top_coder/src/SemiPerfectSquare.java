public class SemiPerfectSquare
{
	public String check(int N)
	{
        int flag=0;
		for(int i=N;i>1;i--)
        {
            if(N%(i)==0 )
            if(Math.sqrt(i)==(int)Math.sqrt(i))
            {
                if((N/(i)<Math.sqrt(i))){
                System.out.println(i);
                flag=1;
                break;
            } }
        }
        if(flag==1)
            return ("Yes");
        else
            return ("No");
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, boolean hasAnswer, String p1) {
		System.out.print("Test " + testNum + ": [" + p0);
		System.out.println("]");
		SemiPerfectSquare obj;
		String answer;
		obj = new SemiPerfectSquare();
		long startTime = System.currentTimeMillis();
		answer = obj.check(p0);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p1 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p1);
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
		String p1;
		
		// ----- test 0 -----
		p0 = 48;
		p1 = "Yes";
		all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 1000;
		p1 = "No";
		all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 25;
		p1 = "Yes";
		all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 47;
		p1 = "No";
		all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = 847;
		p1 = "Yes";
		all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Magical Girl Iris loves perfect squares.
	// A positive integer n is a perfect square if and only if there is a positive integer b >= 1 such that b*b = n.
	// For example, 1 (=1*1), 16 (=4*4), and 169 (=13*13) are perfect squares, while 2, 54, and 48 are not.
	// 
	// Iris also likes semi-squares.
	// A positive integer n is called a semi-square if and only if there are positive integers a >= 1 and b > 1 such that a < b and a*b*b = n.
	// For example, 81 (=1*9*9) and 48 (=3*4*4) are semi-squares, while 24, 63, and 125 are not.
	// (Note that we require that a < b.
	// Even though 24 can be written as 6*2*2, that does not make it a semi-square.)
	// 
	// You are given a int N.
	// Return "Yes" (quotes for clarity) if N is a semi-square number.
	// Otherwise, return "No".
	// 
	// DEFINITION
	// Class:SemiPerfectSquare
	// Method:check
	// Parameters:int
	// Returns:String
	// Method signature:String check(int N)
	// 
	// 
	// NOTES
	// -The return value is case-sensitive. Make sure that you return the exact strings "Yes" and "No".
	// 
	// 
	// CONSTRAINTS
	// -N will be between 2 and 1000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 48
	// 
	// Returns: "Yes"
	// 
	// 48 can be expressed as 3 * 4 * 4. Therefore, 48 is a semi-square.
	// 
	// 1)
	// 1000
	// 
	// Returns: "No"
	// 
	// 1000 can be represented as 10 * 10 * 10, but it doesn't match the definition of semi-perfect squares.
	// 
	// 2)
	// 25
	// 
	// Returns: "Yes"
	// 
	// 
	// 
	// 3)
	// 47
	// 
	// Returns: "No"
	// 
	// 
	// 
	// 4)
	// 847
	// 
	// Returns: "Yes"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
