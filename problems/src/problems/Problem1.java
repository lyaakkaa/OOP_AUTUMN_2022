package problems;

public class Problem1 {
	String name;
	String id;
	int year;
	String type;
	chapter3_3_dog(String name){
		this.name = name;
	}
	chapter3_3_dog(String type, int age){
		this.type = type;
		this.setAge(age);
	}
	chapter3_3_dog(String type, int age, String name){
		this.type = type;
		this.setAge(age);
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}