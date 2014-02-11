public class IDNumberVerification
{
	public String verify(String id, String[] regionCodes)
	{
		  String region=id.substring(0,6);int len=regionCodes.length;int flag=0;
        int a[]=new int [17];

        for(int i=0;i<len;i++)
        {
            if(regionCodes[i].equals(region))
            {
                flag=1;
                break;
            }
        }
        System.out.print("here" + region);
        if(flag==0)
            return "Invalid";

        int year= Integer.parseInt(id.substring(6,10));
        if(!(year>=1900 && year<=2011))
            return "Invalid";
        int []days=new int[12];
        if(isleapyear(year)==0)
            days= new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        else
            days= new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month=Integer.parseInt(id.substring(10,12));
        if(!(month>0 && month<=12))
            return "Invalid";
        int date=Integer.parseInt(id.substring(12,14));
        if(!(date>0 && date<=days[month-1]) )
            return "Invalid";
        int gen=Integer.parseInt(id.substring(14,17));
        if(gen==0 )
            return "Invalid";
        String gender;
        if(gen%2==0)
            gender="Female";
        else
            gender="Male";
        long solve= (long) Math.pow(2,17); long sum=0;
        char m=   id.charAt(17);int last;
        if(m=='X')
            last=10;
        else
         last=Integer.parseInt(String.valueOf(m)) ;
        for(int i=0;i<17;i++)
        {
            a[i]=Integer.parseInt(String.valueOf(id.charAt(i))) ;
            sum+=a[i]*solve;
            solve/=2;
        }
        sum=(sum+last)%11;
        if(sum!=1)
            return "Invalid";
        else
            return gender;


	}
    int isleapyear(int year)
    {
        if((year%400==0)|| (year%4==0 && year%100!=0 ))
            return 1;
        else
            return 0;
    }
	
	// BEGIN KAWIGIEDIT TESTING
	// Generated by KawigiEdit 2.1.8 (beta) modified by pivanof
	private static boolean KawigiEdit_RunTest(int testNum, String p0, String[] p1, boolean hasAnswer, String p2) {
		System.out.print("Test " + testNum + ": [" + "\"" + p0 + "\"" + "," + "{");
		for (int i = 0; p1.length > i; ++i) {
			if (i > 0) {
				System.out.print(",");
			}
			System.out.print("\"" + p1[i] + "\"");
		}
		System.out.print("}");
		System.out.println("]");
		IDNumberVerification obj;
		String answer;
		obj = new IDNumberVerification();
		long startTime = System.currentTimeMillis();
		answer = obj.verify(p0, p1);
		long endTime = System.currentTimeMillis();
		boolean res;
		res = true;
		System.out.println("Time: " + (endTime - startTime) / 1000.0 + " seconds");
		if (hasAnswer) {
			System.out.println("Desired answer:");
			System.out.println("\t" + "\"" + p2 + "\"");
		}
		System.out.println("Your answer:");
		System.out.println("\t" + "\"" + answer + "\"");
		if (hasAnswer) {
			res = answer.equals(p2);
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
		String[] p1;
		String p2;
		
		// ----- test 0 -----
		p0 = "441323200312060636";
		p1 = new String[]{"441323"};
		p2 = "Male";
		all_right = KawigiEdit_RunTest(0, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 1 -----
		p0 = "62012319240507058X";
		p1 = new String[]{"620123"};
		p2 = "Female";
		all_right = KawigiEdit_RunTest(1, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 2 -----
		p0 = "321669197204300886";
		p1 = new String[]{"610111","659004"};
		p2 = "Invalid";
		all_right = KawigiEdit_RunTest(2, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 3 -----
		p0 = "230231198306900162";
		p1 = new String[]{"230231"};
		p2 = "Invalid";
		all_right = KawigiEdit_RunTest(3, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 4 -----
		p0 = "341400198407260005";
		p1 = new String[]{"341400"};
		p2 = "Invalid";
		all_right = KawigiEdit_RunTest(4, p0, p1, true, p2) && all_right;
		// ------------------
		
		// ----- test 5 -----
		p0 = "520381193206090891";
		p1 = new String[]{"532922","520381"};
		p2 = "Invalid";
		all_right = KawigiEdit_RunTest(5, p0, p1, true, p2) && all_right;
		// ------------------
		
		if (all_right) {
			System.out.println("You're a stud (at least on the example cases)!");
		} else {
			System.out.println("Some of the test cases had errors.");
		}
	}
	// PROBLEM STATEMENT
	// This problem statement contains superscripts and/or subscripts. These may not display properly outside the applet.
	// 
	// In People's Republic of China, every citizen has a unique ID string. The length of the ID is 18 characters. The first 17 characters (called the body code) are all digits, the last character (called the checksum code) can be either a digit or 'X'.
	// 
	// The body code is then divided into three parts: from left to right, these are the region code, the birthday code, and the sequential code. They look as follows:
	// 
	// 
	// The region code has 6 digits. Some 6-digit strings represent regions, other 6-digit strings are invalid. You are given the valid region codes as a String[] regionCodes.
	// The birthday code has 8 digits. It gives the citizen's birthday in the form YYYYMMDD. That is, the first 4 digits is the year of birth, the next 2 is the month (01 to 12, with a leading zero if necessary), and the last 2 digits is the day. When verifying the birthday code, you should consider leap years (see the Notes). Additionally, a valid birthday code must represent a date between Jan 1, 1900 and Dec 31, 2011, inclusive.
	// The sequential code has 3 digits. These 3 digits may be arbitrary, with one exception: the sequential code "000" is invalid. If the sequential code represents an odd number (e.g., "007"), the person is a male. Otherwise (e.g., "420") the person is a female.
	// 
	// 
	// The last character of an ID string is the checksum code. This is derived from the first 17 digits. Let a1, a2, ..., a17 denote the body code from left to right. Consider the following modular equation: x + a1*217 + a2*216 + a3*215 + ... + a16*22 + a17*21 = 1 (mod 11). This equation always has exactly one solution x such that 0 <= x <= 10. If x=10, the checksum code is 'X'. Otherwise, the checksum code is the corresponding digit. (E.g., if x=5, the checksum code is '5'.)
	// 
	// You are given a String id. If this is not a valid ID string, return "Invalid" (quotes for clarity). If id represents a valid ID string of a male citizen, return "Male". Finally, if id represents a valid ID string of a female citizen, return "Female".
	// 
	// DEFINITION
	// Class:IDNumberVerification
	// Method:verify
	// Parameters:String, String[]
	// Returns:String
	// Method signature:String verify(String id, String[] regionCodes)
	// 
	// 
	// NOTES
	// -A year is a leap year if and only if it satisfies one of the following two conditions: A: It is a multiple of 4, but not a multiple of 100. B: It is a multiple of 400. Therefore, 1904 and 2000 are leap years, while 1900 and 2011 are not.
	// 
	// 
	// CONSTRAINTS
	// -id will be 18 characters long.
	// -First 17 characters of id will be between '0' and '9', inclusive.
	// -Last character of id will be 'X' or between '0' and '9', inclusive.
	// -regionCodes will contain between 1 and 50 elements, inclusive.
	// -Each element of regionCodes will be 6 characters long.
	// -Each element of regionCodes will consist of characters between '0' and '9', inclusive.
	// -For each element of regionCodes, its first character will not be '0'.
	// -Elements of regionCodes will be pairwise distinct.
	// 
	// 
	// EXAMPLES
	// 
	// 0)
	// "441323200312060636"
	// {"441323"}
	// 
	// Returns: "Male"
	// 
	// As you can see, region code, birthday code and sequential code are all valid. So we just need to check the equation of checksum code:
	// 6 + 4*217 + 4*216 + 1*215 + 3*214 + 2*213 + 3*212 + 2*211 + 0*210 + 0*29 + 3*28 + 1*27 + 2*26 + 0*25 + 6*24 + 0*23 + 6*22 + 3*21 = 902276. It's easy to verify that 902276 mod 11 = 1. The sequential code ("063") is odd, thus this is a male.
	// 
	// 1)
	// "62012319240507058X"
	// {"620123"}
	// 
	// Returns: "Female"
	// 
	// 
	// 
	// 2)
	// "321669197204300886"
	// {"610111","659004"}
	// 
	// Returns: "Invalid"
	// 
	// Region code '321669' is invalid.
	// 
	// 3)
	// "230231198306900162"
	// {"230231"}
	// 
	// Returns: "Invalid"
	// 
	// Birthday code '19830690' is invalid.
	// 
	// 4)
	// "341400198407260005"
	// {"341400"}
	// 
	// Returns: "Invalid"
	// 
	// Sequential code '000' is invalid.
	// 
	// 5)
	// "520381193206090891"
	// {"532922","520381"}
	// 
	// Returns: "Invalid"
	// 
	// Checksum code is incorrect.
	// 
	// END KAWIGIEDIT TESTING
}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
