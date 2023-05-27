package Problem2;

import java.util.Objects;

public class Iphone extends Apple {
	private boolean homeButton;
	private int rearCameraResolution;
	
	public Iphone() {
		super();
	}
	
	public Iphone(AppleColor color, int storage, String language, int price,boolean homeButton, int rearCameraResolution) {
		super(color, storage, language, price);
		this.homeButton = homeButton;
		this.rearCameraResolution = rearCameraResolution;
	}
	
	public boolean getHomeButton() {
		return this.homeButton;
	}
	
	public int getRearCameraResolution() {
		return this.rearCameraResolution;
	}
	
	public void setHomeButton(boolean homeButton) {
		this.homeButton = homeButton;
	}
	
	public void setRearCameraResolution(int rearCameraResolution) {
		this.rearCameraResolution = rearCameraResolution;
	}
	
	public String call() {
		return "Call a friend";
	}
	
	@Override 
	public String toBuy() {
		return "Yoohoo I bought an iPhone for " + super.getPrice() + "$";
	}
	
	@Override
	public boolean equals(Object o) {
		if(!super.equals(o)) return false;
		Iphone i = (Iphone)o;
		return this.homeButton == i.homeButton && this.rearCameraResolution == i.rearCameraResolution;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.getAppleColor(), super.getStorage(), super.getLanguage(), super.getPrice(), homeButton, rearCameraResolution);
	}
	
	@Override
	public String toString() {
		return super.toString() + " have home button? " + this.homeButton + " rear camera resolution: " + this.rearCameraResolution;
	}
}
