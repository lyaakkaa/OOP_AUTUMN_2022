package Problem2;

import java.util.Objects;

public class MacBook extends Apple{
	private boolean luminousApple;
	private int screenDiagonal;
	
	public MacBook() {
		super();
	}
	public MacBook(AppleColor color, int storage, String language, int price,boolean luminousApple, int screenDiagonal) {
		super(color, storage, language, price);
		this.luminousApple = luminousApple;
		this.screenDiagonal = screenDiagonal;
	}
	
	public boolean getLuminousApple() {
		return this.luminousApple;
	}
	
	public int getScreenDiagonal() {
		return this.screenDiagonal;
	}
	
	public void setLuminousApple(boolean luminousApple) {
		this.luminousApple = luminousApple;
	}
	
	public void setScreenDiagonal(int screenDiagonal) {
		this.screenDiagonal = screenDiagonal;
	}
	
	public String photoBooth() {
		return "Let's go take a photo!";
	}
	
	@Override 
	public String toBuy() {
		return "Yoohoo I bought an MacBook for " + super.getPrice() + "$";
	}
	
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		MacBook m = (MacBook)o;
		return this.luminousApple == m.luminousApple && this.screenDiagonal == m.screenDiagonal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(super.getAppleColor(), super.getStorage(), super.getLanguage(), super.getPrice(), luminousApple, screenDiagonal );
	}
	
	@Override 
	public String toString() {
		return super.toString() + " have luminous apple? " + this.luminousApple + ", screen diagonal: " + this.screenDiagonal;
	}

}
