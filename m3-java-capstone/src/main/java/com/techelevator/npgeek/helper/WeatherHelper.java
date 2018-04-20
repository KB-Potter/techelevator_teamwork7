package com.techelevator.npgeek.helper;

import java.util.ArrayList;
import java.util.List;

import com.techelevator.npgeek.bean.Weather;


public class WeatherHelper {
	
	List<Weather> forecast = new ArrayList<>();
	List<Weather> celsius = new ArrayList<>();
	String advisory = "";
	
	public List<Weather> createAdvisory(List<Weather> forecast) {
		this.forecast = forecast;

		for (int i = 0; i < forecast.size(); i++) {
		
			if(forecast.get(i).getForecast().equals("snow")) {
				advisory = "Pack snowshoes.";
			}
			else if(forecast.get(i).getForecast().equals("rain")) {
				advisory = "Pack rain gear, wear waterproof shoes.";
			}
			else if(forecast.get(i).getForecast().equals("thunderstorms")) {
				advisory = "Seek shelter, avoid hiking on exposed ridges.";
			}
			else if(forecast.get(i).getForecast().equals("sunny")) {
				advisory = "Pack sunblock.";
			}
			advisory += " ";
			if(forecast.get(i).getHigh() > 75) {
				advisory +="Bring an extra gallon of water.";
			}
			else if(forecast.get(i).getHigh() - forecast.get(i).getLow() > 20) {
				advisory +="Wear breathable layers.";
			}
			if(forecast.get(i).getLow() < 20) {
				advisory +="Be aware of the dangers of exposure to frigid temperatures.";
			}
			forecast.get(i).setAdvisory(advisory);
			
			
		}
		return forecast;
		
		
	}
	public List<Weather> createCelsius(List<Weather> forecast) {
		this.celsius = forecast;
		
		
		for (int i = 0; i < forecast.size(); i++) {
			int high = forecast.get(i).getHigh();
			float highc = convertToC(high);
			forecast.get(i).setHighc(highc);
			int low = forecast.get(i).getLow();
			float lowc = convertToC(low);
			forecast.get(i).setLowc(lowc);
		}
		return celsius;
	}
	
	private float convertToC(int temp) {
		float c = (float)(temp - 32) * (5/9);
		return c;
	}
		
		
	}



