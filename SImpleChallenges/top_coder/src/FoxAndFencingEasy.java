import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class FoxAndFencingEasy
{
	public String WhoCanWin(int mov1, int mov2, int d)
	{
         if(mov1>=d)
             return "Ciel";
        if(mov1>2*mov2)
            return "Ciel";
        if(mov2>2*mov1)
              return "Liss";
        else
            return "Draw";

    }

    // BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, int p0, int p1, int p2, boolean hasAnswer, String p3) {
		System.out.print("Test " + testNum + ": [" + p0 + "," + p1 + "," + p2);
		System.out.println("]");
		FoxAndFencingEasy obj;
		String answer;
		obj = new FoxAndFencingEasy();
		long startTime = System.currentTimeMillis();
		answer = obj.WhoCanWin(p0, p1, p2);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p3 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p3);
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
		int p1;
		int p2;
		String p3;
		
		// ----- test 0 -----
		p0 = 1;
		p1 = 58;
		p2 = 1;
		p3 = "Ciel";
		all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = 100;
		p1 = 100;
		p2 = 100000000;
		p3 = "Draw";
		all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = 100;
		p1 = 150;
		p2 = 100000000;
		p3 = "Draw";
		all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = 100;
		p1 = 250;
		p2 = 100000000;
		p3 = "Liss";
		all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// Fox Ciel is playing a board game with her friend Squirrel Liss.
	// The game is played on an infinite strip of paper.
	// The strip of paper is divided into consecutive cells.
	// Each cell has an integer coordinate.
	// Formally, for each integer i, the left neighbor of cell i is cell (i-1) and the right neighbor of cell i is cell (i+1).
	// 
	// 
	// 
	// Each of the players has a single token called the fencer.
	// At the beginning of the game, Ciel's fencer is in cell 0 and Liss's fencer is in cell d.
	// Each of the fencers has a limit: its maximum move length.
	// For Ciel's fencer the maximum move length is mov1 and for Liss's fencer it is mov2.
	// 
	// 
	// 
	// The players take alternating turns.
	// Ciel goes first.
	// In each turn the current player moves her fencer.
	// The distance between the original cell and the destination cell must be at most equal to the fencer's maximum move length.
	// (It is also allowed to leave the fencer in the same cell.)
	// If the current player moves her fencer into the cell with the other fencer, the current player's fencer scores a hit and wins the game.
	// 
	// 
	// 
	// You are given the ints mov1, mov2, and d.
	// Return "Ciel" (quotes for clarity) if Fox Ciel has a winning strategy, "Liss" if Squirrel Liss has a winning strategy, and "Draw" otherwise.
	// 
	// DEFINITION
	// Class:FoxAndFencingEasy
	// Method:WhoCanWin
	// Parameters:int, int, int
	// Returns:String
	// Method signature:String WhoCanWin(int mov1, int mov2, int d)
	// 
	// 
	// CONSTRAINTS
	// -mov1 will be between 1 and 100,000,000, inclusive.
	// -mov2 will be between 1 and 100,000,000, inclusive.
	// -d will be between 1 and 100,000,000, inclusive.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// 1
	// 58
	// 1
	// 
	// Returns: "Ciel"
	// 
	// Ciel can win in her first turn by moving her fencer one cell to the right.
	// 
	// 
	// 1)
	// 100
	// 100
	// 100000000
	// 
	// Returns: "Draw"
	// 
	// Liss can avoid getting hit forever by repeating Ciel's moves. For example, whenever Ciel moves her fencer 47 cells to the right, Liss also moves her fencer 47 cells to the right. Ciel has a similar strategy: in her first turn she can move her fencer arbitrarily and in each of the following turns she will repeat Liss's previous move. Therefore the game ends in a draw.
	// 
	// 2)
	// 100
	// 150
	// 100000000
	// 
	// Returns: "Draw"
	// 
	// 
	// 
	// 3)
	// 100
	// 250
	// 100000000
	// 
	// Returns: "Liss"
	// 
	// 
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!