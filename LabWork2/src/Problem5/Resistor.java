package Problem5;

public class Resistor extends Circuit{
	
	private double resistance;
	private double potentialDiff;

	public Resistor() {
		this.resistance = 0;
	}
	
	public Resistor(double resistance) {
		this.resistance = resistance;
	}
	
	@Override
	public double getResistance() {
		return resistance;
	}
	
	@Override
	public double getPotentialDiff() {
		return this.potentialDiff;
	}
	
	@Override
	public void applyPotentialDiff(double V) {
		this.potentialDiff = V;
	}
	
}
