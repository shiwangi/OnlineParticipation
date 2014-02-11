public class ZigZag
{
	public int longestZigZag(int[] sequence)
	{
		    int totalp=1,totaln=1;
        for(int i=0;i<sequence.length-1;i++)
        {
            if(sequence[i]<sequence[i+1])
            {

            totalp=1+totaln;
            }
            if(sequence[i]>sequence[i+1])
            totaln=1+totalp;
        }
        return Math.max(totaln,totalp);

	}
	

}
//Powered by KawigiEdit 2.1.8 (beta) modified by pivanof!
