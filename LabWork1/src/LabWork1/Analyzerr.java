package LabWork1;
import java.util.*;

public class Analyzerr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double maxi = 0;

		//while(sc.hasNextDouble()){
			//String x;
			//x = sc.next();
			//Data.getSum(Double.parseDouble(x));
			//maxi = Data.findMaxi(Double.parseDouble(x));
		//}
		//System.out.println(Data.getAverage());
		//System.out.println(maxi);
		//sc.close();
		
		while(true) {
			String x;
			x = sc.next();
			if(x.equals("Q")) break;
			else {
				Data.getSum(Double.parseDouble(x));
				maxi = Data.findMaxi(Double.parseDouble(x));
			}
		}
		System.out.println(Data.getAverage());
		System.out.println(maxi);	
	}
}
