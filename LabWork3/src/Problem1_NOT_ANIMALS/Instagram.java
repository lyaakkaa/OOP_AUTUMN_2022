package Problem1_NOT_ANIMALS;

public class Instagram extends Messenger implements Messegeable{

	public Instagram(int numberOfChats) {
		super(numberOfChats);
	}

	@Override
	public void sendMessage() {
		System.out.println("Sending a message to Instagram!");
	}

	@Override
	public void getMessage() {
		System.out.println("We receive a message in Instagram!");
	}
}
