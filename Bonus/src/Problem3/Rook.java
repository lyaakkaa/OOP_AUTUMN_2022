package Problem3;

public class Rook extends Piece {
	public Rook() {
		super();
	}
	
	@Override
	public boolean isLegalMove(Position a, Position b) {
		return a.checkPosition() && b.checkPosition() && (a.x ==  b.x || a.y == b.y);
	}
	
	@Override
	public String toString() {
		return "This is rook";
	}

}
