package Problem1_NOT_ANIMALS;

public class Telegram extends Messenger implements Messegeable{

	public Telegram(int numberOfChats) {
		super(numberOfChats);
	}

	@Override
	public void sendMessage() {
		System.out.println("Sending a message to Telegram!");
	}

	@Override
	public void getMessage() {
		System.out.println("We receive a message in Telegram!");
	}
}
