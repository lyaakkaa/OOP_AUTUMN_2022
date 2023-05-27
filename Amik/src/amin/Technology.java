package amin;

import java.util.Objects;


public abstract class Technology {
	int price;
	int year;
	Brand type;
	Technology(){}
	Technology(int price){
		this.price = price;
	}
	Technology(int price, int year, Brand type){
		this(price);
		this.year = year;
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setBrand(Brand type) {
		this.type = type;
	}
	
	public int sale() {
		if(this.type == Brand.APPLE) {
			return price = price * 90/100;
		}else {
			return price = price * 70/100;
		}
	}
    public boolean equals(Object o) {
    	if(this == o) return true;
    	if(o == null) return false;
    	if(this.getClass() != o.getClass()) return false;
    	Technology technology = (Technology)o;
    	return(this.price == technology.price && this.year == technology.year && this.type == technology.type);
    }
    public int hashCode() {
    	return Objects.hash(price, year, type);
    	}
    }
	

