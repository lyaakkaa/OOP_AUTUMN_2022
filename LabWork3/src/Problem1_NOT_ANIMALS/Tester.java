package Problem1_NOT_ANIMALS;

public class Tester {

	public static void main(String[] args) {
		Telegram t = new Telegram(123);
		t.getMessage();
		WhatsApp w = new WhatsApp(11321);
		w.getMessage();
		Instagram i = new Instagram(2323);
		i.getMessage();
		PaperLetter pl = new PaperLetter();
		pl.getMessage();

	}
}
