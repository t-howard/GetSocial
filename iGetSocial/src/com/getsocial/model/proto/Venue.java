package com.getsocial.model.proto;

import com.google.android.gms.maps.model.LatLng;

public class Venue
	{
	
		public int id = 0;
		
		public int	parentMerchantID = 0;
	
		public Merchant parentMerchant = null;
		
		public String name = "";
		
		public String address1 = "";
		
		public String address2 = "";
		
		public String zipCode = "";
		
		public String city = "";
		
		public String state = "";
		
		public long merchantCategoryBits= 0;
		
		public LatLng latLng = new LatLng(0, 0);
		public String iconUrl = null;
		public String websiteUrl = "http://google.com";
		public String phoneNumber;
		
	}
