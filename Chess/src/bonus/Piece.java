package bonus;


public abstract class Piece {
	Color color;
	Piece(Color color){
		this.color = color;
	}
	
	public abstract boolean isLegalMove(Position a, Position b);
	public abstract String toString();

	
}
