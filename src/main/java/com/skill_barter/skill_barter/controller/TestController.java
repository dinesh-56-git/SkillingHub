package com.skill_barter.skill_barter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
	public class TestController {

	    @GetMapping("/test")
	    public String test() {
	        return "dashboard";
	    }
	}


