import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

/*
 * Created on 2007/04/22
 */

 class LinkedVectors {

	public static void main(String args[]) throws IOException,FileNotFoundException, InterruptedException {

		boolean debug = false;
		int d1=-1;
		
		//Input Variables
		Vector names = new Vector();
		String in="";
		int count = 0; //count is num of elements not position in vector/array!
		
		//Calc Variables
	/**
	 * TODO Calc Variables go here 
	 */	
		//Output Variables
		Vector output = new Vector();

		//Init for Input
		BufferedReader fin = new BufferedReader(new
		 InputStreamReader(System.in));
		String filename="LinkedVects.txt";//add test input filename here
	  	
		try
	  	{
	  		fin = new BufferedReader(new FileReader(filename));
	  	}
	  	catch (FileNotFoundException e)
	  	{
	  		System.err.println();
	  		System.err.println("File " + filename + " does not exist.");
	  		System.err.println();
	  	}//end Init for input
		
		//Input
		//input many lists: while not ended by ## do...
		while (!(in.equals("##"))) {
			names.clear();
			//input a list: do...while until ended by #
			do {
				in = fin.readLine();//file input
				//debug
				if (debug) {
					System.out.println("in: " + in);
				}//end debug
				//guard for do...while
				if (!(in.equals("#")) && !(in.equals("##"))) {
					++count;
					names.add(in);
					//debug
					if (debug) {
						++d1;
						System.out.println("names : " + names.elementAt(d1)
								+ " at pos " + d1);
						System.out.println("count: " + count);
					}//end debug
				}//end guard for do...while

			} while (!(in.equals("#")) && !(in.equals("##"))); 
			//end input a list: do...while until ended by #

			//debug
			if (debug) {
				System.out.println("Final count: " + count
						+ " and contents of Vector names:");
				for (int k = 0; k < names.size(); k++) {
					System.out.println(names.elementAt(k));
				}
			}//end debug
			
			//put Calc-ed contents in output
			for (int k = 0; k < names.size(); k++) {
				output.add(names.elementAt(k));
			}

			if (!(in.equals("##"))) {
				output.add("#");//put separators back if necessary
			}
			
			//Calc
			/**
			 * TODO Calculation algorithm goes here
			 */
			//end Calc
			
		}//input many lists: while not ended by ## do...
		//end Input and Input debugging
			
		//Init for Calculation
			


		//Output
		//debug
		if (debug) {
			System.out.println("output size: " + output.size()
					+ " and output contents: ");
			for (int k = 0; k < output.size(); k++) {
				System.out.println("at pos " + k + ":"
						+ output.elementAt(k));
			}
		}//end debug
		
		for (int k = 0; k < output.size(); k++) {
			System.out.println(output.elementAt(k));
		}
		//end Output
		
		
		
		
	}//end main 
}//end class
	

