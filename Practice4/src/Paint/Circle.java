package Paint;

public class Circle extends Shape {
	private double radius;
	private String symbol = "◯";
	
	public Circle(Color color, int pos, double radius) {
		super(color, pos);
		this.radius = radius;
	}

	@Override
	public void draw() {
		if (super.getColor() == Color.BLACK)
			System.out.println(locate(symbol));
		else if (super.getColor() == Color.RED)
			System.err.println(locate(symbol));
	}
	
	public void draw(int n) {
		for (int i = 0; i < n; i++) 
			draw();
	}
	
	double getRadius() {
		return radius;
	}
}

