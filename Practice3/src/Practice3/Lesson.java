package Practice3;

import java.util.Vector;

public class Lesson {
	String name;
	private int id; // read only
	Days day;
	private Time time;
	private Time during;
	private Type type;
	Format format;
	Room room;
	static int cnt;
	static Vector<Lesson> lessons;
	
	static{
		lessons = new Vector<Lesson>();
	}
	{
		id = cnt++;
		lessons.add(this);
	}
	public Lesson() {
		
	}
	public Lesson(String name, Days day, Time time) {
		this.name = name;
		this.day = day;
		this.time = time;
	}
	public Lesson(String name, Days day, Time time, Format format, Time during, Type type)
	{
		this(name, day, time);
		this.format = format;
		this.during = during;
		this.type = type;
	}
	public Lesson(String name, Days day, Time time, Format format, Time during, Type type, Room room)
	{
		this(name, day, time, format, during, type);
		this.room = room;
	}
	public int getId() {
		return id;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String toString() {
		if(format == Format.ONLINE) {
			return "Lesson "+ name+ ", "+ id + ", "+day + ", "+format + ", "+time + "-" + this.getEndTime() + " " + type + " " + " at home)"; 
			
		}
		return "Lesson "+ name+ ", "+ id + ", "+day + ", "+format + ", "+time + "-" + this.getEndTime() + " " + type + " " + room; 
	}
	public Time getEndTime() {
		return Time.addTimes(time, during);
	}
	public boolean checkCollision(Lesson b) {
		return checkCollision(this,b);
	}
	static boolean checkCollision(Lesson a, Lesson b) {
		if(a.day==b.day) {
			if(a.time.hour <= b.getEndTime().hour && b.time.hour <= a.getEndTime().hour || b.time.hour <= a.getEndTime().hour && a.time.hour <= b.getEndTime().hour ) {
				return true;
			}
		}
		return false;
	}
}
