package Practice3;

public class StudentTest {

	public static void main(String[] args) {
		Student st1 = new Student("Leila", 123);
		st1.pushBack(new Lesson("KZ", Days.MON, new Time(10), Format.OFFLINE, new Time(1), Type.lab, new Room(2, 15, 230)));
		st1.pushBack(new Lesson("OOP", Days.TUE, new Time(14,30), Format.OFFLINE, new Time(2), Type.lection, new Room(4, 50, 461)));
		st1.pushBack(new Lesson("DB", Days.TUE, new Time(9,30), Format.OFFLINE, new Time(2), Type.lection, new Room(4, 100, 444)));
		st1.pushBack(new Lesson("ADS", Days.WED, new Time(13,30), Format.ONLINE, new Time(1, 30), Type.lab));
		st1.pushBack(new Lesson("Politics", Days.FRI, new Time(17,30), Format.OFFLINE, new Time(2), Type.lection, new Room(4, 50, 461)));
		
		st1.drawSchedule();
		st1.sortTue();
	}

}
