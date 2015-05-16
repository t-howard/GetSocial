package com.cds.consumer.activities.offers;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.getsocial.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

public class OffersNewMapFragment extends Fragment
	{

	MapView mapView;
	GoogleMap map;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
		{
		View v = inflater.inflate(R.layout.fragment_map, container, false);

		// Gets the MapView from the XML layout and creates it
		mapView = (MapView) v.findViewById(R.id.mapView);
		mapView.onCreate(savedInstanceState);

		// Gets to GoogleMap from the MapView and does initialization stuff
		map = mapView.getMap();
		map.getUiSettings().setMyLocationButtonEnabled(false);
		map.setMyLocationEnabled(true);

		// Needs to call MapsInitializer before doing any CameraUpdateFactory
		// calls
		try
			{
			MapsInitializer.initialize(this.getActivity());
			} catch (GooglePlayServicesNotAvailableException e)
			{
			e.printStackTrace();
			}

		// Updates the location and zoom of the MapView
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
				new LatLng(43.1, -87.9), 10);
		map.animateCamera(cameraUpdate);

		return v;
		}

	@Override
	public void onResume()
		{
		mapView.onResume();
		super.onResume();
		}

	@Override
	public void onDestroy()
		{
		super.onDestroy();
		mapView.onDestroy();
		}

	@Override
	public void onLowMemory()
		{
		super.onLowMemory();
		mapView.onLowMemory();
		}
	private static final String ARG_SECTION_NUMBER = "section_number";
	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static OffersNewMapFragment newInstance(int sectionNumber)
		{
		Log.d("OffersNewMapFragment", "Section Number " + sectionNumber);

		OffersNewMapFragment fragment = new OffersNewMapFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
		}

	public void toast(String s)
		{
		Toast msg = Toast.makeText(getActivity(), s, Toast.LENGTH_LONG);
		msg.show();

		}

	}