package Problem3;

public class Bishop extends Piece {
	
	public Bishop() {
		super();
	}
	
	@Override
	public boolean isLegalMove(Position a, Position b) {
		return Math.abs(a.x - b.x) == Math.abs(a.y - b.y);
	}
	@Override
	public String toString() {
		return "This is bishop";
	}

}
