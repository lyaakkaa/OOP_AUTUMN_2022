package Problem5;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chocolate c1 = new Chocolate("Twix", 12);
		Chocolate c2 = new Chocolate("Mars", 10);
		Chocolate c3 = new Chocolate("Albeni", 11);
		Chocolate[] chocolates = new Chocolate[]{c1, c2, c3};
		Sort.bubbleSort(chocolates);
		for (Chocolate ch: chocolates) {
			System.out.println(ch);
		}
//		Sort.quickSort(chocolates,0, chocolates.length - 1);
//		for (Chocolate ch: chocolates) {
//			System.out.println(ch);
//		}
		
		CoolTime t1 = new CoolTime(12, 2, 3);
		CoolTime t2 = new CoolTime(11, 33, 2);
		CoolTime t3 = new CoolTime(11, 33, 1);
		CoolTime[] times = new CoolTime[] {t2, t1, t3};
		Sort.bubbleSort(times);
		for (CoolTime time: times) {
			System.out.println(time);
		}
	}
}
