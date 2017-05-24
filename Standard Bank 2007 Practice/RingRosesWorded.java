/*
 * Created on 2007/04/17
 *  
 */

public class RingRosesWorded {
	public static void main(String args[]) {
		String[] friends;
		int n;//number of friends
		int w;//number of words

		//example- there is testdata in rosesdata.txt
		n = 6;
		w = 4;
		
		friends = new String[n];
		for (int j = 0; j < n; j++) {
			friends[j] = (j + 1) + " playing";
			System.out.println(friends[j] + "");
		}

		int left = n;
		int j = 0;
		int k = 0;
		int p = 0;
		while (left > 1) {
			if (friends[j].contains(" playing")) {
				k++;
				System.out.println("pointing to " + (j+1)+" on word " + (k));
				if (k == w) {
					k = 0;
					friends[j] = (j + 1) + " out";
					System.out.println(friends[j]);
					if (j==p){
						p++;
					}
					left--;
					System.out.println("left: " + left);
				}
			}//end if playing
			j++;
			if ((j > (n - 1)) && (left > 1)) {
				j=p;
			}	
		}//end while left
		
		for (int i = 0; i < n; i++) {
			System.out.println(friends[i]+ "");
		}
		
		for(int i=0;i<n;i++){
			if(friends[i].contains(" playing")){
				System.out.println((i+1)+" is left");
			}
		}
	}//end main
}//end class