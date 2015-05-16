package com.cds.consumer.model.proto;

import com.google.android.gms.maps.model.LatLng;

public class Charity
	{
	public int id = 0;
	
	public int	parentCharityID = 0;

	public Merchant parentCharity = null;
	
	public String name = "";
	
	public String address1 = "";
	
	public String address2 = "";
	
	public String zipCode = "";
	
	public String city = "";
	
	public String state = "";
	
	public long charityCategoryBits= 0;
	
	public LatLng latLng = new LatLng(0, 0);
	
	public String iconUrl = null;
	public String websiteUrl = "http://google.com";

	public String phoneNumber = "";
	
	}
