package Problem1_NOT_ANIMALS;

public class PaperLetter implements Messegeable {

	@Override
	public void sendMessage() {
		System.out.println("We sent a letter!");
		
	}

	@Override
	public void getMessage() {
		System.out.println("We received a letter");
		
	}

}
