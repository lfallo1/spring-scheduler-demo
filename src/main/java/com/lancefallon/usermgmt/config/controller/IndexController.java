package com.lancefallon.usermgmt.config.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * handle index route when app starts. this will start the angular application
 * @author lancefallon
 *
 */
@Controller
public class IndexController {

	@RequestMapping("/")
	public String getIndex(){
		return "index.html";
	}
	
}
