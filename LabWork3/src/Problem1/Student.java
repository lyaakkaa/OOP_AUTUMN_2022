package Problem1;

public class Student implements Eatable{
	private int id;
	private String name;
	private int age;
	private double gpa;
	
	public Student(int id, String name, int age, double gpa) {
		this.setId(id);
		this.setName(name);
		this.setAge(age);
		this.setGpa(gpa);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	@Override
	public void eat() {
		System.out.println("Hooray I'm in the cafeteria");
		System.out.println();
		
	}
	
	public String toString() {
		return "I am student " + ", My name is " + name;  
	}

}
