package figure;

import java.util.Vector;

public class Player {
	Vector <Piece> pieces;
	private Player enemy;
	private King king;
	private Color color;
	
	public Player(Color color) {
		this.color = color;
		pieces = new Vector<Piece>(16);
	}
	public Color getColor() {
		return this.color;
	}
	public Player getEnemy() {
		return this.enemy;
	}
	public void addPiece(Piece p) {
		pieces.add(p);
	}
	public Vector<Piece> getPieces(){
		return this.pieces;
	}
	public void setEnemy(Player enemy) {
		this.enemy = enemy;
	}
	public void setKing(King king) {
		this.king = king;
	}
	public King getKing() {
		return king; 
	}

}
