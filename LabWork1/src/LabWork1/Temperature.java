package LabWork1;

public class Temperature {
	private double temp;
	private char scale;
	
	Temperature(){
		this.temp = 0;
		this.scale = 'C';
	}
	Temperature(double temp){
		  this.temp = temp;
		  this.scale = 'C';
	}
	Temperature(char scale){
		  this.temp = 0;
		  this.scale = scale;
	}
	Temperature(double temp, char scale){
		  this.temp = temp;
		  this.scale = scale;
	}
	
	public String toFahrenheit() {
		if(this.scale == 'C') {
			this.temp = (9 * (this.temp / 5)) + 32;
			this.scale = 'F';
			return this.toString();
		}
		return this.toString();
	}
	public String toCelsius() {
		if(this.scale == 'F') {
			this.temp = (5 * (this.temp - 32)) / 9;
			this.scale = 'C';
			return this.toString();
		}
		return this.toString();
	}
	public void setTemp(double temp) { 
    	this.temp = temp; 
    }
    public void setScale(char scale) { 
    	this.scale = scale; 
    }
    public void setTemperatire(double temp, char scale) { 
    	this.temp = temp;
    	this.scale = scale;
    }
    public char getScale() {
    	return this.scale;
    }
    public double getTemp() {
    	return this.temp;
    }
    public String toString() {
    	String s = Double.toString(this.temp);  
    	return s + this.scale;
    }
}
