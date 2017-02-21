package com.UserManager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

@Controller
public class UserController {

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("user", "command", new Users());
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("SpringWeb") Users user, ModelMap model) {


		model.addAttribute("userID", user.getUserID());
		model.addAttribute("userPass", user.getUserPass());
		model.addAttribute("userName", user.getUserName());
		model.addAttribute("isAuthenticated", user.getIsAuthenticated());
		return "showusers";
	}
	 
   @RequestMapping(value = "/removeLogin", method = RequestMethod.POST)
	public void removeUser(@ModelAttribute("SpringWeb") Users user, ModelMap model ){
	
	   
	   
	}
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("SpringWeb") Users user, ModelMap model ){
		
		//model.addAttribute("userName", user.getUserName());
		//model.addAttribute("userPass", user.getUserPass());
		
		
		String name = user.getUserName();
		String pass = user.getUserPass();
		
		if(name.equals("admin") && pass.equals("admin")){
			user.setIsAuthenticated(true);
			
			model.addAttribute("userID", user.getUserID());
			model.addAttribute("userPass", user.getUserPass());
			model.addAttribute("userName", user.getUserName());
			model.addAttribute("isAuthenticated", user.getIsAuthenticated());
				
		}
		return new ModelAndView("welcome", "command",user);
			
	}
	
	@RequestMapping("/addNewUser")
	public ModelAndView addNewUser() {

		return new ModelAndView("addNewUser", "command", new Users());
	}

	@RequestMapping(value = "/greetings", method = RequestMethod.GET)
	public String showGreetings(){
		return "greetings";
	}

	
}
