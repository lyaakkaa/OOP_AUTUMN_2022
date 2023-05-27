package Problem1;

public abstract class Animal{
	private String name;
	private int weight;
	private Gender gen;
	private Status docStatus;
	private int position;
	
	public Animal () {
		docStatus = Status.OK;
		position = 50;
	}
	
	public Animal(String name) {
		this();
		this.name = name;
	}
	
	public Animal(char gen) {
		this(gen=='F'?Gender.FEMALE:Gender.MALE);
	}
	
	public Animal(Gender gender) {
		this.gen = gender;
	}
	
	public Animal(String name ,Gender gender, int weight) {
		this(name);
		this.gen = gender;
		this.weight = weight;
	}
	
	public Gender getGen() {
		return gen;
	}

	public void setGen(Gender gen) {
		this.gen = gen;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return this.weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Status getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(Status docStatus) {
		this.docStatus = docStatus;
	}
	public int getPosition() {
		return this.position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
//	Overloading
	public final void move(int dx) {
		position += dx;
	}
	public final void move(int seconds, int speed) {
		move(speed*seconds);
	}
	
	public static boolean crossTheBorder(Animal a) {
		return a.weight < 30 && a.docStatus == Status.OK;
	}
	public boolean crossTheBorder() {
		return crossTheBorder(this);
	}

	public String toString() {
		return "My name is " + name + ", my weight: " + weight;
	}
	
	public abstract String voice();
}
