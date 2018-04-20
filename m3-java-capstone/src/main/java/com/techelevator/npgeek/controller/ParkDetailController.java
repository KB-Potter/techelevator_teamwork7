package com.techelevator.npgeek.controller;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.bean.ParkDetail;
import com.techelevator.npgeek.bean.Weather;
import com.techelevator.npgeek.dao.ParkDao;
import com.techelevator.npgeek.helper.WeatherHelper;


@Controller
@SessionAttributes("Code")
public class ParkDetailController {
	
	ParkDao dao;
	

	
	@Autowired
	ParkDetailController(ParkDao dao){
		this.dao = dao;
	}
	
	
	@RequestMapping(path = "/parkSession", method = RequestMethod.GET)
		public String setParkCode (HttpServletRequest request, ModelMap model) {
		String pcode = request.getParameter("parkcode");
		model.addAttribute("Code", pcode);
		return "redirect:/parkDetail";
	}
	
	
	@RequestMapping(path = "/parkDetail", method = RequestMethod.GET)
	public String showParkDetail(HttpServletRequest request, ModelMap model, RedirectAttributes redirectAttr) {
		String parkcode = (String)model.get("Code");
		ParkDetail parkDeets = dao.getParkByParkCode(parkcode);
		redirectAttr.addFlashAttribute("ParkDetail", parkDeets);
		return "redirect:/weather";
		
		
	}

	@RequestMapping(path = "/weather", method = RequestMethod.GET)
	public String showParkDetail(HttpServletRequest request, ModelMap modelmap, Model model) {
		String parkcode = (String) model.asMap().get("Code");
		WeatherHelper help = new WeatherHelper();
		List<Weather> partWeather = new ArrayList<>();
		List<Weather> advisoryWeather = new ArrayList<>();
		List<Weather> finalWeather = new ArrayList<>();
		partWeather = dao.getParkWeatherByParkCode(parkcode);
		advisoryWeather = help.createAdvisory(partWeather);
		finalWeather = help.createCelsius(advisoryWeather);
		modelmap.addAttribute("weather", finalWeather);
		return "parkDetail";

	}
}
