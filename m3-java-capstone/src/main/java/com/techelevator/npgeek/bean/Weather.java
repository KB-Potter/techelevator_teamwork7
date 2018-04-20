package com.techelevator.npgeek.bean;

public class Weather {
	
	private String parkcode;
	private int fivedayforecastvalue;
	private int high;
	private int low;
	private float highc;
	private float lowc;
	private String forecast;
	private String advisory;
	
	
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public int getFivedayforecastvalue() {
		return fivedayforecastvalue;
	}
	public void setFivedayforecastvalue(int fivedayforecastvalue) {
		this.fivedayforecastvalue = fivedayforecastvalue;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	
	public float getHighc() {
		return highc;
	}
	public void setHighc(float highc) {
		this.highc = highc;
	}
	public float getLowc() {
		return lowc;
	}
	public void setLowc(float lowc) {
		this.lowc = lowc;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getAdvisory() {
		return advisory;
	}
	public void setAdvisory(String advisory) {
		this.advisory = advisory;
	}
	

}
