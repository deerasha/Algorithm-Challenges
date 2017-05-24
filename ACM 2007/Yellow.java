/*import java.util.*;

public class Yellow {

	public static Vector genRabbit(int maxSize) {
		Vector values = new Vector();
		if (maxSize == 1) {
			values.addElement(1);
			return values;
		} else {
			values.addElement(1);
			values.addElement(1);

			int j = 2;
			do {

				values.addElement(Integer
						.parseInt(values.elementAt(j - 1) + "")
						+ Integer.parseInt(values.elementAt(j - 2) + ""));
				j++;
			} while (Integer.parseInt(values.elementAt(j - 1) + "") < maxSize);
		}
		return values;
	}

	public static Vector genRat(int maxSize) {
		Vector values = new Vector();
		if (maxSize == 1) {
			values.addElement(1);
			return values;
		} else {
			values.addElement(1);
			values.addElement(1);

			int j = 2;
			do {

				values.addElement(
						 Integer.parseInt(values.elementAt(j - 1) + "")
						+ 2*Integer.parseInt(values.elementAt(j - 2) + ""));
				j++;
			} while (Integer.parseInt(values.elementAt(j - 1) + "") < maxSize);
		}
		return values;
	}

	public static Vector genPlus(int maxSize) {
		Vector values = new Vector();
		Vector Rat = genRat(maxSize);
		Vector Rab = genRabbit(maxSize);
		int j = 0;
		do {
			values.addElement(Integer.parseInt(Rat.elementAt(j) + "")
					+ Integer.parseInt(Rab.elementAt(j) + ""));
			j++;
		} while (Integer.parseInt(values.elementAt(j - 1) + "") < maxSize);

		return values;
	}

	public static boolean inSeq(int val, Vector seq) {
		int k = 0;
		while (k < seq.size()) {
			if (Integer.parseInt(seq.elementAt(k) + "") == val) {
				return true;
			}
			k++;

		}

		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Vector input = new Vector();
		int size = in.nextInt();
		while (size > 0) {
			input.addElement(size);
			size = in.nextInt();
		}

		int max = Integer.parseInt(input.elementAt(0) + "");
		for (int J = 1; J < input.size(); J++) {
			if (Integer.parseInt(input.elementAt(J) + "") > max)
				max = Integer.parseInt(input.elementAt(J) + "");
		}

		Vector rat = genRat(max);
		Vector rab = genRabbit(max);
		Vector plus = genPlus(max);

		boolean display;
		String output;
		for (int J = 0; J < input.size(); J++) {
			display = false;
			output = input.elementAt(J) + " : ";
			if (inSeq(Integer.parseInt(input.elementAt(J) + ""), rat)) {
				display = true;
				output += "rat";
			}
			if (inSeq(Integer.parseInt(input.elementAt(J) + ""), rab)) {
				if (display) {
					output += ", rabbit";
				} else {
					display = true;
					output += "rabbit";
				}
			}
			if (inSeq(Integer.parseInt(input.elementAt(J) + ""), plus)) {
				if (display) {
					output += ", rat+rabbit";
				} else {
					display = true;
					output += "rat+rabbit";
				}
			}
			if (display) {
				System.out.println(output);
			}
		}
	
	}

}*/
