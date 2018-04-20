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
@SessionAttributes("Temp")
public class TempController {
	@RequestMapping(path = "/convertTemp", method = RequestMethod.GET)
	public String setTemp (HttpServletRequest request, ModelMap model) {
	String tempconv = request.getParameter("tempConvert");
	model.addAttribute("Temp", tempconv);
	return "redirect:/parkDetail";
}
	
	// return parkDetail
	
}
