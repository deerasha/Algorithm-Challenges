/*
 * Created on 2007/04/20
 *  
 */

public class RemovingDuplicates
{
	public static void main(String args[])
	{
		String c = "1123557777458118555";
		String sub = "";

		// this algo saves the final occurrence of the repeated character in c
		// to sub
		int p = 0;
		int q = 1;
		sub += c.charAt(0);
		while (p < c.length())
		{
			if (!(c.charAt(p) == c.charAt(q)))
			{
				q = p;
				sub += c.charAt(q);
			} else
			{
				p++;
			}
		}// end do...while

	}// end main
}// end class

