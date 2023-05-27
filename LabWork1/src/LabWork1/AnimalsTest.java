package LabWork1;


public class AnimalsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animals animal1 = new Animals("dog", "Barbos", 3, 25,Gender.MALE);
		Animals animal2 = new Animals("cat", "Mia", 1, 7, Gender.FEMALE);
		Animals animal3 = new Animals("cat", "Max", 2, 9, Gender.MALE);
		System.out.println(Animals.getNumberOfAnimals());
		System.out.println(Animals.getBaby(animal1, animal3).getType());
		System.out.println(animal1.whereILive());

	}

}
