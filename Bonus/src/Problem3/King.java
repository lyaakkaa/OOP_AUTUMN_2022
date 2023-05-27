package Problem3;

public class King extends Piece{
	public King() {
		super();
	}
	@Override
	public boolean isLegalMove(Position a, Position b) {
		return a.checkPosition() && b.checkPosition() && Math.abs(a.x - b.x) <= 1 && Math.abs(a.y - b.y) <= 1;
	}
	@Override
	public String toString() {
		return "This is king";
	}

}
