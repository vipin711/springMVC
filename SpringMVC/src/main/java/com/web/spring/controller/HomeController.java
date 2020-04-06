package com.web.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	@ResponseBody
	public String hello(@RequestParam("Search") String input) {
		//ModelAndView ret = new ModelAndView("home");
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<String>();
		SpellCheck sc = new SpellCheck();
		Boolean result = sc.run(input);
		if (result == true){
			System.out.println("spelled correctly");
		list.add("spelled correctly");
		}
		else {
			System.out.println("not correct");
			list = sc.makeSuggestions(input);

			if (list.size() == 0) {
				// return "and I have no idea what word you could mean.\n";
			}
			sb.append("perhaps you meant:\n");
			for (String s : list) {
				sb.append("\n  -" + s);
			}
		}

	//	ret.addObject("name", input);
		return "success";
	}
	
	@RequestMapping(value = "/succ")
	 @ResponseBody
	public String hello1() {
	
		Date d = new Date();
		return d.toString();
	}
}
