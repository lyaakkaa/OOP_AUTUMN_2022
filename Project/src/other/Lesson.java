package other;

import java.time.LocalTime;
import java.util.Objects;

public class Lesson {
	private LessonType lessonType;
	private DayOfWeek day;
	private LocalTime start;
	private LocalTime end;
	
	
	public Lesson() {}
	
	
	public Lesson(LessonType type, DayOfWeek day, int startHour, int startMinute, int endHour, int endMinute) {
		this.lessonType = type;
		this.day = day;
		this.start = LocalTime.of(startHour, startMinute);
		this.end = LocalTime.of(endHour, endMinute);
	}
	
	public LessonType getLessonType() {
		return lessonType;
	}
	public void setLessonType(LessonType lessonType) {
		this.lessonType = lessonType;
	}
	public DayOfWeek getDay() {
		return day;
	}
	public void setDay(DayOfWeek day) {
		this.day = day;
	}
	public LocalTime getStart() {
		return start;
	}
	public void setStart(LocalTime start) {
		this.start = start;
	}
	public LocalTime getEnd() {
		return end;
	}
	public void setEnd(LocalTime end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return (
			"|" + this.lessonType + "| Starts at " + start.getHour() + ":" + ((start.getMinute() == 0) ? "00" : start.getMinute()) + ", ends at "
			+ end.getHour() + ":" + ((end.getMinute() == 0) ? "00" : end.getMinute()) + ". " + day
		);
	}


	@Override
	public int hashCode() {
		return Objects.hash(day, end, lessonType, start);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return day == other.day && Objects.equals(end, other.end) && lessonType == other.lessonType
				&& Objects.equals(start, other.start);
	}
	
	

}
