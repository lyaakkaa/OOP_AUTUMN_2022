package Problem5;
import problems.Time;

public class CoolTime extends Time implements Comparable <CoolTime>{
	public CoolTime() {};

    public CoolTime (int hour, int min, int sec) { 
    	super(hour, min, sec);
    }
	@Override
	public int compareTo(CoolTime o) {
		Time other = (Time)o;
		if(getHour() > other.getHour()) return 1;
		else if(getHour() < other.getHour()) return -1;
		else {
			if(getMinute() > other.getMinute()) return 1;
			else if(getMinute() < other.getMinute()) return -1;
			else {
				if(getSecond() > other.getSecond()) return 1;
				else if(getSecond() < other.getSecond()) return -1;
				return 0;
			}
		}
	}
	
}
