package LabWork1;
import java.util.Vector;


import Practice3.*;

public class TeleSerial {
	private String nameTeleSerial;
	private Time time;
	private Time during;
	private Days day;
	private int id;
	private final String nameOfTheChannel = "Nickelodeon";
	static Vector <TeleSerial> teleSerials;
	static int cnt;
	
	static {
		teleSerials = new Vector<TeleSerial>();
	}
	
	{
		teleSerials.add(this);
		id = cnt++;
	}
	
	
	TeleSerial(String nameTeleSerial, Time time, Time during){
		this.nameTeleSerial = nameTeleSerial;
		this.time = time;
		this.during = during;
	}
	
	TeleSerial(String nameTeleSerial, Time time, Time during, Days day){
		this(nameTeleSerial, time, during);
		this.day = day;
	}
	
	public String getNameOfTheChannel() {
		return this.nameOfTheChannel;
	}
	
	public String getNameTeleserial() {
		return this.nameTeleSerial;
	}
	public Time getTime() {
		return this.time;
	}
	public Time getDuring() {
		return this.during;
	}
	public Days getDay() {
		return this.day;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Time getEndTime() {
		return Time.addTimes(time, during);
	}

	public void setTime(Time time) {
		this.time = time;
	}
	public void setDuring(Time during) {
		this.during = during;
	}
	public void setDay(Days day) {
		this.day = day;
	}
	
	public boolean checkCollision(TeleSerial b) {
		return checkCollision(this, b);
	}
	static boolean checkCollision(TeleSerial a, TeleSerial b) {
		if(a.day == b.day) {
			if(a.time.getHour() <= b.time.getHour() && b.time.getHour() <= a.getEndTime().getHour() || b.time.getHour() <= a.getEndTime().getHour() && a.time.getHour() <= b.getEndTime().getHour()) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean beOnTime(TeleSerial t, Days day, Time time) {
		if(t.day == day) {
			if(t.time.getHour() == time.getHour() && t.time.getMin() == time.getMin()) {
				return true;
			}
			
		}
		return false;
	}
	
	public static boolean beOnTime(Days day, Time time) {
		for(TeleSerial t : teleSerials) {
			if(t.day == day && t.time.getHour() == time.getHour() && t.time.getMin() == time.getMin()) {
				return true;
			}
			
		}
		return false;
	}
	
	public String toString() {
		return "Teleserial: " + this.nameTeleSerial + ", "+ "start time: " + this.time + ", end time:" + this.getEndTime() + ", day: " + this.day + " on " + this.nameOfTheChannel + " channel !";
	}
	
	
}
