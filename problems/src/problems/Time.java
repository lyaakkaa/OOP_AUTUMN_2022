package problems;

public class Time {

	int hour;
	int min;
	int sec;
	
	public Time() {
		hour = 0; 
		min = 0; 
		sec = 0;
	}
    public Time (int hour, int min, int sec) { 
    	this.hour = hour; 
    	this.min = min; 
    	this.sec = sec; 
    }
    
    public boolean isOkTime() {
    	if(this.hour > 24 && this.hour <= 0 && this.min > 60 && this.min <= 0 && this.sec > 60 && this.sec <= 0) {
    		return false;
    	}
    	return true;

    }
    public int getHour() { 
    	return hour;
    }
    
    public int getMinute() { 
    	return min; 
    }
    
    public int getSecond() { 
    	return sec; 
    }

    public void setHour(int hour) { 
    	this.hour = hour; 
    }
    public void setMinute(int min) { 
    	this.min = min; 
    }
    public void setSecond(int sec) { 
    	this.sec = sec; 
    }

    public void setTime (int hour, int min, int sec) { 
    	this.hour = hour; 
    	this.min = min; 
    	this.sec = sec; 
    }
    
    
	public String toUniversal() {
	        
	        StringBuffer ourTime = new StringBuffer();
	
	        if(hour < 10) ourTime.append('0');
	        ourTime.append(hour);
	
	        ourTime.append(':');
	
	        if(min < 10) ourTime.append('0');
	        ourTime.append(min);
	
	        ourTime.append(':');
	
	        if(sec < 10) ourTime.append('0');
	        ourTime.append(sec);
	
	        return ourTime.toString();
    }
	
	public void timeSetting() {
		this.min += this.sec / 60;
	    this.sec %= 60;
	    this.hour += this.min / 60;
	    this.min %= 60;
	}
	
	public String toStandard() {
		int hours = this.hour;
		if(this.hour == 12) {
			this.hour = 12;
		}
		else {
			this.hour = this.hour % 12;
		}
		String ourTime = this.toUniversal();
		if(hours > 12 && hours <= 23) {
			return ourTime + " " + "PM";
		}
		else {
			return ourTime + " " + "AM";
		}
	}
	
	public String toString() {
		this.timeSetting();
		String t = this.toUniversal();
		return t;
	}
	
	
	
	public static Time addTimes(Time t1, Time t2) {
		Time newTime = new Time();
		
		int h = t1.hour + t2.hour;
		int m = t1.min + t2.min;
		int s = t1.sec + t2.sec;
		//newTime.timeSetting();
		newTime.setTime(h, m, s);
		newTime.timeSetting();
		return newTime;
		
	}
	
	
	public Time addTimes(Time t1) {
		return Time.addTimes(t1, this);
	}   
}
