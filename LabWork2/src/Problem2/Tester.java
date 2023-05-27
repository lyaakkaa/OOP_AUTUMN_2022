package Problem2;

import java.util.HashSet;

public class Tester {

	public static void main(String[] args) {
		 HashSet<Apple> appleProd = new HashSet<Apple>();
		
		 Apple a1 = new Iphone(AppleColor.BLACK, 256, "rus", 600, false, 150);
		 Apple a2 = new MacBook(AppleColor.GOLD, 512, "kz", 900, true, 1200);
		 Apple a4 = new MacBook(AppleColor.GOLD, 512, "kz", 900, true, 1200);
		 Apple a3 = new Iphone(AppleColor.BLACK, 256, "rus", 600, false, 150);
		 appleProd.add(a1);
		 appleProd.add(a2);
		 appleProd.add(a3);
		 appleProd.add(a4);
//		 System.out.println(a1.hashCode());
//		 System.out.println(a2.hashCode());
//		 System.out.println(a3.hashCode());
//		 System.out.println(a4.hashCode());
		 for(Apple a : appleProd) {
			 if (a instanceof Iphone) {
				  Iphone i = (Iphone)a;
				  System.out.println(i);
				  System.out.println(i.call());
			 }
			 else if(a instanceof MacBook) {
				 MacBook m = (MacBook)a;
				 System.out.println(m);
				 System.out.println(m.photoBooth());
			 }
		 }
		 
//		 for(Apple a : appleProd) {
//			 System.out.println(a.hashCode());
//		 }
		

	}

}
