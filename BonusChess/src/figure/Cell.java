package figure;


public class Cell {
	private int x;
	private int y;
	
	private Piece p;
	
	public int xx() {
		return x; 
	}
	
	public int yy() { 
		return y; 
	}
	public Cell(int row, int column) {
		this.x = column;
		this.y = row;
	}
	public Piece getPiece() {
		return this.p;
	}
	public void setPiece(Piece p) {
		this.p = p;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		Cell c = (Cell)o;
		return (this.x == c.x && this.y == c.y);
	}
}
