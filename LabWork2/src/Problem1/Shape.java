package Problem1;

import java.util.Objects;

public abstract class Shape {
	
	private Color color;
	private String symbol;
	
	
	public Shape() {}
	
	public Shape(Color color, String symbol) {
		this.color = color;
		this.symbol = symbol;
	}
	
	public abstract double volume();
	public abstract double surfaceArea();
	

	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSymbol() {
		return this.symbol;
	}
	public final String draw(int n) {
		String s = "";
		for (int i = 0; i < n; i++)
			s += this.symbol;
		return s;
	}
	
	public String toString() {
		return "\nVolume: " + this.volume() + "\nSurface area " + this.surfaceArea() + "\n";
	}
	
	public boolean equals(Object o) {
		  if (o == this) return true;
		  if (o == null) return false;
		  if (o.getClass() != this.getClass()) return false;
		  Shape a = (Shape)o;
		  return this.color == a.color && this.symbol == a.symbol;
	}
	public int hashCode() {
		return Objects.hash(color, symbol);
	}
	
}

