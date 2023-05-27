package comparators;

import models.User;
import java.util.Comparator;

public class IdComparator implements Comparator<User> {
	public IdComparator() {
		super();
	}

	@Override
	public int compare(User u1, User u2) {
		return u1.getId().compareTo(u2.getId());
	}
}