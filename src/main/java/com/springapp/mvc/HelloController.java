package com.springapp.mvc;

import beans.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import utils.Utils;

import java.io.FileNotFoundException;
import java.sql.Timestamp;

@Controller
public class HelloController {
	private static final String fileUrl = "C:\\BinF\\users.txt";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView printWelcome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userJSP", new User());
		modelAndView.setViewName("main");
		return modelAndView;
	}

	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public ModelAndView checkUser(@ModelAttribute("userJSP") User user) throws FileNotFoundException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userInfo");
		user.setDate(new Timestamp(System.currentTimeMillis()));
		Utils.update(user, fileUrl);
		modelAndView.addObject("userJSP", user);
		modelAndView.addObject("datas",Utils.readList(fileUrl));
		return modelAndView;
	}

	@RequestMapping(value = "/getData", method = RequestMethod.POST)
	public ModelAndView dataFromFile() throws FileNotFoundException {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("userInfo");
		modelAndView.addObject("datas",Utils.readList(fileUrl));
		return modelAndView;
	}
}