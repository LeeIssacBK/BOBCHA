package com.hungry.spring.info.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("infoController")
@RequestMapping("/info")
public class InfoController {
	
	@RequestMapping("/info")
	public ModelAndView info() {
		return new ModelAndView("/info/info");
	}

}
