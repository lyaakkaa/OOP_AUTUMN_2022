package Paint;

public abstract class Shape {
	private Color color;
	private int pos;
	
	public Shape() {}
	
	public Shape(Color color, int pos) {
		this.color = color;
		this.pos = pos;
	}
	
	
	public abstract void draw();
	
	public Color getColor() {
		return this.color;
	}
	
	
	public String locate(String symbol) {
		String s = "";
		for (int i = 0; i < this.pos; i++)
			s += " ";
		return s + symbol;
	}
}
