package Problem3;

import java.util.Objects;

public abstract class Piece {
	Position a;
	Color color;
	
	Piece(){};
	
	Piece(Position a, Color color){
		this.a = a;
		this.color = color;
	}
	
	public abstract boolean isLegalMove (Position b);
	
	
	public abstract String toString();
	
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		Piece p = (Piece)o;
		return this.a == p.a && this.color == p.color;
	}
	
	public int hashCode() {
		return Objects.hash(a, color);
	}
	
}
