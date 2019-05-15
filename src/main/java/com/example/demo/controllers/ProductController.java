package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domains.Employee;
import com.example.demo.services.EmployeeService;

@Controller
public class ProductController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> listEmployies = service.getAll();
		model.addAttribute("listEmployies", listEmployies);
		return "index";
	}
	
	@RequestMapping("/new")
	public String viewnewEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{dni}")
	public ModelAndView viewEditEmployee(@PathVariable("dni") int dni) {
		ModelAndView view = new ModelAndView("edit_employee");
		Employee employee = service.get(dni);
		view.addObject("employee", employee);
		return view;
	}
	
	@RequestMapping("/delete/{dni}")
	public String viewDeleteEmployee(@PathVariable("dni") int dni) {
		service.delete(dni);
		return "redirect:/";
	}
	
}
