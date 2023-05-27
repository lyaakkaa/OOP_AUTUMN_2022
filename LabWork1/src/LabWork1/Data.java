package LabWork1;

public class Data {
	private static int cnt;
	private static double sum;
	private static double maxi;
	
	Data(){}
	
	public static void getSum(double num) {
		sum += num;
		cnt++;
	}
	
	public static double getAverage() {
		if(cnt == 0) return 0;
		return sum / cnt;
	}
	
	public static double findMaxi(double num) {
		if(num > maxi) {
			maxi = num;
		}
		return maxi;
	}	
	public String toString() {
		retutn "Average: " + getAverage()  + "."
	}
}
