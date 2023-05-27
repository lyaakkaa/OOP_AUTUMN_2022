import java.util.Scanner;

public class program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String line = "";
		for(int i = 0; i < name.length(); i++) {
			line += '-';
		}
		System.out.println("+" + line + "+");
		System.out.println("|" + name + "|");
		System.out.println("+" + line + "+");

		sc.close();

	}

}
