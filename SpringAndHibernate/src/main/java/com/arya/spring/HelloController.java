package com.arya.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/name")
	public ModelAndView sayHello(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "Swamy...");
		mav.setViewName("hello");
		
		return mav;
	}

}
