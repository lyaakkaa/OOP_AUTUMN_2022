package Problem3;

public class Rook extends Piece{
	public Rook() {
		super();
	}
	public Rook(Position a, Color color) {
		super(a, color);
	}
	
	@Override
	public boolean isLegalMove(Position b) {
		return a.checkPosition() && b.checkPosition() && (a.xx() ==  b.xx() || a.yy() == b.yy());
	}
	
	@Override
	public String toString() {
		if(super.color == Color.BLACK) {
			return "♜";
		}
		return "♖";
	}

}
