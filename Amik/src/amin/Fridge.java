package amin;

public class Fridge extends Technology {
	boolean isGetWater;
	int minTemperature;
	Fridge(){}
	Fridge(int price, int year, Brand type, boolean isGetWater, int minTemperature){
		super(price, year, type);
		this.isGetWater = isGetWater;
		this.minTemperature = minTemperature;
	}
	public int sale() {
		if( super.type == Brand.SAMSUNG && isGetWater == true){
			return price = price * 50/100;
		}else {
			return price = price * 70/100;
		}
	}

}
