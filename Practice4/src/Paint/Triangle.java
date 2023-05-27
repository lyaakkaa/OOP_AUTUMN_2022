package Paint;


public class Triangle extends Shape {
	
	private String symbol = "△";
	
	public Triangle(Color color, int pos) {
		super(color, pos);
	}

	@Override
	
	public void draw() {
		if (super.getColor() == Color.BLACK)
			System.out.println(locate(symbol));
		else if (super.getColor() == Color.RED)
			System.err.println(locate(symbol));
	}
	
	void draw(int n) {
		for (int i = 0; i < n; i++) 
			draw();
	}
}