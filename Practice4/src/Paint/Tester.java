package Paint;
import java.util.*;
public class Tester {

	public static void main(String[] args) throws InterruptedException {
		Vector<Shape> shapes = new Vector<Shape>();
		shapes.add(new Circle(Color.RED, 3, 1.1));
		shapes.add(new Rectangle(Color.BLACK, 5));
		shapes.add(new Triangle(Color.RED, 10));
		
		for(Shape i : shapes) {
			i.draw();
//			if(i instanceof Circle) {
//				Circle c = (Circle)i;
//				System.out.print(c.getRadius());
//				System.out.println();
//			//	c.draw();
//				System.out.println();
//				c.draw(4);
//			}
//			else if (i instanceof Rectangle) {
//				Rectangle r = (Rectangle)i;
//				
//				//r.draw();
//				System.out.println();
//				
//				r.draw(5);
//				System.out.println();
//			}
//			else {
//				Triangle t = (Triangle)i;
//				//t.draw();
//				System.out.println();
//				
//				t.draw(5);
//				System.out.println();
//			}

		}
		
	
	}

}