/*
 * Created on 2007/04/17
 *  
 */
import java.io.*;
public class RingRoses {
	public static void main(String args[]) throws IOException{
		
		//debug
		boolean debug = false;
		
		int[] friends;
		int n;
		int w;

		
		//Input
		BufferedReader in = new BufferedReader
		(new InputStreamReader(System.in));
		
		System.out.print("Enter number of friends> ");
		n= Integer.valueOf(in.readLine().trim()).intValue();
		
		System.out.print("Enter number of words in rhyme> ");		
		w = Integer.valueOf(in.readLine().trim()).intValue();
		
		System.out.println();
		//end Input
		
		friends = new int[n];
		for (int j = 0; j < n; j++) {
			friends[j] = 0;
			//debug
			if (debug) {
				System.out.println(friends[j] + "  ");
			}//end debug
		}

		int left = n;
		int j = 0;
		int k = 0;
		int p = 0;
		while (left > 1) {
			if (friends[j] == 0) {
				k++;
				if (k == w) {
					friends[j] = 1;
					System.out.println((j+1) + " is out!");
					if (j == p) {
						p++;
					}
					k = 0;
					left--;
					//debug
					if (debug) {
						System.out.println("left: " + left);
					}//end debug
				}
			}//end pointing to a player
			j++;
			if ((j > (n - 1)) && (left > 1)) {
				j = p;
			}
		}//end while left
		
		//debug
		if (debug) {
			for (int i = 0; i < n; i++) {
				System.out.println(friends[i] + "  ");
			}
		}//end debug

		//Output
		System.out.println();
		System.out.println("Number of friends: "+n);
		System.out.println("Words in rhyme: "+w);
		System.out.println();
		
		for (int i = 0; i < n; i++) {
			if (friends[i] == 0) {
				System.out.println((i + 1) + " is left");
			}
		}
		//end Output
	}//end main
}//end class

