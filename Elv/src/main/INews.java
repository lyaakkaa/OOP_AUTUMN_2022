package main;

import java.util.Date;

public interface INews {
	void createNews(String title, String text, Date date, Employee sender);
}