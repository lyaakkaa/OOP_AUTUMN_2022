package views;


import utils.Util;
import java.io.IOException;

public abstract class UserView {
    private String menu;

    public UserView() {}

    public boolean start() throws InterruptedException, IOException {
        Thread.sleep(500);

        System.out.println("\nSelect which type of action you want to perform, or X to logout:");
        System.out.println(getMenu());

        String choice = Util.reader.readLine();

        if(performAction(choice)) {
            return start();
        } else {
            return true;
        }
    }

    public abstract void greet();

    public abstract boolean performAction(String choice) throws IOException, InterruptedException;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void viewNews() {
        Util.viewNews();
    }
}