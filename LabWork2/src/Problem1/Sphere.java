package Problem1;

public class Sphere extends Shape{
	private double radius;
	
	
	public Sphere() {
		this.radius = 0;
	}
	
	public Sphere(double radius, Color color) {
		super(color, "◯");
		this.radius = radius;
	}
	public double getRadius() {
		return this.radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double volume() {
		return 4 / 3 * Math.PI * Math.pow(radius, 3);
	}
	
	@Override
	public double surfaceArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public String toString() {
		return ("Color of sphere " + super.getColor() + super.toString());
	}
}
