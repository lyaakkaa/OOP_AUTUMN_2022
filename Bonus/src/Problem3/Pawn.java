package Problem3;

public class Pawn extends Piece{
	
	public Pawn() {
		super();
	}
	
	@Override
	public boolean isLegalMove(Position a, Position b) {
		return a.checkPosition() && b.checkPosition() &&  a.y >= 2 && a.x == b.x && b.y - a.y <= 2 && b.y - a.y >= 1;
	}
	@Override
	public String toString() {
		return "This is pawn";
	}
}
