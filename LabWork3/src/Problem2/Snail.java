package Problem2;

public class Snail implements Moveable{
	String name;
	int age;
	public Snail() {

	}
	public Snail(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	


	public String toString() {
		return "I am snail " + name;
	}

	@Override
	public void move() {
		System.out.println("I am move because I am snail!");
		
	}

}
