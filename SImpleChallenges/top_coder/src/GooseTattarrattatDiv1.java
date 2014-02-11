import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;


public class GooseTattarrattatDiv1 {

    public int getmin(String S) {
        Stack<Integer> stack = new Stack<Integer>();
        int l = S.length();
        ArrayList<Integer> a[] = new ArrayList[l];
        int visited[] = new int[l];
        int count[];
        for (int i = 0; i < l; i++) {

            a[i] = new ArrayList<Integer>();
            a[i].add(l - 1 - i);
            for (int j = 0; j < l; j++) {
                if (S.charAt(i) == S.charAt(j)) {
                    a[i].add(j);
                }
            }
        }
        int linker;
        int ans=0;
        for (int i = 0; i < l; i++) {
            count = new int[26];
            int max=Integer.MIN_VALUE;
            int sum_lettersinagroup=0;
            if (visited[i] != 1) {
                stack.push(i);
                count[S.charAt(i)-'a'] ++;
                visited[i] = 1;
                while (!stack.isEmpty()) {
                    linker = stack.pop();


                    for (int j = 0; j < a[linker].size(); j++) {
                        if (visited[a[linker].get(j)] != 1) {
                            visited[a[linker].get(j)] = 1;
                            count[S.charAt(a[linker].get(j)) - 'a']++;
                            stack.push(a[linker].get(j));

                        }
                    }
                }
                for(int k=0;k<26;k++)
                {
                       if(max<count[k])
                           max=count[k];
                    sum_lettersinagroup+=count[k];
                }
                ans+=sum_lettersinagroup-max;
            }
        }
        return ans;


    }

    // BEGIN KAWIGIEDIT TESTING
    // Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
    private static boolean KawigiEdit_RunTest(int testNum, String p0, boolean hasAnswer, int p1) {
        System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"");
        System.out.println("]");
        GooseTattarrattatDiv1 obj;
        int answer;
        obj = new GooseTattarrattatDiv1();
        long startTime = System.currentTimeMillis();
        answer = obj.getmin(p0);
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

        String p0;
        int p1;

        // ----- test 4 -----
        p0 = "abaabb";
        p1 = 3;
        all_right = KawigiEdit_RunTest(4, p0, true, p1) && all_right;
        // ------------------

        // ----- test 1 -----
        p0 = "tattarrattat";
        p1 = 0;
        all_right = KawigiEdit_RunTest(1, p0, true, p1) && all_right;
        // ------------------

        // ----- test 0 -----
        p0 = "geese";
        p1 = 2;
        all_right = KawigiEdit_RunTest(0, p0, true, p1) && all_right;
        // ------------------


        // ----- test 2 -----
        p0 = "xyyzzzxxx";
        p1 = 2;
        all_right = KawigiEdit_RunTest(2, p0, true, p1) && all_right;
        // ------------------

        // ----- test 3 -----
        p0 = "xrepayuyubctwtykrauccnquqfuqvccuaakylwlcjuyhyammag";
        p1 = 11;
        all_right = KawigiEdit_RunTest(3, p0, true, p1) && all_right;
        // ------------------

        if (all_right) {
            System.out.println("You're a stud (at least on the example cases)!");
        } else {
            System.out.println("Some of the test cases had errors.");
        }
    }
    // PROBLEM STATEMENT
    // Goose Tattarrattat has a String S of lowercase letters.
    // Tattarrattat wants to change her string into a palindrome: a string that reads the same forwards and backwards.
    // (For example, "racecar" is a palindrome.)
    //
    // She will do this in a series of steps.
    // In each step, Tattarrattat will choose two letters of the alphabet: X and Y.
    // She will then change each X in her string into a Y.
    // Changing each single character takes 1 second.
    //
    // For example, if S="goose" and Tattarrattat chooses X='o' and Y='e' in the next step, the step will take 2 seconds (because there are two 'o's in S) and after the step she would have S="geese".
    //
    // You are given the String S.
    // Return the smallest number of seconds in which Tattarrattat can change S into a palindrome.
    //
    // DEFINITION
    // Class:GooseTattarrattatDiv1
    // Method:getmin
    // Parameters:String
    // Returns:int
    // Method signature:int getmin(String S)
    //
    //
    // NOTES
    // -Tattarrattat must always change all occurrences of the chosen letter into the other one; she is not allowed to change only some of the occurrences.
    //
    //
    // CONSTRAINTS
    // -S will contain between 1 and 50 characters, inclusive.
    // -Each character in S will be a lowercase letter ('a'-'z').
    //
    //
    // EXAMPLES
    //
    // 0)
    // "geese"
    //
    // Returns: 2
    //
    // There are many ways how Tattarrattat can change this S into a palindrome.
    // For example, she could do it in two steps as follows:
    //
    // Change all 'g's to 'e's: this takes 1 second and produces the string "eeese".
    // Change all 'e's to 's's: this takes 4 seconds and produces the string "sssss".
    //
    // This way took her 1+4 = 5 seconds.
    // However, there are faster ways.
    // The best one only takes 2 seconds.
    // For example, she can first change all 'g's to 'e's (1 second), and then change all 's's to 'e's (1 second), obtaining the palindrome "eeeee".
    //
    // 1)
    // "tattarrattat"
    //
    // Returns: 0
    //
    // This string is already a palindrome so no changes are needed.
    //
    // 2)
    // "xyyzzzxxx"
    //
    // Returns: 2
    //
    //
    //
    // 3)
    // "xrepayuyubctwtykrauccnquqfuqvccuaakylwlcjuyhyammag"
    //
    // Returns: 11
    //
    //
    //
    // 4)
    // "abaabb"
    //
    // Returns: 3
    //
    //
    //
    // END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
