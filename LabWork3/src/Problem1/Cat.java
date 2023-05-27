package Problem1;


public class Cat extends Animal implements Eatable{

	int numOfMiceCaught;

	public Cat() {

	}
	public Cat(String name) {
		super(name);
	}
	public Cat(String name,Gender gender, int weight, int numOfMiceCaught) {
		super(name, gender, weight);
		this.numOfMiceCaught = numOfMiceCaught;
	}
	
	public String toString() {
		return super.toString()+ ", num of mice caught: "+numOfMiceCaught;
	}
	public void findViscas() {
		System.out.println("Viscas Found!!!");
	}
	public void findMouse() {
		numOfMiceCaught++;
		super.setWeight(getWeight() + 1);
		
	}
    //	Overloading
	public void findMouse(int num) {
		for(int i=0; i<num; i++)
			findMouse();
	}
	@Override
	public void eat() {
		System.out.println("yummy Viscas");
	}
	@Override
	public String voice() {
		return "meow";
	}
	
}