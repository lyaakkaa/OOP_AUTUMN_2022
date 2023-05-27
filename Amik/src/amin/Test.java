package amin;

import java.util.HashSet;
public class Test {
	public static void main( String args[]) {
		HashSet<Technology> technology = new HashSet <Technology>();
		Technology t1 = new Fridge(1000, 2019, Brand.SAMSUNG, true, -20);
		Technology t2 = new Fridge(2000, 2019, Brand.APPLE, false, -20);
		Technology t3 = new Fridge(1000, 2019, Brand.SAMSUNG, true, -20);
		technology.add(t1);
		technology.add(t2);
		technology.add(t3);
		
		for(Technology t : technology) {
			 if (t instanceof Fridge) {
				  Fridge f = (Fridge)t;
				  System.out.println(f.sale());
				  
			 }
			 else {
				 Technology j = (Technology)t;
				 System.out.println(j);
				 System.out.println(j.sale());
			 }
			
		}
		
	}

}
