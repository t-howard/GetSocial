package com.cds.consumer.database.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cds.consumer.model.proto.*;
import com.google.android.gms.maps.model.LatLng;

public class MockDB
	{

	static public MockDB instance = new MockDB();

	

	// static final List<String> displayedImages = Collections
	// .synchronizedList(new LinkedList<String>());
	public List<Venue> getAllVenues()
		{
		return allVenues;
		}

	public void setAllVenues(List<Venue> allVenues)
		{
		this.allVenues = allVenues;
		}

	public List<Charity> getAllCharities()
		{
		return allCharities;
		}

	public void setAllCharities(List<Charity> allCharities)
		{
		this.allCharities = allCharities;
		}

	public List<Merchant> getAllMerchants()
		{
		return allMerchants;
		}

	public void setAllMerchants(List<Merchant> allMerchants)
		{
		this.allMerchants = allMerchants;
		}

	public List<Offer> getAllOffers()
		{
		return allOffers;
		}

	public void setAllOffers(List<Offer> allOffers)
		{
		this.allOffers = allOffers;
		}
	private List<Venue> allVenues = new CopyOnWriteArrayList<Venue>();
	private List<Charity> allCharities = new CopyOnWriteArrayList<Charity>();
	private List<Merchant> allMerchants = new CopyOnWriteArrayList<Merchant>();
	private List<Offer> allOffers = new CopyOnWriteArrayList<Offer>();
	private List<Offer> myOffers = new CopyOnWriteArrayList<Offer>();
	private List<Charity> myCharities = new CopyOnWriteArrayList<Charity>();
	private List<Merchant> myMerchants = new CopyOnWriteArrayList<Merchant>();
	
	private List<Offer> offersMyCharities = new CopyOnWriteArrayList<Offer>();
	private List<Offer> offersMyMerchants = new CopyOnWriteArrayList<Offer>();
	private List<Offer> offersFeatured =  new CopyOnWriteArrayList<Offer>();
	
	public List<Offer> getMyOffers()
		{
		return myOffers;
		}

	public void setMyOffers(List<Offer> myOffers)
		{
		this.myOffers = myOffers;
		}

	int _charityId = 1;
	int _merchantId = 1;
	int _offerId = 1;
	int _venueId = 1;
	Venue _venue;
	Merchant _merchant;
	Charity _charity;
	Offer _offer;

	static public MockDB getInstance()
		{
		return instance;
		}

	public void buildMockDB()
		{
		MockDBHelper helper = new MockDBHelper();
		helper.buildMockMerchants();
		helper.buildMockCharities();
		helper.buildMockOffers();
		}

	public Venue getVenue(int id)
		{
		return getAllVenues().get(id - 2);
		}
	
	public Offer getOffer(int id)
		{
		return getAllOffers().get(id - 2);
		}
	
	public Merchant getMerchant(int id)
		{
		return getAllMerchants().get(id - 2);
		}

	public Charity getCharity(int id)
		{
		List<Charity> list = getAllCharities();
		
		return list.get(id - 2);
		}

	public List<Charity> getMyCharities()
		{
			return myCharities;
		}

	private void setMyCharities(List<Charity> myCharities)
		{
			this.myCharities = myCharities;
		}

	public List<Merchant> getMyMerchants()
		{
			return myMerchants;
		}

	private void setMyMerchants(List<Merchant> myMerchants)
		{
			this.myMerchants = myMerchants;
		}

	public List<Offer> getOffersMyCharities()
		{
			return offersMyCharities;
		}

	public void setOffersMyCharities(List<Offer> offersMyCharities)
		{
			this.offersMyCharities = offersMyCharities;
		}

	public List<Offer> getOffersMyMerchants()
		{
			return offersMyMerchants;
		}

	public void setOffersMyMerchants(List<Offer> offersMyMerchants)
		{
			this.offersMyMerchants = offersMyMerchants;
		}

	public List<Offer> getOffersFeatured()
		{
			return offersFeatured;
		}

	public void setOffersFeatured(List<Offer> offersFeatured)
		{
			this.offersFeatured = offersFeatured;
		}

	}

/*
 * 
 * 
 * 
 * photoshop cs versus lightroom
 */
