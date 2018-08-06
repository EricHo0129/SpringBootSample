package com.eric.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eric.boot.model.Project;

@Controller
@RequestMapping("/welcome")
public class IndexController {

	@RequestMapping("")
	public ModelAndView index() {
		List<Project> projects = new ArrayList<>();
		projects.add(new Project("Plus", "萬年壽命不老專案", "https://plus.104-dev.com.tw"));
		projects.add(new Project("Yahoo", "好棒棒的古老入口網站", "https://tw.yahoo.com"));
		projects.add(new Project("Google翻譯", "翻譯的好幫手", "https://translate.google.com.tw"));
		ModelAndView result = new ModelAndView("/index");
		result.addObject("data", projects);
		return result;
	}
}
