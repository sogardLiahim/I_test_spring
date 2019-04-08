package com.ab.places;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ab.db.SaliDAO;

import javassist.bytecode.Descriptor.Iterator;


@Controller
@RequestMapping("/app")
public class ApplicationController {

@Autowired
SaliDAO A;
	
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
		List<String> a  =A.getSaliNo(1);
		for (String string : a) {
		System.out.println(string);
	}
	
	return new ModelAndView("Mihai");

		
	}
	
	
	@RequestMapping("/filme")
	public ModelAndView userLogged(){
		ModelAndView model = new ModelAndView("Filme");		
		return  model;
		
	}
	
	@RequestMapping("/rezerva")
	public ModelAndView rezerva(){
		ModelAndView model = new ModelAndView("RezervaPage");
		
		return model;
		
	}
	
	@RequestMapping("/main")
	public ModelAndView mainPage() {return new ModelAndView ("CinemaMainPage");}
}
