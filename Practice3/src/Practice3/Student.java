package Practice3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

public class Student {
	private String name;
	private int id;
	

	
	Vector<Lesson> lessonsOfStudent = new Vector<Lesson>();
	
	Student(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	void pushBack(Lesson lesson) {
		lessonsOfStudent.add(lesson);
	}
	
	
	public void drawSchedule() {
		for(Lesson cur: lessonsOfStudent) {
			System.out.println(cur);
			
		}
		//System.out.println(lesson);
		
	}
	
	
	public void sortTue() {
		List<Lesson> lessonsTue = new ArrayList<>();
		for(Lesson cur: lessonsOfStudent) {
			if(cur.day == Days.TUE) {
				lessonsTue.add(cur);
			}
		}
		Collections.sort(lessonsTue, (l1, l2) -> l1.toString().compareTo(l2.toString()));
		
		
		for(Lesson cur: lessonsTue) {
			System.out.println(cur);
		}	
	}
	
	



}


/*		play with these classes. For example, 
	-you can add Lesson duration (also of type Time!), Lesson type (lecture, lab) fields, Lesson room.
	-Room can be a class with fields number(or name), floor, capacity, etc.
-You can update collision method considering the lesson duration, e.g., if oop starts at 14:00 TUE and 
lasts 1 hour and algo starts at 14:30 TUE, there is a collision.
Hint: When the intersection of two intervals [s1, s2] and [t1, t2] is empty?

-You can create a Student class with list of Lessons (distinct from static list of all
lessons!) with a method to draw a schedule. 
-How can you store/operate with a room number considering 
offline and online formats? 
-How can you print, e.g., all lessons on Tuesday in sorted order?
I will show you later the elegant way to do it. Try to implement it as you can now.
More practice - more knowledge. Good luck!


-Вы можете создать студенческий класс со списком уроков (отличным от статического списка всех
уроки!) с методом рисования расписания.
-Как вы можете хранить / работать с номером комнаты, учитывая
оффлайн и онлайн форматы?
-Как можно распечатать, например, все уроки вторника в отсортированном порядке?
Позже я покажу вам элегантный способ сделать это. Попробуйте реализовать это, как вы можете сейчас.
Больше практики - больше знаний. Удачи!
*/