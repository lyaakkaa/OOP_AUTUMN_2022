package Problem3;

import java.util.Vector;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Position p = new Position("d4");
//		Position p1 = new Position("f4");
		//System.out.print(p);
		//Pawn pp = new Pawn(p, Color.BLACK);
		//System.out.println(pp.isLegalMove(p1));
		//System.out.println(pp);
//		Rook r = new Rook(p, Color.BLACK);
//		System.out.println(r.isLegalMove(p1));
//		System.out.println(r);
//		Bishop b = new Bishop(p, Color.WHITE);
//		System.out.println(b.isLegalMove(p1));
//		System.out.println(b);
//		Queen q = new Queen(p, Color.WHITE);
//		System.out.println(q.isLegalMove(p1));
//		Knight k = new Knight(p, Color.WHITE);
//		System.out.println(k.isLegalMove(p1));
//		King kk = new King(p, Color.WHITE);
//		System.out.println(kk.isLegalMove(p1));
		
		Position a = new Position("b2");
		Position b = new Position("b4");
		
		Piece pawn = new Pawn(a, Color.BLACK);
		Piece bishop = new Bishop(a, Color.WHITE);
		Piece knight = new Knight(a, Color.BLACK);
		Piece queen = new Queen(a, Color.WHITE);
		//Piece queen1 = new Queen(a, Color.WHITE);
		Piece king = new King(a, Color.WHITE);
		Piece rook = new Rook(a, Color.WHITE);
		//System.out.print(queen.equals(rook));
		
		Vector <Piece> p = new Vector <Piece>();
		p.add(pawn);
		p.add(bishop);
		p.add(knight);
		p.add(queen);
		p.add(king);
		p.add(rook);
//		
		for(Piece piece : p) {
			System.out.print(piece + ", ");
			if(piece.isLegalMove(b)) System.out.println("can move from " + a + " " + "to " + b);
			else System.out.println("cant move from " + a + " " + "to " + b);
			
		}
	}

}
