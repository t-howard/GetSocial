package com.getsocial.model.proto;


import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.maps.model.LatLng;

public class GSUser
	{
	public int id = 0;
	
	 
	
	public String firstName = "";
	
	public String interest1 = "Rock Climbing";
	public String interest2 = "Swing Dancing";
	
	public LatLng latLng = new LatLng(0, 0);
	
 
	/* Legacy from Offers code*/
    
	public String title="Unknown User";
	public String title2="";
	public String iconUrl = "http://images.onlinelabels.com/images/clip-art/acspike/acspike_male_user_icon.png";
	public String upForUrl = "assets://gs_icons/icon_chat.png";
	public String discountToCharityString = "Cool things about me discounttocharitystring";
	public String discountToUserString = "0%";

 
	
	}
