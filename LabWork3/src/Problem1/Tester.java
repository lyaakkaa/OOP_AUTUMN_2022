package Problem1;

import java.util.Vector;

public class Tester {

	public static void main(String[] args) {
		Dog d1 = new Dog("Rex", Gender.MALE, 12, 3);
		Dog d2 = new Dog("Alisa", Gender.FEMALE, 15, 5);
		Cat c1 = new Cat("Murka", Gender.FEMALE, 9, 4);
		
		Student s = new Student(1, "Lyaka", 18, 4.00);
		System.out.println(s);
		s.eat();

		Vector<Animal> pets = new Vector<Animal>();
		pets.add(d1);
		pets.add(d2);
		pets.add(c1);

		System.out.println(pets);

		for(Animal animal : pets) {
			System.out.println("\n"+animal.voice());
			if(animal instanceof Cat) {
				Cat c = (Cat)animal;
				c.findViscas();
				c.findMouse();
			}
			else if(animal instanceof Dog) {
				((Dog)animal).findPedigree(); // call specific
			}
			System.out.println(animal + ", crossing border -"+Animal.crossTheBorder(animal));
			animal.move(10); //call inherited move
		}

	}

}
