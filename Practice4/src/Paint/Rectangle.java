package Paint;

public class Rectangle extends Shape{
	private String symbol = "▯";
	
	public Rectangle(Color color, int pos) {
		super(color, pos);
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
	
}