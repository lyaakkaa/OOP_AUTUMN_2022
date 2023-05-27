package bonus;

import java.util.Vector;



public class Player {
	private Vector <Piece> pieces = new Vector<Piece>();
	private Vector <Piece> eatenPieces = new Vector<Piece>();
	
	private Player enemy;
	private King king;
	private Color color;
	
	public Player(Color color) {
		this.color = color;
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
	public Vector <Piece> getPieces(){
		return this.pieces;
	}
	public Vector <Piece> getEatenPieces(){
		return this.eatenPieces;
	}
	public void setEnemy(Player p) {
		this.enemy = p;
	}
	public void setKing(King king) {
		this.king = king;
	}
	public King getKing() {
		return this.king;
	}
	
	
}
