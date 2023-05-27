package Practice3;

public class Time {
	int hour;
	int min;
	public Time() {
		
	}
	
	public void setTime (int hour, int min) { 
    	this.hour = hour; 
    	this.min = min; 
  
    }
	
	public Time(int hour, int min) {
		this.min=min;
		this.hour = hour;
	}
	public Time(int hour) {
		this.hour = hour;
	}
	
	public int getHour() {
		return this.hour;
	}
	
	public int getMin() {
		return this.min;
	}
	
	
	
	public String toString() {
		String h = "";
		String m = "";
		if(this.hour < 10) {
			h = "0" + this.hour;
		}
		else {
			h = Integer.toString(this.hour);
		}
		if(this.min < 10) {
			m = "0" + this.min;
		}
		else {
			m = Integer.toString(this.min);
		}
		return h+ ":"+m;
	}
	public boolean equals(Time b) {//you have to pass Object here, to be discussed later. 
		//this is our basic version
		return this.hour==b.hour && this.min==b.min;
	}
	
	
	public void timeSetting() {
	    this.hour += this.min / 60;
	    this.min %= 60;
	}
	
	
	public static Time addTimes(Time t1, Time t2) {
		Time newTime = new Time();
		
		int h = t1.hour + t2.hour;
		int m = t1.min + t2.min;
		//newTime.timeSetting();
		newTime.setTime(h, m);
		newTime.timeSetting();
		return newTime;
		
	}
	
}
