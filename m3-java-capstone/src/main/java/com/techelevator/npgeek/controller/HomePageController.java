package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.dao.ParkDao;


@Controller
@SessionAttributes("HomePage")
public class HomePageController {
	
	ParkDao dao;
	
	@Autowired
	HomePageController(ParkDao dao){
		this.dao = dao;
	}
	
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showAllParks(HttpServletRequest request, ModelMap model) {
		request.setAttribute("HomePage", dao.getAllParks());
		model.addAttribute("HomePage");
		return "homePage";
	}
	


}
