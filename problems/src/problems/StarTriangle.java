package problems;

public class StarTriangle {

	int n;
	StarTriangle(int n){
		this.n = n;
	}
	String star = "";
	public void doIt() {
		int i = 0;
		while(i <= n){
	        System.out.println(star);
	        i++;
	        star += "[*]";
	    }
		
	}
   
}


