package Problem5;

public class Parallel extends Circuit {
	private Circuit r1;
	private Circuit r2;
	
	public Parallel() {};
	
	public Parallel(Circuit r1, Circuit r2) {
		this.r1 = r1;
		this.r2 = r2;
	}
	
	@Override
	public double getResistance() {
		double r1Res = r1.getResistance();
		double r2Res = r2.getResistance();
		return r1Res * r2Res / (r1Res + r2Res);
	}
	
	@Override
	public void applyPotentialDiff(double V) {
		r1.applyPotentialDiff(V);
		r2.applyPotentialDiff(V);
	}
	
	@Override
	public double getPotentialDiff() {
		return r1.getPotentialDiff();
	}
}
