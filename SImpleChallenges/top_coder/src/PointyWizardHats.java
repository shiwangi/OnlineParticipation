import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class PointyWizardHats
{
    int job_alloted[];   ArrayList<Integer> a[];
	public int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius)
	{
		 int l=topHeight.length;
        int m=bottomHeight.length;
       a=new ArrayList[l];
        for(int i=0;i<l;i++)
        {
            a[i]=new ArrayList<Integer>();
            for(int j=0;j<m;j++)
            {
                if ((topHeight[i]>(topRadius[i]*bottomHeight[j])/bottomRadius[j]) && bottomRadius[j]>topRadius[i]){
                    a[i].add(j);
                }

            }
        }
        job_alloted=new int[m];
        Arrays.fill(job_alloted,-1);
        int milgyi_naukri=0;
        for(int i=0;i<l;i++)
        {
            milgyi_naukri=0;
            for(int k=0;k<a[i].size();k++)
            {
                 if( job_alloted[a[i].get(k)]==-1)
                 {
                     job_alloted[a[i].get(k)]=i;
                     milgyi_naukri=1;
                     break;
                 }
            }
            if(milgyi_naukri==0)
            {
                for(int k=0;k<a[i].size();k++)
                {
                    int job_free_kro=a[i].get(k);
                    int swap_available=search_naukri(job_alloted[job_free_kro]);

                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++)
        {
            if(job_alloted[i]!=-1)
                count++;
        }
        return count;
    }

    private int search_naukri(int person) {
        int x;int personchange;
        for(int k=0;k<a[person].size();k++)
        {
            personchange=job_alloted[a[person].get(k)];
           if(personchange==-1) {
                   job_alloted[a[person].get(k)]=person;
                   return 0;
               }

           else {
               x=search_naukri(job_alloted[a[person].get(k)]);
               if(x!=-1)
                   return x;
           }
        }
        return -1;
         }

    // BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, int[] p3, boolean hasAnswer, int p4) {
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
		System.out.print("}" + "," + "{");
		for (int i = 0; p2.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p2[i]);
		}
		System.out.print("}" + "," + "{");
		for (int i = 0; p3.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print(p3[i]);
		}
		System.out.print("}");
		System.out.println("]");
		PointyWizardHats obj;
		int answer;
		obj = new PointyWizardHats();
		long startTime = System.currentTimeMillis();
		answer = obj.getNumHats(p0, p1, p2, p3);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p4);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p4;
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
		int[] p2;
		int[] p3;
		int p4;
        // ----- test 3 -----
        p0 = new int[]{10,10};
        p1 = new int[]{2,5};
        p2 = new int[]{2,9};
        p3 = new int[]{3,6};
        p4 = 2;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, p3, true, p4) && all_right;
        // ------------------
		// ----- test 0 -----
		p0 = new int[]{30};
		p1 = new int[]{3};
		p2 = new int[]{3};
		p3 = new int[]{30};
		p4 = 1;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{4,4};
		p1 = new int[]{4,3};
		p2 = new int[]{5,12};
		p3 = new int[]{5,4};
		p4 = 1;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{3};
		p1 = new int[]{3};
		p2 = new int[]{1,1};
		p3 = new int[]{2,4};
		p4 = 1;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		

		
		// ----- test 4 -----
		p0 = new int[]{3,4,5};
		p1 = new int[]{5,4,3};
		p2 = new int[]{3,4,5};
		p3 = new int[]{3,8,5};
		p4 = 2;
		all_right = KawigiEdit_RunTest(4, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = new int[]{1,2,3,4,5};
		p1 = new int[]{2,3,4,5,6};
		p2 = new int[]{2,3,4,5,6};
		p3 = new int[]{1,2,3,4,5};
		p4 = 0;
		all_right = KawigiEdit_RunTest(5, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 6 -----
		p0 = new int[]{123,214,232,323,342,343};
		p1 = new int[]{123,123,232,123,323,434};
		p2 = new int[]{545,322,123,545,777,999};
		p3 = new int[]{323,443,123,656,767,888};
		p4 = 5;
		all_right = KawigiEdit_RunTest(6, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		// ----- test 7 -----
		p0 = new int[]{999,999,999,10000,10000,10000};
		p1 = new int[]{10000,10000,10000,1,2,3};
		p2 = new int[]{2324,2323,234,5454,323,232};
		p3 = new int[]{1,2,3222,434,5454,23};
		p4 = 3;
		all_right = KawigiEdit_RunTest(7, p0, p1, p2, p3, true, p4) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// The Order of All Things Pointy and Magical has commissioned the creation of some new wizard hats. A wizard hat is created by taking two cones: a decorative top cone, and a warm and fluffy bottom cone. To assemble the hat, both cones are first placed onto a table, so that their bases are horizontal and their apexes point upwards. The top cone is then lifted and placed onto the bottom cone. The base of the top cone has to remain horizontal, and the apex of the top cone must be strictly above the apex of the bottom cone. 
	// 
	// Not every pair of cones can be used to create a wizard hat. A wizard hat is only produced if the following two criteria are both met:
	// 
	// The apex of the top cone must be strictly above the apex of the bottom cone. I.e., when the top cone is placed on top of the bottom cone and released, their apexes must not touch.
	// Some part of the bottom cone must remain visible to form the brim of the hat. (Otherwise, the hat would look like a simple cone, not like a wizard hat!)
	// 
	// 
	// You have several top cones and several bottom cones of various sizes. Each cone can be described by its height (the distance between the apex and the base) and by the radius of its base. The top cones you have are described by topHeight and topRadius: for each valid i, you have one top cone with height topHeight[i] and radius topRadius[i]. The bottom cones you have are described by bottomHeight and bottomRadius in the same way. 
	// 
	// Your task is to determine the maximum number of wizard hats you can make using each of the available top and bottom cones at most once.
	// 
	// DEFINITION
	// Class:PointyWizardHats
	// Method:getNumHats
	// Parameters:int[], int[], int[], int[]
	// Returns:int
	// Method signature:int getNumHats(int[] topHeight, int[] topRadius, int[] bottomHeight, int[] bottomRadius)
	// 
	// 
	// CONSTRAINTS
	// -topHeight and topRadius will contain the same number of elements.
	// -bottomHeight and bottomRadius will contain the same number of elements.
	// -topHeight will contain between 1 and 50 elements, inclusive.
	// -topRadius will contain between 1 and 50 elements, inclusive.
	// -bottomHeight will contain between 1 and 50 elements, inclusive.
	// -bottomRadius will contain between 1 and 50 elements, inclusive.
	// -Each element of topHeight, topRadius, bottomHeight, and bottomRadius will be between 1 and 10,000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {30}
	// {3}
	// {3}
	// {30}
	// 
	// Returns: 1
	// 
	// The top and bottom cone can be used together to make a wizard hat.
	// 
	// 1)
	// {4,4}
	// {4,3}
	// {5,12}
	// {5,4}
	// 
	// Returns: 1
	// 
	// The only way to produce a wizard hat is to use the top cone 1 (height 4, radius 3) and the bottom cone 0 (height 5, radius 5).
	// 
	// 2)
	// {3}
	// {3}
	// {1,1}
	// {2,4}
	// 
	// Returns: 1
	// 
	// 
	// 
	// 3)
	// {10,10}
	// {2,5}
	// {2,9}
	// {3,6}
	// 
	// Returns: 2
	// 
	// 
	// 
	// 4)
	// {3,4,5}
	// {5,4,3}
	// {3,4,5}
	// {3,8,5}
	// 
	// Returns: 2
	// 
	// 
	// 
	// 5)
	// {1,2,3,4,5}
	// {2,3,4,5,6}
	// {2,3,4,5,6}
	// {1,2,3,4,5}
	// 
	// Returns: 0
	// 
	// 
	// 
	// 6)
	// {123,214,232,323,342,343}
	// {123,123,232,123,323,434}
	// {545,322,123,545,777,999}
	// {323,443,123,656,767,888}
	// 
	// Returns: 5
	// 
	// 
	// 
	// 7)
	// {999,999,999,10000,10000,10000}
	// {10000,10000,10000,1,2,3}
	// {2324,2323,234,5454,323,232}
	// {1,2,3222,434,5454,23}
	// 
	// Returns: 3
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
