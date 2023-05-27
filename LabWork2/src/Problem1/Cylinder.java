package Problem1;

import java.util.Objects;

public class Cylinder extends Shape {
	
	private double radius;
	private double height;
	
	public Cylinder() {
		this.height = 0;
		this.radius = 0;
	}
	
	public Cylinder(double radius, double height, Color color) {
		super(color, "▯" );
		this.radius = radius;
		this.height = height;
	}
	
	public Double getRadius() {
		return radius;
	}

	public void setRadius(Double radius) {
		this.radius = radius;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public double volume() {
		return Math.PI * Math.pow(radius, 2) * height;
	}

	@Override
	public double surfaceArea() {
		return 2 * Math.PI * radius * (height + radius);		
	}
	@Override
	public String toString() {
		return ("Color of cylinder " + super.getColor() + super.toString());
	}
	@Override 
	public boolean equals(Object o) {
		  if (o == this) return true;
		  if (o == null) return false;
		  if (o.getClass() != this.getClass()) return false;
		  Cylinder a = (Cylinder)o;
		  return this.radius == a.radius && this.height == a.height;
	}
	public int hashCode() {
		return Objects.hash(radius, height, super.getColor(), super.getSymbol());
	}
}