import java.util.*;
public class PracticeA {
public static void main(String[]args){
	Scanner in = new Scanner(System.in);
	String name = in.nextLine();
	while (!name.equals("-")) {
		System.out.println("Hello "+name);
		name = in.nextLine();
	}
	
}
}
