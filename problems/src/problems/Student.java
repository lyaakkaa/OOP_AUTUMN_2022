package problems;

public class Student {
	private String name;
	private int id;
	private int year;
	int grade;
	static int cnt;
	
	{
		id = cnt++;
	}
	
	public Student(String name, int grade){
		this.name = name;
		this.grade = grade;
	}
	
	
	public Student(String name, int year, int grade){
		this(name, grade);
		this.grade = grade;
	}
	public Student(String name){
		this.name = name;
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void yearStudy() {
		this.year++ ;	
	}
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String toString() {
		return "Student's name: " + name + "\nID: " + id;
	}
}
