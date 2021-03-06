import java.util.ArrayList;


public class OrderDoesMatter
{
	public int getOrder(int[] N, int[] M)
	{
        ArrayList<Integer> a=new ArrayList<Integer>();
        ArrayList<Integer> b=new ArrayList<Integer>();
        a.add(N[0]);a.add(M[0]);    int k,c=0;     int l ;
        outer: for(int i=1;i<N.length;i++)
        {

            for(int j=1;j<M.length;j++)
            {
                k=a.indexOf(N[i]);   l=a.indexOf(M[i]);
                if(l!=-1)
                {
               if(k!=-1 && l!=-1)
               {
                   if(M[i]<N[i])
                   {
                       a.remove(l); b.add(M[i]);
                       a.add(l,N[i]);c++;   continue outer;
                   }
                   else{
                       a.remove(k); b.add(N[i]);
                       a.add(k,M[i]);c++;   continue outer;
                   }
               }
               else if(l!=-1)
               {
                   a.remove(l); b.add(M[i]);
                   a.add(l,N[i]);c++;   continue outer;
               }

                }
                else if(k!=-1)
                {
                   System.out.println(a.get(k));
                     a.remove(k); b.add(N[i]);
                   a.add(k,M[i]);c++;   continue outer;
               }
                else{
                   if(M[i]==N[i])
                   {
                  if(b.indexOf(N[i])!=-1)
                  {
                      c++;
                  }
                   }
               }
            }
        }
        System.out.println(a.get(1));
        if(c<N.length-1)
            return -1;
        else
            return a.get(0)*a.get(1);
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, boolean hasAnswer, int p2) {
		System.out.print("Test " + testNum + ": [" + "{");
		for (int i = 0; p0.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p0[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p1[i]);
		}
		System.out.print("}");
		System.out.println("]");
		OrderDoesMatter obj;
		int answer;
		obj = new OrderDoesMatter();
		long startTime = System.currentTimeMillis();
		answer = obj.getOrder(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p2);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p2;
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
		int[] p1;
		int p2;
		
		// ----- test 0 -----
		p0 = new int[]{7,3,3};
		p1 = new int[]{3,7,3};
		p2 = 49;
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		p1 = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 1};
		p2 = 81;
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{3,5,5};
		p1 = new int[]{5,2,4};
		p2 = -1;
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{1, 3, 1, 4};
		p1 = new int[] {2, 4, 3, 2};
		p2 = -1;
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		p1 = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		p2 = 1;
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Matrices are a common object in mathematics. A NxM matrix is basically a table with N rows of M values each. Given two matrices, one of size AxB and another of size CxD, the following multiplication rules apply:
	// 
	//  You can only multiply them if B is equal to C. 
	//  The resultant matrix is of size AxD. 
	// 
	// The number of elements in an AxB matrix is A multiplied by B. For example, a 3x7 matrix has 21 elements.
	// Given a list of matrices, determine if there's an ordering that allows you to multiply all of them. If multiple such orderings exist, choose the one where the result has the most elements. Return the number of elements in the result, or -1 if there is no valid ordering (see examples 0-3 for further clarification). The list of matrices is given as two int[]s, N and M, where the ith elements of N and M represent the number of rows and columns respectively of the ith matrix.
	// 
	// DEFINITION
	// Class:OrderDoesMatter
	// Method:getOrder
	// Parameters:int[], int[]
	// Returns:int
	// Method signature:int getOrder(int[] N, int[] M)
	// 
	// 
	// NOTES
	// -The association order is not important because we are only interested in the dimensions of the matrices.
	// 
	// 
	// CONSTRAINTS
	// -M will have between 1 and 50 elements, inclusive.
	// -N and M will have the same number of elements.
	// -Each element of N and M will be between 1 and 1000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {7,3,3}
	// {3,7,3}
	// 
	// Returns: 49
	// 
	// Here we can legally multiply all the matrices in three different ways:
	// (3x3)*(3x7)*(7x3) = (3x3) (elements = 9)
	// (3x7)*(7x3)*(3x3) = (3x3) (elements = 9)
	// (7x3)*(3x3)*(3x7) = (7x7) (elements = 49)
	// The maximum number of elements is then 49.
	// 
	// 1)
	// {3,5,5}
	// {5,1,5}
	// 
	// Returns: 3
	// 
	// There's only one legal way to multiply the matrices (3x5)*(5x5)*(5x1)=(3x1) so the answer is 3*1=3.
	// 
	// 2)
	// {3,5,5}
	// {5,2,4}
	// 
	// Returns: -1
	// 
	// There is no legal way to multiply the matrices.
	// 
	// 3)
	// {5,2,3}
	// {2,5,3}
	// 
	// Returns: -1
	// 
	// Again, no legal way to multiply them all.
	// 
	// 4)
	// {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	// {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
	// 
	// Returns: 1
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
