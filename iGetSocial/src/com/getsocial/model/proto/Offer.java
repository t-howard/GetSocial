package com.getsocial.model.proto;

import java.util.ArrayList;
import java.util.List;

public class Offer
	{
	    public int id;
	    
		public String title="";
		public String title2="";
		public String iconUrl = null;
		
		public String discountToCharityString = "0%";
		public String discountToUserString = "0%";
	
		public Venue nearestVenue;
		
		public List<Venue> nearestVenues = new ArrayList<Venue>();
		public int merchantId;
		public Merchant merchant;

		public Charity charity;
	}
