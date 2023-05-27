package menu;

import java.io.*;
import java.util.Vector;
import classes.*;


@SuppressWarnings("serial")
public class Buffer implements Serializable{
	public static BufferedReader reader;
	
	static {
		reader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public Buffer() {}
	
	public static boolean checkRange(int num, int l, int r) {
		return (num>= l && num <= r);
	}
	
	public static int numAct(String act) {
        try {
            return (Integer.parseInt(act));
        } catch (NumberFormatException exc) {
            return -1;
        }
    }
	
	public static void viewNews() {
		Vector <News> news = Database.getDatabase().getNews();
		
		if(news.size() > 0) {
			for(News newss : news) {
				System.out.println("-------" + newss.getTitle() + "-------");
				System.out.println(newss.getText());
				System.out.println("-------------------------");
				for(String com : newss.getComments()) {
					System.out.println(com);
				}
			}
		}
		else {
			System.out.println("No news lately");
		}
		
	}
	
	
	public static void sendMessage(Employee sender) throws IOException, InterruptedException{
		System.out.println("Please select an employee:");
		Vector <Employee> employees = new Vector<Employee>();
		int index = 1;
		for(Employee e : employees) {
			System.out.println(index + ")" + e.getName() + " " + e.getSurname());
			index++;
		}
		int choosenEmployeeNum = numAct(reader.readLine());
		if(choosenEmployeeNum < 1 || choosenEmployeeNum > employees.size()) {
			System.out.println("Invalid operation");
            return;
		}
		boolean isSigned = false;
		System.out.print("Enter the text of your message: ");
		String text = reader.readLine();
		System.out.println("Will you sign it?\n1.Yes 2.No");
		switch(reader.readLine()) {
			case "1" -> {
				System.out.println("Dean and rector are signing. Please wait 10sec");
	            isSigned = true;
	            Thread.sleep(10000);
			}
			case "2"->{
				System.out.println("The message misses the signature of the dean and rector");
			}
		}
		
		Message message = new Message(text, sender, employees.get(choosenEmployeeNum - 1));
		Database.getDatabase().addMessages(message);
		System.out.println("Message sent successfully!");
	}
	
	
	

}
