package com.example.series.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	@RequestMapping(value="/hellowolrd",method=RequestMethod.GET)
	public ModelAndView greeting() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","Hello Everyone Hope you all enjoying the class !");
		mv.setViewName("helloworld");
		return mv;
	}
	@GetMapping("/hello")
	public ModelAndView greetings() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","Hello Everyone Hope you all enjoying the class !");
		mv.addObject("message", "I am using Get Mapping annotation");
		mv.setViewName("hello");
		return mv;
	}
	
	
	@RequestMapping(value="/hellow")
	public ModelAndView greet() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg","Hello Everyone Hope you all enjoying the class !");
		mv.addObject("message", "I am using Request Mapping to handle default http get request");
		mv.setViewName("hello");
		return mv;
	}
}
