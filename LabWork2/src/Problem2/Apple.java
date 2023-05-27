package Problem2;

import java.util.Objects;

public abstract class Apple {
	private AppleColor color;
	private int storage;
	private String language;
	private int price;
	
	public Apple() {};
	
	public Apple(AppleColor color, int storage, String language, int price) {
		this.color = color;
		this.storage = storage;
		this.language = language;
		this.price = price;
	}
	public AppleColor getAppleColor() {
		return this.color;
	}
	public int getStorage() {
		return this.storage;
	}
	public String getLanguage() {
		return this.language;
	}
	public int getPrice() {
		return this.price;
	}
	public void setColor(AppleColor color) {
		this.color = color;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return "color: " + color + " storage: " + storage + " language: " + this.language + " price: " + this.price + " ";
	}
	public abstract String toBuy();
	
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null) return false;
		if(this.getClass() != o.getClass()) return false;
		Apple apple = (Apple)o;
		return (this.color == apple.color && this.language == apple.language && this.storage == apple.storage && this.price == apple.price);
	}
	public int hashCode() {
		return Objects.hash(color, storage, language, price);
	}
}
