import java.util.Arrays;


public class SpaceWarDiv2
{
	public int minimalFatigue(int[] magicalGirlStrength, int[] enemyStrength, int[] enemyCount)
	{
		Arrays.sort(magicalGirlStrength);
        int l=magicalGirlStrength.length;
        int len=enemyStrength.length;
        int solve[]=new int[l]; int c=0; int sum=0;
        for(int i=0;i<l;i++)
        {

                for(int j=0;j<len;j++)
                {
                    if(enemyCount[j]==-1)
                        continue;
                    if(magicalGirlStrength[i]>=enemyStrength[j])
                    {    solve[i]+=enemyCount[j];
                        enemyCount[j]=-1;c++;
                    }
                }
            System.out.println(solve[i]);
            sum+=solve[i];
        }

            if(c<len)
                return -1;
        int max=0;int avg;


        for(int i=0;i<l;i++)
        {
           if(i!=0)
               sum-=solve[i-1];
           if( i!=l-1 )
           {
               avg=sum/(l-i);
               if(solve[i]>avg){
               solve[i+1]+=solve[i]-avg;
               solve[i]=avg;
                System.out.println(solve[i+1]+"at "+i);
               }
           }
            if(solve[i]>max)
                max=solve[i];
        }
        return max;
	}
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int[] p0, int[] p1, int[] p2, boolean hasAnswer, int p3) {
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
		System.out.print("}");
		System.out.println("]");
		SpaceWarDiv2 obj;
		int answer;
		obj = new SpaceWarDiv2();
		long startTime = System.currentTimeMillis();
		answer = obj.minimalFatigue(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + p3);
		}
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		if (hasAnswer) {
			res = answer == p3;
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
		int p3;
		
		// ----- test 0 -----
		p0 = new int[]{2,3,5};
		p1 = new int[]{1,3,4};
		p2 = new int[]{2,9,4};
		p3 = 7;
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = new int[]{1, 8, 5, 2, 10, 8, 2};
		p1 = new int[]{1, 7, 1, 1, 5, 3, 1};
		p2 = new int[]{20, 20, 20, 20, 20, 20, 20};
		p3 = 20;
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = new int[]{14,6,22};
		p1 = new int[]{8,33};
		p2 = new int[]{9,1};
		p3 = -1;
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = new int[]{17,10,29,48,92,60,80,100,15,69,36,43,70,14,88,12,14,29,9,40};
		p1 = new int[]{93,59,27,68,48,82,15,95,61,49,68,15,16,26,64,82,7,8,92,15};
		p2 = new int[]{56,26,12,52,5,19,93,36,69,61,68,66,55,28,49,55,63,57,33,45};
		p3 = 92;
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Magical Girls are girls who have magical powers.
	// They fight against evil to protect the Earth.
	// Cosmic enemies have just attacked the Earth, and the Magical Girls are going to fight them.
	// 
	// You are given a int[] magicalGirlStrength that describes the Magical Girls:
	// for each i, magicalGirlStrength[i] is the strength of one of the girls.
	// You are also given a int[] enemyStrength and a int[] enemyCount that describe their enemies:
	// for each i, there are enemyCount[i] enemies that each have strength enemyStrength[i].
	// 
	// Each Magical Girl will always fight one enemy at a time.
	// A Magical Girl will defeat her enemy if her strength is greater than or equal to the strength of that enemy.
	// 
	// At the beginning of the fight the fatigue of each Magical Girl is 0.
	// Each time a Magical Girl defeats an enemy, her fatigue increases by 1.
	// 
	// The Magical Girls want to defeat all the enemies.
	// That is, each of the enemies must be defeated by one of the Magical Girls.
	// Additionally, the Magical Girls want to minimize the maximum fatigue among them.
	// 
	// If it is impossible to defeat all of the enemies, return -1.
	// Otherwise, return the smallest F with the following property:
	// the Magical Girls can defeat all enemies in such a way that at the end the fatigue of each girl is at most F.
	// 
	// DEFINITION
	// Class:SpaceWarDiv2
	// Method:minimalFatigue
	// Parameters:int[], int[], int[]
	// Returns:int
	// Method signature:int minimalFatigue(int[] magicalGirlStrength, int[] enemyStrength, int[] enemyCount)
	// 
	// 
	// NOTES
	// -The elements of enemyStrength are not necessarily pairwise distinct.
	// 
	// 
	// CONSTRAINTS
	// -magicalGirlStrength will contain between 1 and 50 elements, inclusive.
	// -Each element of magicalGirlStrength will be between 1 and 100, inclusive.
	// -enemyStrength and enemyCount will each contain between 1 and 50 elements, inclusive.
	// -enemyStrength and enemyCount will contain the same number of elements.
	// -Each element of enemyStrength will be between 1 and 100, inclusive.
	// -Each element of enemyCount will be between 1 and 100, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// {2, 3, 5}
	// {1, 3, 4}
	// {2, 9, 4}
	// 
	// Returns: 7
	// 
	// There are 3 Magical Girls, their strength are 2, 3, and 5.
	// There are 3 kinds of enemies: 2 enemies with strength 1 each, 9 enemies with strength 3 each, and 4 enemies with strength 4 each. 
	// This is one of the ways how to minimize the maximal fatigue:
	// 
	// Magical girl 0 defeats 2 enemies with strength 1.
	// Magical girl 1 defeats 7 enemies with strength 3.
	// Magical girl 2 defeats 2 enemies with strength 3 and 4 enemies with strength 4.
	// 
	// 
	// 
	// 1)
	// {2, 3, 5}
	// {1, 1, 2}
	// {2, 9, 4}
	// 
	// Returns: 5
	// 
	// Each of the Magical Girls can defeat any of the enemies. The optimal strategy is that each girl should defeat 5 of the enemies.
	// 
	// 2)
	// {14, 6, 22}
	// {8, 33}
	// {9, 1}
	// 
	// Returns: -1
	// 
	// None of the magical girls can beat the enemy with strength 33.
	// 
	// 3)
	// {17, 10, 29, 48, 92, 60, 80, 100, 15, 69, 36, 43, 70, 14, 88, 12, 14, 29, 9, 40}
	// {93, 59, 27, 68, 48, 82, 15, 95, 61, 49, 68, 15, 16, 26, 64, 82, 7, 8, 92, 15}
	// {56, 26, 12, 52, 5, 19, 93, 36, 69, 61, 68, 66, 55, 28, 49, 55, 63, 57, 33, 45}
	// 
	// Returns: 92
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
