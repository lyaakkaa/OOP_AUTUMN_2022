package Problem5;

public class Series extends Circuit{
	private Circuit r1;
	private Circuit r2;
	
	public Series() {};

	public Series(Circuit r1, Circuit r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
	
	@Override
	public double getResistance() {
		return r1.getResistance() + r2.getResistance();
	}
	
	@Override
	public double getPotentialDiff() {
		return r1.getCurrent() * r1.getResistance() + r2.getCurrent() * r2.getResistance();
	}
	
	@Override
	public void applyPotentialDiff(double V) {
		double current = V / getResistance();
		r1.applyPotentialDiff(current * r1.getResistance());
		r2.applyPotentialDiff(current * r2.getResistance());
	}
}
