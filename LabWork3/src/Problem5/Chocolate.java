package Problem5;

public class Chocolate implements Comparable <Chocolate> {
	private String name;
	private double weight;
	
	public Chocolate() {}
	
	public Chocolate(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Chocolate's name: " + name + ", weight: " + weight;
	}
	
	@Override
	public int compareTo(Chocolate choc) {
//		Chocolate choc = (Chocolate)o;
		if(this.getWeight() > choc.getWeight()) return 1;
		else if(this.getWeight() < choc.getWeight()) return -1;
		return 0;
	}
}
