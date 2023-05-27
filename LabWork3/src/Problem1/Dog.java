package Problem1;

public class Dog extends Animal implements Eatable{
	private int favBoneSize;
	
	public Dog() {}
	public Dog(String name, Gender gender, int weight, int fav) {
		super(name, gender, weight);
		this.favBoneSize = fav;
	}

	public String voice() {
		return "gav";
	}

	void findPedigree() {
		System.out.println("Pedigrre found! yahoo");
	}
	public String toString() {
		return super.toString() + ", fav bone size "+favBoneSize;
	}
	@Override
	public void eat() {
		System.out.println("bones, pedigree - nyam");
	}
}
