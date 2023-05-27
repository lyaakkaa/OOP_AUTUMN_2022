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

	}
	
	
	

}
