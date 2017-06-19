package me.example.events.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import me.example.servlet.FileUtil;

public class MyListener implements ServletContextListener {

	public static int count;

	@Override
	public void contextDestroyed(ServletContextEvent contextEvent) {
		count++;
		FileUtil fileUtil = new FileUtil();
		int count = Integer.parseInt((String) contextEvent.getServletContext().getAttribute("count"));
		fileUtil.writeTofile(new Integer(++count).toString());
	}

	@Override
	public void contextInitialized(ServletContextEvent contextEvent) {
		FileUtil fileUtil = new FileUtil();
		contextEvent.getServletContext().setAttribute("count", new Integer(fileUtil.readFromFile()).toString());
		contextEvent.getServletContext().setAttribute("count1", count);
	}

}
