package com.techelevator.npgeek.bean;

public class HomePage {
	private String parkcode;
	private String parkname;
	private String parkdescription;
	private String location;
	private String imgname;
	
	
	public String getParkcode() {
		return parkcode;
	}
	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}
	public String getParkname() {
		return parkname;
	}
	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	public String getParkdescription() {
		return parkdescription;
	}
	public void setParkdescription(String parkdescription) {
		this.parkdescription = parkdescription;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname() {
		String newImg = parkcode.toLowerCase();
		this.imgname = newImg;
	}

}
