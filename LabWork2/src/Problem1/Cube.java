package Problem1;

public class Cube extends Shape {
	private double side;
	
	public Cube(){
		this.side = 0;
	}
	
	public Cube(double side, Color color){
		super(color, "□");
		this.side = side;
	}
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double volume() {
		return Math.pow(this.side, 3);
	}
	
	@Override
	public double surfaceArea() {
		return 6 * Math.pow(side, 2);
	}
	
	@Override
	public String toString() {
		return ("Color of cube " + super.getColor() + super.toString());
	}
	
	@Override
	public boolean equals(Object o) {
		  if(!super.equals(o)) return false;
		  Cube c = (Cube)o;
		  return this.side == c.side;
	}

}
