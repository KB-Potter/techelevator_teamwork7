package com.techelevator.npgeek.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.techelevator.npgeek.bean.FavoritePark;
import com.techelevator.npgeek.bean.ParkSurvey;
import com.techelevator.npgeek.dao.ParkDao;

@Controller
public class FavoriteController {
	
	ParkDao dao;
	
	@Autowired
	FavoriteController(ParkDao dao){
		this.dao = dao;
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.GET)
	public String getSurvey(HttpServletRequest request, ModelMap model) {
		request.setAttribute("HomePage", dao.getAllParks());
		model.addAttribute("HomePage");

		return "survey";
	}
	
	
	@RequestMapping(path = "/favoriteParks", method = RequestMethod.POST)	
	public String processSurvey(HttpServletRequest request, ParkSurvey survey, RedirectAttributes redirectAttr) {
		String parkcode = request.getParameter("parkcode");
		String emailaddress = request.getParameter("emailaddress");
		String state = request.getParameter("state");
		String activitylevel = request.getParameter("activitylevel");
		String parkname = dao.getParkNameByParkCode(parkcode);
		survey.setParkname(parkname);
		survey.setEmailaddress(emailaddress);
		survey.setActivitylevel(activitylevel);
		survey.setState(state);
		survey.setParkcode(parkcode);
		
		dao.storeSurveyInput(survey);
		redirectAttr.addFlashAttribute("PName", parkname);
		return "redirect:/favoriteParks";	
	}
	
	@RequestMapping(path = "/favoriteParks", method = RequestMethod.GET)
	public String showFavoriteParks(HttpServletRequest request, Model model, RedirectAttributes redirectAttr) {
		List<FavoritePark> list = new ArrayList<>();
		list = dao.favCount();
		request.setAttribute("FavoritePark", list);
		List<FavoritePark> listBottom = new ArrayList<>();
		if (list.size() > 3) {
			listBottom = dao.favCount();
			listBottom.remove(0);
			listBottom.remove(0);
			listBottom.remove(0);
			request.setAttribute("LessFavorite", listBottom);
		}
		if(model.containsAttribute("PName")) {
		    String parkName = (String) model.asMap().get("PName");
		    redirectAttr.addFlashAttribute("PName", parkName);
		    

//		model.addAttribute("HomePage");
		
	}
		return "favoriteParks";

}
}