package Problem3;

public abstract class Piece {
	Piece(){}
	
	public abstract boolean isLegalMove(Position a, Position b);
	public abstract String toString();
}
