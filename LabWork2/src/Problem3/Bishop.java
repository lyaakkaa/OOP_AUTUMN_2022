package Problem3;


public class Bishop extends Piece {
	public Bishop() {
		super();
	}
	public Bishop(Position a, Color color) {
		super(a, color);
	}
	
	@Override
	public boolean isLegalMove(Position b) {
		return a.checkPosition() && b.checkPosition() &&  Math.abs(a.xx() - b.xx()) == Math.abs(a.yy() - b.yy());
	}
	@Override
	public String toString() {
		if(color == Color.BLACK) {
			return "♝";
		}
		return "♗";
	}
}
