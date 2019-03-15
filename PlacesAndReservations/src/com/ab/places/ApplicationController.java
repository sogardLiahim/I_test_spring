package com.ab.places;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class ApplicationController {

     Cookie c = new Cookie("my_cooky", "1232");
     
	@RequestMapping("/home")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res){
		System.out.println("ajunge");
		ModelAndView model = new ModelAndView("RestaurantView");
		c.setComment("labar");
		c.setDomain("pornhub.com");
		res.addCookie(c);
		return model;
	}
	
	@RequestMapping("/mihaiPage")
	public ModelAndView mihai() {
		
	return new ModelAndView("Mihai");
		
	}
	
	
	@RequestMapping("/userLogged")
	public ModelAndView userLogged(){
		System.out.println("ajunge");
		ModelAndView model = new ModelAndView("userWhenIsLogged");
		
		return model;
		
	}
}
