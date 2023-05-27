package Problem3;

import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Piece b = new Bishop();
//		Position a = new Position("c4");
//		Position c = new Position("d5");
//		System.out.println(a.x + " " + a.y);
//		System.out.println(c.x + " " + c.y);
//		
//		System.out.println(b.isLegalMove(new Position("c4"), new Position("d5")));
//		System.out.println(a.getPosition());
//		System.out.println(a.x);
		
		
		
		Position a = new Position("e4");
		Position b = new Position("e5");
		
		Piece pawn = new Pawn();
		Piece bishop = new Bishop();
		Piece knight = new Knight();
		Piece queen = new Queen();
		Piece king = new King();
		Piece rook = new Rook();
		
		Vector <Piece> p = new Vector <Piece>();
		p.add(pawn);
		p.add(bishop);
		p.add(knight);
		p.add(queen);
		p.add(king);
		p.add(rook);
		
		for(Piece piece : p) {
			System.out.print(piece + ", ");
			if(piece.isLegalMove(a, b)) System.out.println("it can move from " + a + " " + "to " + b);
			else System.out.println("it cant move from " + a + " " + "to " + b);
			
		}
	}

}
