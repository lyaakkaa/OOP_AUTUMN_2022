package Problem1_NOT_ANIMALS;

public abstract class Messenger  {
	private int numberOfChats;
	
	public Messenger(int numberOfChats) {
		this.numberOfChats = numberOfChats;
	}

	public int getNumberOfChats() {
		return numberOfChats;
	}

	public void setNumberOfChats(int numberOfChats) {
		this.numberOfChats = numberOfChats;
	}	
}
