package com.maincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.database.DAO;
import com.models.User;

@Controller
public class UserController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin() {
		return new ModelAndView("login", "command", new User());
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("SpringWeb") User myUser, ModelMap model) {

		String name = myUser.getName();
		String pass = myUser.getPass();

		DAO myDAO = new DAO();
		myDAO.connect();
		User dbUser = myDAO.getUserBasedOnName(myUser);

		if (dbUser != null) {
			if (name.equals(dbUser.getName()) && pass.equals(dbUser.getPass())) {

				return new ModelAndView("homepage", "command", myUser);
			}
		}
		return new ModelAndView("badlogin", "command", "");
	}

}
