package bonus;

public class Position {
	int x;
	int y;
	
	public Position() {}
	
	public Position(String s) {
		this.x = Character.toUpperCase(s.charAt(0)) - 'A' + 1;
		this.y = s.charAt(1) - '0';
	}
	
	public boolean checkPosition() {
		if (this.y < 1 || this.y > 8 || this.x < 1 || this.x > 8) {
			return false;
		}
		return true;
	}
	
	public String toString() {
		return Character.toString((char)(x + 'A' - 1)) + (y);
	}
	
}
	