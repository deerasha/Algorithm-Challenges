import java.util.Scanner;
public class PracticeB {
public static void main(String[]args){
	Scanner in = new Scanner(System.in);
	String line = in.nextLine();
	while (line !=null && line.length() != 0) {
		
		int m=Integer.parseInt(line.substring(0, line.indexOf(' ')));
		int n=Integer.parseInt(line.substring(line.indexOf(' ')+1));
		int sum=0;
		for (int i=m+1; i<n; i++){
			sum+=i;
		}
		
		System.out.println(sum);
		line=in.nextLine();
		
	}
	
}
}
