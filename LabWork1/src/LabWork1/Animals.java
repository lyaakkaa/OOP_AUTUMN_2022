package LabWork1;


public class Animals {
	private String type;
    private String name;
    private int age;
    private double weight;
    private Gender gender;
    private static long numberOfAnimals;

    private final String  PLANET = "Earth"; 
    
    
    {
    	numberOfAnimals++;
    }
    
    
    Animals(){
    	type = "No type";
    	name = "No name";
    	age = 0;
    	weight = 0;
    }
    
    Animals(String type){
    	this.type = type;
    }
  
    Animals(int age){
    	this.age = age;
    }
    
    Animals(double weight){
    	this.weight = weight;
    }
   
    Animals(String type, String name){
    	this(type);
    	this.name = name;
    }
    
    Animals(String name, int age){
    	this(age);
    	this.name = name;
    }
    
    Animals(String type,String name ,int age, double weight, Gender gender){
    	this(type);
    	this.age = age;
    	this.name = name;
    	this.weight = weight;
    	this.gender = gender;
    }
    
    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public double getWeight() {
        return this.weight;
    }

    public String getType() {
        return this.type;
    }
    
    public Gender getGender() {
        return this.gender;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
 
    public void setAnimal(String name) {
        this.name = name;
    }

    public void setAnimal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAnimal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
    
    public static long getNumberOfAnimals() {
    	return numberOfAnimals;
    }
    
    public String whereILive() {
    	return "I live on " + PLANET; 
    }
    
    public double feedTheAnimal() {
    	this.weight += 0.1;
    	return this.getWeight();
    }
    
    public double feedTheAnimal(double m) {
        this.weight += m;
        return this.getWeight();
    }

    public double feedTheAnimal(double m, int n) {
        weight += (m * n);
        return this.getWeight();
    }
    
    public int happyBirthday() {
    	this.age += 1;
    	return this.getAge();
    }
    
    public String toString() {
    	return "Hello, my name is " + this.name + ". I am " + this.type + ". My age: " + this.age + ", weight: " + this.weight;
    }
 
    public static Animals getBaby(Animals object1, Animals object2) {
		Animals newAnimal = new Animals();
	
		if(object1.type.equals(object2.type) && !(object1.gender.equals(object2.gender))) {
			newAnimal.type = object1.type;
			return newAnimal;
		}
		return newAnimal;
	}
}
