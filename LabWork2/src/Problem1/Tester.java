package Problem1;

import java.util.Vector;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector <Shape> shapes = new Vector<Shape>();
		
		shapes.add(new Cube(5, Color.GREEN));
		shapes.add(new Cylinder(5, 7, Color.BLACK));
		shapes.add(new Sphere(5, Color.RED));
		
		for (Shape shape: shapes) {
			System.out.println(shape);
			System.out.println("Side view: " + shape.draw(5) + "\n");
		}
	}

}