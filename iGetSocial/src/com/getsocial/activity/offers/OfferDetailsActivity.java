package com.getsocial.activity.offers;

import java.util.List;
import java.util.Properties;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.getsocial.GSApp;
import com.getsocial.R;
import com.getsocial.example.universalimageloader.Constants.Extra;
import com.getsocial.model.proto.Offer;
import com.getsocial.model.proto.Venue;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class OfferDetailsActivity extends com.getsocial.BaseActivity
	{

	private static final String STATE_POSITION = "STATE_POSITION";

	DisplayImageOptions options;

	ImageView imageView;

	private MapView mapView;

	private GoogleMap _map;
	Offer _offer;
	
	  
	public void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offer_details);

		Bundle bundle = getIntent().getExtras();
		assert bundle != null;
 
		

		int id = bundle.getInt(Extra.CDSID, 0);
		_offer = this._mockDB.getAllOffers().get(1);
		//ImageAware imageView;
		//
		//String[] imageUrls = bundle.getStringArray(Extra.IMAGES);
		
		ImageView imageView = (ImageView) findViewById(R.id.imageView);
		imageLoader.displayImage(_offer.iconUrl, imageView);
		
		setTV(R.id.txtTitle, _offer.title);
		
		//mapView = (MapView) findViewById(R.id.mapViewOfferDetails);
		
		//mapView.onCreate(savedInstanceState);
		
		
		//_map = mapView.getMap();
		Fragment frag = getFragmentManager().findFragmentById(R.id.mapViewOfferDetails);
		MapFragment mFrag = (MapFragment) frag;

		_map = mFrag.getMap();
		setupMapView(_map);
		
		
/*
		options = new DisplayImageOptions.Builder()
			.showImageForEmptyUri(R.drawable.ic_empty)
			.showImageOnFail(R.drawable.ic_error)
			.resetViewBeforeLoading(true)
			.cacheOnDisc(true)
			.imageScaleType(ImageScaleType.EXACTLY)
			.bitmapConfig(Bitmap.Config.RGB_565)
			.considerExifParams(true)
			.displayer(new FadeInBitmapDisplayer(300))
			.build();
         */
		}
	private void doLoad(String fileName, Properties p)
		{
		
   
		 
		}

	void setupMapView(GoogleMap map)
		{

	

		// Gets to GoogleMap from the MapView and does initialization stuff
		
		map.getUiSettings().setMyLocationButtonEnabled(true);
		map.setMyLocationEnabled(true);

		// Needs to call MapsInitializer before doing any CameraUpdateFactory
		// calls
		 
		try
			{
			MapsInitializer.initialize(this);  // this.getActivity()
			} catch (GooglePlayServicesNotAvailableException e)
			{
			toast(e.getMessage());
			e.printStackTrace();
			}

		
		 
		//_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			 ;	

			 for (Venue vnu : _offer.merchant.nearestVenues)
				 {
				 map.addMarker(new MarkerOptions()
					.position(vnu.latLng)
					.title(_offer.merchant.name)
					.snippet(_offer.title));
				 }
		
				//.icon(BitmapDescriptorFactory
				//		.fromResource(R.drawable.markersml)));
		// Needs to call MapsInitializer before doing any CameraUpdateFactory
		// calls
		
		// Updates the location and zoom of the MapView
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
				//new LatLng(43.1, -87.9), 
				//new LatLng(33.102903,-117.267123), // daphnes
				//_offer.merchant.nearestVenues.get(0).latLng,
				GSApp.getStartingMapLocation(),
				GSApp.getStartingMapZoom());   // was 10
		
		map.animateCamera(cameraUpdate);
		
		}
	}