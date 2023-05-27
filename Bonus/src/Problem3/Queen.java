package Problem3;

public class Queen extends Piece {
	public Queen() {
		super();
	}
	
	@Override
	public boolean isLegalMove(Position a, Position b) {
		return a.checkPosition() && b.checkPosition() && (new Rook().isLegalMove(a, b) || new Bishop().isLegalMove(a, b));
	}
	@Override
	public String toString() {
		return "This is queen";
	}

}
