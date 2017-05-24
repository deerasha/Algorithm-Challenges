/*
 * Created on Mar 8, 2008
 */

import java.io.*;
import java.util.*;

public class Prog2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("Prog2.dat"));
		PrintWriter fout = new PrintWriter(new FileWriter("Prog2.out"));
		Scanner fin = new Scanner(br);
		//Note the digits must always be treated as double digits!!!	
		String line = fin.nextLine();
		while (!line.equals("##")) {
		
			Vector vrunways = new Vector();
			String [] runways = line.split(" ");
			for (int J = 0; J < runways.length; J++) {
				vrunways.add(runways[J]);
			}
			for (int J = 0; J < runways.length; J++) {
				int temp = ((Integer) vrunways.elementAt(J)).intValue();
				boolean add = true;
				for (int K = (J + 1); K < runways.length; K++) {
					if (temp < 180) {
						if ((temp + 180) == Integer.parseInt(runways[K]))
							add = false;
						else {
							if ((temp - 180) == Integer.parseInt(runways[K]))
								add = false;
						}
					}
					if (add) {
						if (temp > 180)
							vrunways.add((temp - 180)+"");
						else
							vrunways.add((temp + 180)+"");
					}
				}
			}
			line = fin.nextLine();
			String [] data = line.split(" ");
			int wind = Integer.parseInt(data[0]);
			int knots = Integer.parseInt(data[1]);
			line = fin.nextLine();
			while (line != "#") {
				String [] planeData = line.split(" ");
				int planeHeadLimit = Integer.parseInt(planeData[0]);
				int planeCrossLimit = Integer.parseInt(planeData[1]);
				//now call method to calculate stuffs
				line = fin.nextLine();
			}
		line = fin.nextLine();	

		}

		fin.close();
		fout.close();
	}
}
