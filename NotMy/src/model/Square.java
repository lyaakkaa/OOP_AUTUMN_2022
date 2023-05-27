package model;



public class Square{

	
	private int x;	
	private int y;	
	
	
	private ChessPiece piece; 
	
	public int getX() {
		return x; 
	}
	
	public int getY() {
		return y; 
	}
	
	public Square(int r, int c) {
		this.y = r;
		this.x = c;
	}
	
	public ChessPiece getPiece() { 
		return piece; 
	}
	
	public void setPiece(ChessPiece piece) {
		this.piece = piece;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null) return false;
		if(o.getClass() != this.getClass()) return false;
		Square s = (Square) o;
		return this.x == s.x && this.y == s.y;
	}
}