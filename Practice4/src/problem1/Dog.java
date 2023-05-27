package problem1;

import LabWork1.Gender;

//Animal, Dog
//SPECIFIC - bark(),hateCat(), loveBones(), findPedigree(), 
//Inherited and ok - getName(), move(int dx, ..),
//Inherited and replaced - toString(), sound(), eat(),  


public class Dog extends Animal{
	private int sizeBone;
	
	
	public Dog() {
		super();
		sizeBone = 0;
	}
	
	public Dog(String name, int age, double weight, Gender gender, int sizeBone) {
        super(name, age, weight, gender);
        this.sizeBone = sizeBone;
    }
	
	public void fetch() {
		System.out.println("Good boy!");
	}
	
	@Override
	public String toString() {
		return "I am dog with name " + super.getName() + " and fav size bone " + this.sizeBone; 
 	}
	
	@Override
	public String speak(){
		return "Woof - woof";
	}
	
	public int getSizeBone() {
		return this.sizeBone;
	}
	
	

}
