package com.getsocial.model.proto;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.model.LatLng;
  
public class Merchant
	{
	public int id = 0;

	public Venue nearestVenue;
	
	public List<Venue> nearestVenues = new ArrayList<Venue>();

	public String name = "";
	
	public String address1 = "";
	
	public String address2 = "";
	
	public String zipCode = "";
	
	public String city = "";
	
	public String state = "";
	
	public long merchantCategoryBits= 0;
	public String websiteUrl = "http://google.com";
	public LatLng latLng = new LatLng(0, 0);
	public String iconUrl = null;
	}
