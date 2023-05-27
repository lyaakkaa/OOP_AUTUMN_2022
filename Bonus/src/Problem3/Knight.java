package Problem3;

public class Knight extends Piece{
	public Knight() {
		super();
	}
	@Override
	public boolean isLegalMove(Position a, Position b) {
		return a.checkPosition() && b.checkPosition() &&  ((Math.abs(a.x - b.y) == 2 && Math.abs(a.y - b.y) == 1) || (Math.abs(a.x - b.x) == 1 && Math.abs(a.y - b.y) == 2));
	}
	@Override
	public String toString() {
		return "This is knight";
	}
}
