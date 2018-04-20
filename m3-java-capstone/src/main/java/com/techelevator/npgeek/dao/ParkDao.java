package com.techelevator.npgeek.dao;

import java.util.List;

import com.techelevator.npgeek.bean.FavoritePark;
import com.techelevator.npgeek.bean.HomePage;
import com.techelevator.npgeek.bean.ParkDetail;
import com.techelevator.npgeek.bean.ParkSurvey;
import com.techelevator.npgeek.bean.Weather;

public interface ParkDao {
	
	public List<HomePage> getAllParks();
	public ParkDetail getParkByParkCode(String parkcode);
	public void storeSurveyInput(ParkSurvey post);
	public List<Weather> getParkWeatherByParkCode(String parkcode);
	public List<FavoritePark> favCount();
	public String getParkNameByParkCode(String parkcode);
	
}
