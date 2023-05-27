package bonus;



public class Bishop extends Piece {
	
	Bishop(Color color){
		super(color);
	}

	public String getFigure(Color color) {
		if(color == Color.BLACK) {
			return "♝";
		}
		return "♗";
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
