public class Stamp {
    public static int findMinLength(String s)
    {
        char last=s.charAt(0);
        int l=s.length();
        for(int i=0;i<l;i++)
        {

            if(s.charAt(i)==last)
            {

            }
        }
        return 0;
    }
    public int getMinimumCost(String desiredColor, int stampCost, int pushCost) {
       int l=findMinLength(desiredColor);
        System.out.println(l);
        return 0;
    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String p0, int p1, int p2, boolean hasAnswer, int p3) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + p1 + "," + p2);
        System.out.println("]");
        Stamp obj;
        int answer;
        obj = new Stamp();
        long startTime = System.currentTimeMillis();
        answer = obj.getMinimumCost(p0, p1, p2);
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

        String p0;
        int p1;
        int p2;
        int p3;

        // ----- test 0 -----
        p0 = "RRGGBB";
        p1 = 1;
        p2 = 1;
        p3 = 5;
        all_right = KawigiEdit_RunTest(0, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = "*";
        p1 = 987;
        p2 = 876;
        p3 = 1863;
        all_right = KawigiEdit_RunTest(1, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 2 -----
        p0 = "RR*GG*BB*RR*GG*BB*RR*GG*BB*RR*GG*BB*RR*GG*BB*RR*GG";
        p1 = 1;
        p2 = 100000;
        p3 = 2500002;
        all_right = KawigiEdit_RunTest(2, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = "R*RR*GG";
        p1 = 10;
        p2 = 58;
        p3 = 204;
        all_right = KawigiEdit_RunTest(3, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 4 -----
        p0 = "*B**B**B*BB*G*BBB**B**B*";
        p1 = 5;
        p2 = 2;
        p3 = 33;
        all_right = KawigiEdit_RunTest(4, p0, p1, p2, true, p3) && all_right;
        // ------------------

        // ----- test 5 -----
        p0 = "*R*RG*G*GR*RGG*G*GGR***RR*GG";
        p1 = 7;
        p2 = 1;
        p3 = 30;
        all_right = KawigiEdit_RunTest(5, p0, p1, p2, true, p3) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Little Fox Jiro has a rectangular board.
    // On the board there is a row of N unit cells.
    // The cells are numbered 0 through N-1 from the left to the right.
    // Initially, the cells are not colored.
    // Jiro must color each of the cells red, green, or blue.
    //
    // You are given a String desiredColor with N characters.
    // For each i, character i of desiredColor represents the color Jiro must use for cell i.
    // If a character is one of 'R' (as red), 'G' (as green), and 'B' (as blue), it means that Jiro must use that particular color.
    // If a character is '*', Jiro may use any of the three colors for the particular cell.
    //
    // You are also given the ints stampCost and pushCost that describe the cost of the coloring process.
    // The coloring process consists of two phases.
    // In the first phase, Jiro must pick a single stamp he will then use to color all the cells.
    // The length L of the stamp can be any integer between 1 and N, inclusive.
    // A stamp of length L costs L*stampCost.
    //
    // In the second phase, Jiro must repeatedly use the stamp to color the cells.
    // Each use of the stamp works as follows:
    //
    // Jiro picks one of the three colors and pushes the stamp into ink of the chosen color C.
    // Jiro picks a segment of L contiguous cells such that each of them is either uncolored or already has the color C.
    // The segment must be completely inside the board.
    // That is, the leftmost cell of the segment must be one of the cells 0 through N-L.
    // Jiro pushes the stamp onto the chosen segment of cells. All the cells now have color C.
    //
    // Each use of the stamp costs pushCost.
    //
    // Return the smallest possible total cost of coloring all the cells using the above process.
    //
    //
    // DEFINITION
    // Class:Stamp
    // Method:getMinimumCost
    // Parameters:String, int, int
    // Returns:int
    // Method signature:int getMinimumCost(String desiredColor, int stampCost, int pushCost)
    //
    //
    // CONSTRAINTS
    // -desiredColor will contain between 1 and 50 characters, inclusive.
    // -Each character of desiredColor will be either 'R' or 'G' or 'B' or '*'.
    // -stampCost will be between 1 and 100,000, inclusive.
    // -pushCost will be between 1 and 100,000, inclusive.
    //
    //
    // EXAMPLES
    //
    // 0)
    // "RRGGBB"
    // 1
    // 1
    //
    // Returns: 5
    //
    // The optimal solution is to choose L=2 and then stamp three times: using red color for cells [0,1], green for [2,3], and blue for [4,5].
    // The stamp costs 2*1 = 2, each of the three uses costs 1, so the total costs is 2*1 + 3*1 = 5.
    //
    // 1)
    // "R**GB*"
    // 1
    // 1
    //
    // Returns: 5
    //
    // The optimal solution is the same as in the previous example.
    // Note that you must color all the cells, so choosing L=1 and then using the stamp three times is not a valid solution.
    //
    // 2)
    // "BRRB"
    // 2
    // 7
    //
    // Returns: 30
    //
    // Also, note that once a cell is colored, you are not allowed to stamp over it using a different color.
    // Therefore, you can only choose L=1 in this case.
    //
    // 3)
    // "R*RR*GG"
    // 10
    // 58
    //
    // Returns: 204
    //
    // It is allowed to stamp the same cell multiple times if all of those stamps use the same color.
    //
    // 4)
    // "*B**B**B*BB*G*BBB**B**B*"
    // 5
    // 2
    //
    // Returns: 33
    //
    //
    //
    // 5)
    // "*R*RG*G*GR*RGG*G*GGR***RR*GG"
    // 7
    // 1
    //
    // Returns: 30
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
