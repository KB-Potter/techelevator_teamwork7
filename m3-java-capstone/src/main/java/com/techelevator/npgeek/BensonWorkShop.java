package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.npgeek.bean.Weather;

public class BensonWorkShop {
	
	List<Weather> forecast = new ArrayList<>();
	
	
	public void imageHelper(List<Weather> forecast) {
		String partlycloudy = "";
		String cloudy = "";
		String sunny = "";
		String snow = "";
		String rain = "";
		String thunderstorm = "";
		
		
		for(int i = 0; i < forecast.size(); i++) {
			
			if(forecast.get(i).getForecast().equals("partly cloudy")) {
				partlycloudy = "partlyCloudy.png";
			}
			else if (forecast.get(i).getForecast().equals("cloudy")) {
				cloudy = "cloudy.png";
			}
		}
	}
	
}
