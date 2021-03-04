package com.assignment.franchise.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *  Contains methods to handle UI pages
 * 
 * @author Vishnu
 *
 */
@Controller
public class ViewApplicationController {

	@GetMapping("/")
	public String applicationForm() {
		return "applicationform";
	}
	
	@GetMapping("/applications")
	public String applications() {
		return "applications";
	}
	
	@GetMapping("/application")
	public String application() {
		return "application";
	}
}
