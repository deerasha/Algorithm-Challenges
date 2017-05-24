/*
 * Created on Apr 18, 2007
 *
 */
import java.io.*;
import java.util.Vector;

public class RingRosesVectorClockwiseFrom1 {
	public static void main(String args[]) throws IOException{
		
		//debug
		boolean debug = true;
		
		Vector friends;
		int n=0;
		int w=0;

		
		//Input
		BufferedReader in = new BufferedReader
		(new InputStreamReader(System.in));
		
//		System.out.print("Enter number of friends> ");
//		n= Integer.valueOf(in.readLine().trim()).intValue();
		if (debug){
			n=5;
			w=4;
		}
//		System.out.print("Enter number of words in rhyme> ");		
//		w = Integer.valueOf(in.readLine().trim()).intValue();
		
		System.out.println();
		//end Input
		
		//Initialise Vector to start playing
		friends = new Vector();
		for (int j = 0; j < n; j++) {
			friends.add(j,(""+(j+1)));
		}	
			//debug
			if (debug) {
				System.out.println(friends.toString());
			}//end debug
		

		int left = n;
		int j = 0;
		int k = 1;
		int p = 0;
		
		while (left > 1) {
			//debug
			if (debug){
				System.out.println("j: " +j);
			}//end debug
				if (k == w) {
					
					System.out.println((j+1) + " is out!");
					
					left--;
					if (j == p) {
						p++;
						
					}
					
					friends.remove(j);
					
					//debug
					if (debug) {
						System.out.println(friends.toString());
						System.out.println("left: " + left);
					}//end debug
					
				}
				
				k++;
				if (k > w) {
					k = 1;
				}
			
				j++;

				if ((j > (friends.size()-1)) && (left > 1)) {
					j = p;
				
				}
		}
		//debug
		if (debug) {
			//for (int i = 0; i < n; i++) {
				System.out.println(friends.toString() + "  ");
			//}
		}//end debug

		//Output
		System.out.println();
		System.out.println("Number of friends: "+n);
		System.out.println("Words in rhyme: "+w);
		System.out.println();
		
		//for (int i = 0; i < n; i++) {
			//if (friends[i] == 0) {
				System.out.println(friends.toString() + " is left");
			//}
		//}
		
		//end Output
	}
}
