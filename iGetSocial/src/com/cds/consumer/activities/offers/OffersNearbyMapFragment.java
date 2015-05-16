package com.cds.consumer.activities.offers;

import java.util.Properties;

import com.cds.consumer.CDSApp;
import com.getsocial.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class OffersNearbyMapFragment extends Fragment implements
		OnMapClickListener, OnMapLongClickListener
	{
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static OffersNearbyMapFragment newInstance(int sectionNumber)
		{
		OffersNearbyMapFragment fragment = new OffersNearbyMapFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
		}

	public OffersNearbyMapFragment()
		{
		}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
		{
		View rootView = inflater.inflate(R.layout.activity_map_test, container, false);
		// TextView textView = (TextView) rootView
		// .findViewById(R.id.section_label);
		// textView.setText(Integer.toString(getArguments().getInt(
		// ARG_SECTION_NUMBER)));
		
		//setContentView(R.layout.activity_map_test);
		Fragment frag = getFragmentManager().findFragmentById(R.id.mapSolo);
		MapFragment mFrag = (MapFragment) frag;

		_map = mFrag.getMap();

	//	this.log("Indoor Maps enabled? " + _map.isIndoorEnabled());
		_map.setIndoorEnabled(true);
	//	this.log("Indoor Maps enabled? " + _map.isIndoorEnabled());
		_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		_map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(0, 0), 15));
		_map.setMyLocationEnabled(true);
		_map.moveCamera(CameraUpdateFactory.newLatLngZoom(DAPHNES, 12));

		_map.setOnMapClickListener(this);
		_map.setOnMapLongClickListener(this);

		Marker foo = _map.addMarker(new MarkerOptions().position(DAPHNES)
				.title("Daphnes Greek Restaurant"));
		foo = _map.addMarker(new MarkerOptions().position(AVIARA)
				.title("Aviara Golf Course").snippet("Book a Tee Time Now"));
		_map.addMarker(new MarkerOptions().position(SWAMIS).title(
				"Swami's Cafe")

		);
		return rootView;
		}

	static final LatLng HAMBURG = new LatLng(53.558, 9.927);
	static final LatLng KIEL = new LatLng(53.551, 9.993);

	static final String TAG = "MapTestActivity";
	static final LatLng ZKCELLTEST = new LatLng(37.413664, -122.015018);
	static final LatLng GOLF = new LatLng(37.399755, -122.040939);

	static final LatLng DAPHNES = new LatLng(33.102903, -117.267123);
	static final LatLng AVIARA = new LatLng(33.092853, -117.2861);
	static final LatLng SWAMIS = new LatLng(33.046585, -117.257399);

	Bitmap _bmp;
	BitmapDescriptor _image;
	GoogleMap _map;

	private void clearMap()
		{
		if (_map != null)
			{
			_map.clear();
			}

		if (_image != null)
			{
			_image = null;
			}

		if (_bmp != null)
			{
			_bmp.recycle();
			}
		}

 
	 
	
	 

	@Override
	public void onMapClick(LatLng point)
		{
		// tvLocInfo.setText(point.toString());
		_map.animateCamera(CameraUpdateFactory.newLatLng(point));
		}

	@Override
	public void onMapLongClick(LatLng point)
		{
		// tvLocInfo.setText("New marker added@" + point.toString());
		CDSApp.beep();
		_map.addMarker(new MarkerOptions()
				.position(point)
				.title("Foot Marker")
				.snippet("Bilbo was here")
				.icon(BitmapDescriptorFactory
						.fromResource(R.drawable.markersml)));
		}

	public void btnZK(View view)
		{
		Fragment frag = getFragmentManager().findFragmentById(R.id.mapSolo);
		MapFragment mFrag = (MapFragment) frag;

		_map = mFrag.getMap();

		_map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

		_map.setMyLocationEnabled(true);

		// if (true)
		// return;

		// Move the camera instantly to hamburg with a zoom of 15.
		_map.moveCamera(CameraUpdateFactory.newLatLngZoom(SWAMIS, 12));

		// Zoom in, animating the camera.

		/*
		 * _bmp = BitmapFactory
		 * .decodeFile("/sdcard/ZKCellTest/Floorplan/floorsml.png"); _image =
		 * BitmapDescriptorFactory.fromBitmap(_bmp); GroundOverlay groundOverlay
		 * = _map .addGroundOverlay(new GroundOverlayOptions().image(_image) //
		 * .positionFromBounds(bounds) .position(ZKCELLTEST,
		 * 75).transparency((float) 0.2) .bearing(15));
		 */

		_map.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);

		/*
		 * Polyline line = _map.addPolyline(new PolylineOptions()
		 * .add(ZKCELLTEST, GOLF).width(5).color(Color.RED));
		 */
		}

	public void btnAirport(View view)
		{
		Fragment frag = getFragmentManager().findFragmentById(R.id.mapSolo);
		MapFragment mFrag = (MapFragment) frag;

		_map = mFrag.getMap();

		_map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

		// if (true)
		// return;
		// Marker hamburg = _map.addMarker(new MarkerOptions().position(
		// new LatLng(33.64093, -84.425184)).title("ATL Airport"));
		/*
		 * Marker kiel = map.addMarker(new MarkerOptions() .position(GOLF)
		 * .title("Golf") .snippet("Tee Time") .icon(BitmapDescriptorFactory
		 * .fromResource(R.drawable.ic_launcher)));
		 */

		// Move the camera instantly to hamburg with a zoom of 15.
		_map.moveCamera(CameraUpdateFactory.newLatLngZoom(DAPHNES, 10));
		/*
		 * _bmp = BitmapFactory
		 * .decodeFile("/sdcard/ZKCellTest/Floorplan/floorsml.png"); _image =
		 * BitmapDescriptorFactory.fromBitmap(_bmp); GroundOverlay groundOverlay
		 * = _map .addGroundOverlay(new GroundOverlayOptions().image(_image) //
		 * .positionFromBounds(bounds) .position(new LatLng(33.64093,
		 * -84.425184), 75) .transparency((float) 0.2).bearing(0)); // Zoom in,
		 * animating the camera.
		 */
		_map.animateCamera(CameraUpdateFactory.zoomTo(18), 2000, null);
		}
	}
