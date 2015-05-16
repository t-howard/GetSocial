package com.cds.consumer.database.mock;

import java.util.ArrayList;
import java.util.List;

import com.cds.consumer.model.proto.*;
import com.google.android.gms.maps.model.LatLng;

public class MockDBHelper
	{

	static public MockDB mockDB = MockDB.getInstance();

	public List<Venue> allVenues = mockDB.getAllVenues();
	public List<Charity> allCharities = mockDB.getAllCharities();
	public List<Merchant> allMerchants = mockDB.getAllMerchants();
	public List<Offer> allOffers = mockDB.getAllOffers();
	int _charityId = 2;
	int _merchantId = 1;
	int _offerId = 2;
	int _venueId = 2;
	Venue _venue;
	Merchant _merchant;
	Charity _charity;
	Offer _offer;

	void buildMockMerchants()
		{

		String defaultMerchantIconUrl = "http://mycodeandlife.files.wordpress.com/2013/01/384088_2317070728022_2086719259_n.jpg";
		String defaultCharityIconUrl = defaultMerchantIconUrl;

		// Uri uri = Uri.parse("android.resource://com.example/" +
		// R.drawable.image); –

		// file:///android_asset/..

		_merchant = new Merchant();

		_merchant.id = _merchantId++;
		_merchant.name = "Any Merchant";
		_merchant.iconUrl = defaultMerchantIconUrl;
		//allMerchants.add(_merchant);  SKIP this one
		
		// --------------------- Encinitas Pizza Company ID=2

		_merchant = new Merchant();

		_merchant.id = _merchantId++;
		_merchant.name = "Encinitas Pizza Company";
		_merchant.iconUrl = getMerchantUrl("encinitaspizzalogo.jpg");
		
		_venue = new Venue();
		_venue.id = _venueId++;
		_venue.parentMerchant = _merchant;
		_venue.name = "Encinitas Pizza Company";

		// Photo
		_venue.address1 = "764 S Coast Highway 101";
		_venue.city = "Encinitas";
		_venue.state = "CA";
		_venue.zipCode = "92024"; // might be wrong
		_venue.phoneNumber = "(760) 943-8620";
		_venue.iconUrl = defaultMerchantIconUrl;
		_venue.latLng = new LatLng(33.042498, -117.293653);
		_venue.websiteUrl = "http://encinitaspizzacompany.com";

		_merchant.nearestVenue = _venue;
		_merchant.nearestVenues.add(_venue);

		allMerchants.add(_merchant);
		

		// ==========================================

		// --------------------- Subway 1 and 2 === ID 3 and 4

		_merchant = new Merchant();

		_merchant.id = _merchantId++;
		_merchant.name = "Subway";
		_merchant.iconUrl = getMerchantUrl("subwaylogo.jpg");
		_venue = new Venue();
		_venue.id = _venueId++;
		_venue.parentMerchant = _merchant;
		_venue.name = _merchant.name;

		_venue.address1 = "6992 El Camino Real";
		_venue.address2 = "West Bluff Plaza Shopping Center";

		_venue.city = "Carlsbad";
		_venue.state = "CA";
		_venue.zipCode = "92009";
		_venue.phoneNumber = "(760) 579-0016";
		_venue.iconUrl = defaultMerchantIconUrl;
		_venue.latLng = new LatLng(33.068511, -117.265309);
		_venue.websiteUrl = "http://subway.com";

		_merchant.nearestVenue = _venue;
		_merchant.nearestVenues.add(_venue);

		_venue = new Venue();
		_venue.id = _venueId++;
		_venue.parentMerchant = _merchant;
		_venue.name = _merchant.name;

		_venue.address1 = "1560 Leucadia Boulevard";

		_venue.city = "Encinitas";
		_venue.state = "CA";
		_venue.zipCode = "92024";
		_venue.phoneNumber = "(760) 579-0016";
		_venue.iconUrl = defaultMerchantIconUrl;
		_venue.latLng = new LatLng(33.103673, -117.266195);
		_venue.websiteUrl = "http://subway.com";
		_merchant.nearestVenue = _venue;
		_merchant.nearestVenues.add(_venue);

		allMerchants.add(_merchant);
		mockDB.getMyMerchants().add(_merchant);

		// ==========================================

		// --------------------- Daphne ID=5

		_merchant = new Merchant();

		_merchant.id = _merchantId++;
		_merchant.name = "Daphne's California Greek";
		_merchant.iconUrl = getMerchantUrl("daphne_logo.jpg");
		_venue = new Venue();
		_venue.id = _venueId++;
		_venue.parentMerchant = _merchant;
		_venue.name = _merchant.name;

		// Photo
		_venue.address1 = "6981 El Camino Real";
		_venue.city = "Carlsbad";
		_venue.state = "CA";
		_venue.zipCode = "92009"; // might be wrong
		_venue.phoneNumber = "(760) 929-0875";
		_venue.iconUrl =  getMerchantUrl("daphne_logo.jpg");
		_venue.latLng = new LatLng(33.102829, -117.267012);
		_venue.websiteUrl = "http://daphnesgreekcafe.com";
		_merchant.nearestVenue = _venue;
		_merchant.nearestVenues.add(_venue);

		allMerchants.add(_merchant);
		mockDB.getMyMerchants().add(_merchant);

		// ==========================================

		}

	void buildMockCharities()
		{

		String defaultMerchantIconUrl = "http://mycodeandlife.files.wordpress.com/2013/01/384088_2317070728022_2086719259_n.jpg";
		String defaultCharityIconUrl = defaultMerchantIconUrl;

		// Uri uri = Uri.parse("android.resource://com.example/" +
		// R.drawable.image); –

		// file:///android_asset/..

		_charity = new Charity();

		_charity.id = _charityId++;
		_charity.name = "Any Charity";
		_charity.iconUrl = defaultCharityIconUrl;
		//allCharities.add(_charity);

		// --------------------- Save the Whales ID=2

		_charity = new Charity();

		_charity.id = _charityId++;
		_charity.name = "Autism Speaks";

		// _charity.parentcharity = _charity;

		// Photo
		_charity.address1 = "764 S Coast Highway 101";
		_charity.city = "Encinitas";
		_charity.state = "CA";
		_charity.zipCode = "92024"; // might be wrong
		_charity.phoneNumber = "(760) 943-8620";
		_charity.iconUrl = getCharityUrl("autism.png");
		_charity.latLng = new LatLng(33.042498, -117.293653);
		_charity.websiteUrl = "http://autismspeaks.org";

		allCharities.add(_charity);

		// ==========================================

		// --------------------- BSA 3 and 4

		_charity = new Charity();

		_charity.id = _charityId++;
		_charity.name = "Boy Scouts of America [National]";

		// _venue.parentcharity = _charity;
		_charity.name = _charity.name;

		_charity.address1 = "6992 El Camino Real";
		_charity.address2 = "West Bluff Plaza Shopping Center";

		_charity.city = "Carlsbad";
		_charity.state = "CA";
		_charity.zipCode = "92009";
		_charity.phoneNumber = "(760) 579-0016";
		_charity.iconUrl = getCharityUrl("bsalogo.jpg");
		_charity.latLng = new LatLng(33.068511, -117.265309);
		_charity.websiteUrl = "http://scouting.org";
		allCharities.add(_charity);

		_charity = new Charity();
		_charity.id = _charityId++;
		// _venue.parentcharity = _charity; Should set here
		_charity.name = "Boy Scouts Troop 776 - Encinitas";

		_charity.address1 = "1560 Leucadia Boulevard";

		_charity.city = "Encinitas";
		_charity.state = "CA";
		_charity.zipCode = "92024";
		_charity.phoneNumber = "(760) 579-0016";
		_charity.iconUrl = getCharityUrl("bsalogo.jpg");
		_charity.latLng = new LatLng(33.103673, -117.266195);
		_charity.websiteUrl = "http://www.bsatroop776.org/";
 
		allCharities.add(_charity);
		mockDB.getMyCharities().add(_charity);
	

		// ==========================================
 
		// --------------------- Susan Komen 5

		_charity = new Charity();

		_charity.id = _charityId++;
		_charity.name = "Susan G. Komen Foundation";

		// _charity.parentcharity = _charity;

		// Photo
		_charity.address1 = "6981 El Camino Real";
		_charity.city = "Carlsbad";
		_charity.state = "CA";
		_charity.zipCode = "92009"; // might be wrong
		_charity.phoneNumber = "(760) 929-0875";
		_charity.iconUrl = getCharityUrl("komen1.jpg");
		_charity.latLng = new LatLng(33.102829, -117.267012);
		_charity.websiteUrl = "http://www.komen.org";

		allCharities.add(_charity);
		mockDB.getMyCharities().add(_charity);

		// ==========================================

		}

	public String getCharityUrl(String assetName)
		{
		return "assets://charity_icons/" + assetName;
		}

	public String getMerchantUrl(String assetName)
		{

		return "assets://merchant_icons/" + assetName;

		}

	void buildMockOffers()
		{

		// Encinitas pizza = 2, Subway 3  , daphnes = 4
		// Save the whales = 2, BSA = 2 and 4, Susan Komen =5

		_offer = new Offer();
		_offer.id = _offerId++;
		_offer.title = "Daphnes Charity Night";
		_offer.title2 = "10% to any charity";
		_offer.discountToCharityString = "10%";
		_offer.merchant = mockDB.getMerchant(4);
		_offer.iconUrl = _offer.merchant.iconUrl;
		_offer.charity = null;
		mockDB.getAllOffers().add(_offer);
		mockDB.getMyOffers().add(_offer);
		mockDB.getOffersMyCharities().add(_offer);
		mockDB.getOffersFeatured().add(_offer);
		mockDB.getOffersMyMerchants().add(_offer);
		
		
		_offer = new Offer();
		_offer.id = _offerId++;
		_offer.title = "Monday Special";
		_offer.title2 = "5% to any charity";
		_offer.discountToCharityString = "5%";
		_offer.merchant = mockDB.getMerchant(2);
		_offer.iconUrl = _offer.merchant.iconUrl;
		_offer.charity = null;
		mockDB.getAllOffers().add(_offer);
		mockDB.getMyOffers().add(_offer);
		mockDB.getOffersMyCharities().add(_offer);
		mockDB.getOffersFeatured().add(_offer); 
		mockDB.getOffersMyMerchants().add(_offer);
		
		_offer = new Offer();
		_offer.id = _offerId++;
		_offer.title = "Tuesday Special";
		_offer.title2 = "10% to Save the whales";
		_offer.discountToCharityString = "10%";
		_offer.merchant = mockDB.getMerchant(2);
		_offer.iconUrl = _offer.merchant.iconUrl;
		_offer.charity = mockDB.getCharity(2);
		mockDB.getAllOffers().add(_offer);
		mockDB.getOffersMyCharities().add(_offer);
		mockDB.getOffersFeatured().add(_offer);
		
		_offer = new Offer();
		_offer.id = _offerId++;
		_offer.title = "Charity Night";
		_offer.title2 = "5% to any charity";
		_offer.discountToCharityString = "5%";
		_offer.merchant = mockDB.getMerchant(3);
		_offer.iconUrl = _offer.merchant.iconUrl;
		_offer.charity = null;
		mockDB.getOffersMyCharities().add(_offer);
		mockDB.getOffersFeatured().add(_offer);
		
		mockDB.getAllOffers().add(_offer);
		
		mockDB.getAllOffers().add(_offer);
		mockDB.getAllOffers().add(_offer);
		mockDB.getAllOffers().add(_offer);
		mockDB.getAllOffers().add(_offer);
		mockDB.getAllOffers().add(_offer);
		mockDB.getAllOffers().add(_offer);
		mockDB.getAllOffers().add(_offer);
		mockDB.getAllOffers().add(_offer); 
		
		//_offer.iconUrl = 
		

		}

	}

/*
 * 
 * 
 * 
 * photoshop cs versus lightroom
 */
