
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Created on 2007/04/17
 *  
 */

public class RingRosesC {
	public static void main(String args[]) throws IOException {

		//debug
		boolean debug = false;

		int[] friends;
		int n;
		int w = 3;//two is the trivial answer! 
		//2 puts all this good code to waste cos it will be w=2 for any group size!!! 

		int left;
		int j;
		int k;
		int p;

		int check1 = 0;
		int check2 = 0;

		//Input
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter number of friends> ");
		n = Integer.valueOf(in.readLine().trim()).intValue();

		//end Input

		friends = new int[n];

		System.out.println();
		System.out.println("Start with "+w+" words:");
		do {
			for (int i = 0; i < n; i++) {
				friends[i] = 0;
				//debug
				if (debug) {
					System.out.print(friends[i] + "  ");

				}//end debug
			}

			//clockwise
			left = n;
			k=0;
			j = 0;
			p = 0;
			System.out.println("Clockwise:");
			while (left > 1) {

				if (friends[j] == 0) {
					k++;
					if (k == w) {
						k = 0;
						friends[j] = 1;
						System.out.println((j + 1) + " is out!");
						j = -1;
						if (j == p) {
							p++;
						}
						left--;

						//debug
						if (debug) {
							for (int i = 0; i < n; i++) {
								System.out.print(friends[i] + " ");
							}
							System.out.println();
							System.out.println("left: " + left);
							System.out.println("j: " + j);
							System.out.println("k: " + k);
						}//end debug
					}
				}
				j++;
				if (debug) {
					System.out.println("j:" + j);
					System.out.println("k: " + k);
				}
				if ((j > (n - 1)) && (left > 1)) {
					j = p;
				}
			}//end clockwise

			//see check1
			for (int i = 0; i < n; i++) {
				if (friends[i] == 0) {
					System.out.println((i + 1) + " is left");
					check1 = i + 1;
				}
			}

			for (int i = 0; i < n; i++) {
				friends[i] = 0;
				//debug
				if (debug) {
					System.out.print(friends[i] + "  ");

				}//end debug
			}

			System.out.println();
			//counter clockwise
			left = n;
			j = 0;
			k = 1;
			p = n - 1;
			System.out.println("Counter clockwise: ");
			while (left > 1) {
				if (friends[j] == 0) {
					if (k == w) {
						friends[j] = 1;
						System.out.println((j + 1) + " is out!");
						if (j == p) {
							p--;
						}
						j = 1;
						left--;

						//debug
						if (debug) {
							for (int i = 0; i < n; i++) {
								System.out.print(friends[i] + " ");
							}
							System.out.println();
							System.out.println("left: " + left);
							System.out.println("j: " + j);
							System.out.println("k: " + k);
						}
						//end debug
					}

					k++;
					if (k > w) {
						k = 1;
					}
				}
				j--;
				//debug
				if (debug) {
					System.out.println("j: " + j);
					System.out.println("k: " + k);
				}//end debug

				if ((j < 0) && (left > 1)) {
					j = p;
				}
			}//end counter clockwise

			//see check 2
			for (int i = 0; i < n; i++) {
				if (friends[i] == 0) {
					System.out.println((i + 1) + " is left");
					System.out.println("end of try with "+w+" words.");
					System.out.println();
					check2 = i + 1;
				}
			}
			
			if (check1 != check2){
				w++;
				System.out.println("Trying "+w+" words...");
			}//Guard do.. while
		} while (check1 != check2);
		//Output
		System.out.println();
		System.out.println("Friend left: " + check1);
		System.out.println("Minimum number of words: " + w);
		//end Output

	}
}