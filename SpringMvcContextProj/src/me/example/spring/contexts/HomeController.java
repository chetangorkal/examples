package me.example.spring.contexts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import me.example.bean.Employee;
import me.example.bean.Student;

@Controller
public class HomeController {

	@Autowired
	private Student student;

	@Autowired
	private Employee employee;

	@RequestMapping(value = "/home")
	public String getHomePage() {
		ModelAndView modelAndView = new ModelAndView("home");
		return "home";
	}

	@RequestMapping(value = "/getDetails")
	public ModelAndView getDetails() {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("studentName", student.getName());
		modelAndView.addObject("employeeName", employee.getName());
		return modelAndView;
	}
}
