package Problem5;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Circuit a = new Resistor(3.0);
//		Circuit b = new Resistor(3.0);
//		Circuit c = new Resistor(6.0);
//		Circuit d = new Resistor(3.0);
//		Circuit e = new Resistor(2.0);
//		Circuit f = new Parallel(a, b);
//		a.applyPotentialDiff(3);
//		b.applyPotentialDiff(4);
//		f.applyPotentialDiff(10);
//		Circuit g = new Parallel(c, d);
//		Circuit h = new Series(g, e);
//		Circuit circuit = new Parallel(h, f);
//		double R = circuit.getResistance();
//		System.out.println(a.getCurrent());
//		f.applyPotentialDiff(9);
//		System.out.println(a.getPotentialDiff());
		Circuit a = new Resistor(3.0);
		Circuit b = new Resistor(3.0);
		Circuit c = new Resistor(6.0);
		Circuit d = new Resistor(3.0);
		Circuit e = new Resistor(2.0);
		Circuit f = new Series(a, b);
		Circuit g = new Parallel(c, d);
		Circuit h = new Series(g, e);
		Circuit circuit = new Parallel(h, f);
		circuit.applyPotentialDiff(20);
		
		System.out.println(circuit.getPotentialDiff());
		System.out.println(h.getCurrent());
		double R = circuit.getResistance();
		System.out.println(R);
		

	}

}
