package bonus;



public class Cell {
	private int x;
	private int y;
	
	private Piece piece;
	public Cell(int r, int c) {
		this.y = r;
		this.x = c;
	}
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public Piece getPiece() {
		return this.piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	@Override
	public boolean equals(Object o) {
		
		if (!(o instanceof Cell)) return false;
		
		if (this.getX() == ((Cell) o).getX() && this.getY() == ((Cell) o).getY()) return true;
		
		return false;
	}
	
	
}
