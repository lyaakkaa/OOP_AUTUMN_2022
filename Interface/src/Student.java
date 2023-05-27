import java.util.Date;

public class Student implements Cloneable{
	int age;
	int id;
	Date enrolled;
	String name;
	
	public Student() throws CloneNotSupportedException {
		this.clone();
	}
	
	public Student(int age, int id, String name) {
		super();
		this.age = age;
		this.id = id;
		this.enrolled = new Date();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", id=" + id + ", date=" + enrolled + "]";
	}
	
	public Object clone() throws  CloneNotSupportedException{
		 Student s = (Student)super.clone();
		 s.enrolled = (Date)enrolled.clone();
		 return s;
	}

	
	

}
