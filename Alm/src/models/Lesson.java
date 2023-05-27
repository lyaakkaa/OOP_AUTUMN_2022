package models;

import enums.LessonType;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalTime;

@SuppressWarnings("serial")
public class Lesson implements Serializable {
	private LessonType type;
	private DayOfWeek day;
	private LocalTime startTime;
	private LocalTime endTime;

	public Lesson() {}

	public Lesson(LessonType type, DayOfWeek day, int startHour, int startMinute, int endHour, int endMinute) {
		if(endHour - startHour > 2) {
			System.out.println("Wrong time");
			return;
		}
		this.type = type;
		this.day = day;
		this.startTime = LocalTime.of(startHour, startMinute);
		this.endTime = LocalTime.of(endHour, endMinute);
	}
	
	public LessonType getType() {
		return type;
	}
	
	public LocalTime getStartTime() {
		return startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public void setDayTime(DayOfWeek day, int startHour, int startMinute, int endHour, int endMinute) {
		this.day = day;
		this.startTime = LocalTime.of(startHour, startMinute);
		this.endTime = LocalTime.of(endHour, endMinute);
	}

	@Override
	public String toString() {
		return (
			"|" + type + "| Starts at " + startTime.getHour() + ":" + ((startTime.getMinute() == 0) ? "00" : startTime.getMinute()) + ", ends at "
			+ endTime.getHour() + ":" + ((endTime.getMinute() == 0) ? "00" : endTime.getMinute()) + ". " + day
		);
	}
}