package Problem1_NOT_ANIMALS;

public class WhatsApp extends Messenger implements Messegeable {

	public WhatsApp(int numberOfChats) {
		super(numberOfChats);
	}

	@Override
	public void sendMessage() {
		System.out.println("Sending a message to WhatsApp!");
	}

	@Override
	public void getMessage() {
		System.out.println("We receive a message in WhatsApp!");
	}

}
