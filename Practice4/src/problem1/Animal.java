package problem1;

import LabWork1.Gender;

public class Animal {
    private String name;
    private int age;
    private double weight;
    private Gender gender;
    private static long numberOfAnimals;
    
    {
    	numberOfAnimals++;
    }
    
    Animal(){
    	name = "No name";
    	age = 0;
    	weight = 0;
    }
    

    Animal(int age){
    	this.age = age;
    }
    
    Animal(double weight){
    	this.weight = weight;
    }
   
    Animal(String name){
    	this.name = name;
    }
    
    Animal(String name, int age){
    	this(age);
    	this.name = name;
    }
    
    Animal(String name ,int age, double weight, Gender gender){
    	this(name);
    	this.age = age;
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
    
    public String toString(){
        return "I am an animal";
    }
    
    public String sleep() {
    	return "Animal sleeps!";
    }
    
    public void eat() {
        System.out.println("Animal eats!");
    }
    
    public String moving(int speed) {
        return "Animal is moving at speed " + speed;
    }
    
    public String speak(){
    	return "No voice"; 
    }


}
