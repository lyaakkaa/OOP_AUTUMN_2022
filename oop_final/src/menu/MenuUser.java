package menu;

import java.io.IOException;
import java.util.Vector;

import classes.Database;
import classes.News;

public abstract class MenuUser {
	private String menu;
	
	public MenuUser() {}
	
	public abstract void hello();
	
	public String getMenu() {
		return menu;
	}
	
	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	public abstract boolean choosingAction(String act) throws IOException, InterruptedException;
	
	public boolean run() throws InterruptedException, IOException {
		System.out.println("\nClick on the type of action you want: ");
		System.out.println(this.getMenu());
		
		String choiceAct = Buffer.reader.readLine();
		if(this.choosingAction(choiceAct)) return run();
		else return true;
		
	}
	
	public void viewNews() {
		Vector<News> news = Database.getDatabase().getNews();

        if(!news.isEmpty()) {
            int index = 1;
            for(News n : news) {
                System.out.println(index + "| " + n.getTitle() + ".");
                System.out.println("Content: " + n.getText());
                System.out.println("Comments of this article: " + n.getComments() + "\n");
                index++;
            }
        } else System.out.println("No news!");
    }
}

