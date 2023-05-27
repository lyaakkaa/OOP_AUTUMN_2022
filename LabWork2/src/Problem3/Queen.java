package Problem3;

public class Queen extends Piece {
	public Queen() {
		super();
	}
	public Queen(Position a, Color color) {
		super(a, color);
	}
	@Override
	public boolean isLegalMove(Position b) {
		return a.checkPosition() && b.checkPosition() && (new Rook(a, super.color).isLegalMove(b) || new Bishop(a, super.color).isLegalMove(b));
	}
	@Override
	public String toString() {
		if(color == Color.WHITE) {
			return "♕";
		}
		return "♛";
	}

}
