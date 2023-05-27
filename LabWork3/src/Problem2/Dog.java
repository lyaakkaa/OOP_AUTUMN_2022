package Problem2;

public class Dog implements Runable{
	String name;
	int age;
	public Dog() {

	}
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
		
	}
	public String voice() {
		return "gav";
	}

	void findPedigree() {
		System.out.println("Pedigrre found! yahoo");
	}
	
	public String toString() {
		return "I am dog " + name;
	}
	public String eat() {
		return "bones, pedigree - nyam";
	}
	@Override
	public void move() {
		System.out.println("I am moving!");
		
	}
	@Override
	public void run() {
		System.out.println("I am running!");
	}
}
