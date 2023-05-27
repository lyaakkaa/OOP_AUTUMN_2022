package Practice3;
public class Room {
	private int floor;
	private int numberOfPeople;
	private int number;
	private Format format;
	
	Room(){
		
	}
	
	Room(int floor, int numberOfPeople, int number){
		this.floor = floor;
		this.numberOfPeople = numberOfPeople;
		this.number = number;
	}
	
	public int getFloor() {
		return  this.floor;
	}
	public int getNumberOfPeople() {
		return this.numberOfPeople;
	}
	public int getNumber() {
		return this.number;
	}
	public String toString() {
		
		return "Room-" + this.number + "," + "floor-" + this.floor;
		
		
	}
	
	

}
