package Problem3;

public class King extends Piece{
	public King() {
		super();
	}
	public King(Position a, Color color) {
		super(a, color);
	}
	
	@Override
	public boolean isLegalMove(Position b) {
		return a.checkPosition() && b.checkPosition() && Math.abs(a.xx() - b.xx()) <= 1 && Math.abs(a.yy() - b.yy()) <= 1;
	}
	@Override
	public String toString() {
		if(color == Color.WHITE) {
			return "♔";
		}
		return "♚";
	}

}
