package com.getsocial.activity.offers;

import static com.getsocial.example.universalimageloader.Constants.IMAGES;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.getsocial.GSApp;
import com.getsocial.R;
import com.getsocial.activity.offers.PeopleMatchActivity.SectionsPagerAdapter;
import com.getsocial.database.mock.MockDB;
import com.getsocial.example.universalimageloader.Constants;
import com.getsocial.example.universalimageloader.ImagePagerActivity;
import com.getsocial.example.universalimageloader.Constants.Extra;
import com.getsocial.model.proto.GSUser;
import com.getsocial.model.proto.Offer;
import com.getsocial.model.proto.Venue;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class PeopleNearbyListFragment extends Fragment
	{
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static PeopleNearbyListFragment newInstance(int sectionNumber)
		{
		Log.d("OffersNearbyListFragment", "Section Number " + sectionNumber);

		PeopleNearbyListFragment fragment = new PeopleNearbyListFragment();
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

	public PeopleNearbyListFragment()
		{
		}

	public List<GSUser> nearbyUsersList = null;

	private MapView mapView;

	private GoogleMap map;
	int sectionNumber;
	public View rootView = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
		{

		try
			{
			rootView = inflater.inflate(R.layout.fragment_offers_list,
					container, false);
			} catch (Exception e)
			{
			Log.d("OffersNearbyListView", e.getMessage());
			return null;
			}
		;

		// TextView textView = (TextView) rootView
		// .findViewById(R.id.section_label);

		// setContentView(R.layout.activity_map_test);

		imageUrls = (Constants.IMAGES);

		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
				.cacheOnDisc(true).considerExifParams(true)
				.displayer(new RoundedBitmapDisplayer(20)).build();

		ListView listView = (ListView) rootView.findViewById(R.id.offersList);
		// ((ListView) listView).setAdapter(new ItemAdapter());
		// textView.setText(Integer.toString(getArguments().getInt(
		// ARG_SECTION_NUMBER)));
		sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);

		// 1 featured 2 my incentives 3 my charities 4 my merchants 5 nearby

		// toast("Section Number "+ sectionNumber);

		switch (sectionNumber)
			{
		 
			default:
				nearbyUsersList = MockDB.getInstance().getAllUsers();
				break;

			}
		// offersList = MockDB.getInstance().getAllOffers();
		((ListView) listView).setAdapter(new PeopleItemArrayAdapter(this
				.getActivity().getApplicationContext(), nearbyUsersList

		));
		// breaks

		/*
		 * mAdapter = new ToDoItemAdapter(this, R.layout.azure_row_list_to_do);
		 * ListView listViewToDo = (ListView) findViewById(R.id.listViewToDo);
		 * listViewToDo.setAdapter(mAdapter);
		 */
		listView.setOnItemClickListener(new OnItemClickListener()
			{
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id)
					{
					startImagePagerActivity(position);
					}
			});
		/*
		 * ImageButton button = (ImageButton) rootView
		 * .findViewById(R.id.btnMapListSwitch);
		 * 
		 * button.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { toggleMapView(); } });
		 */

		mapView = (MapView) rootView.findViewById(R.id.mapOffers);
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

		for (GSUser u : nearbyUsersList)
			{
			 
				map.addMarker(new MarkerOptions().position(u.latLng)
						.title(u.firstName).snippet(u.interest1 + " " + u.interest2));
				
			}
		// Updates the location and zoom of the MapView
		CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(
				GSApp.getStartingMapLocation(), 
				GSApp.getStartingMapZoom()); 
		map.animateCamera(cameraUpdate);

		return rootView;
		}

	public void showHideMapView(Boolean isShowingMapView)
		{
		View root;
		View v;

		// find the TextView within the current page
		// mCaption = (TextView) mViewPager.findViewById(R.id.caption);
		// SectionsPagerAdapter adapter =
		// (SectionsPagerAdapter)mViewPager.getAdapter();
		root = this.getView();
		
		 
		  
		
	//rootView = LayoutInflater.inflate(R.layout.fragment_offers_list,
		//		container, false);
		// root = f.getView();
		if (root == null)
			return;
		if (isShowingMapView)
			{
			v = root.findViewById(R.id.offersList);
			if (v != null)
				v.setVisibility(View.GONE);
			v = root.findViewById(R.id.mapOffers);
			if (v != null)
				v.setVisibility(View.VISIBLE);
			}
		else
			{
			v = root.findViewById(R.id.offersList);
			if (v != null)
				v.setVisibility(View.VISIBLE);
			v = root.findViewById(R.id.mapOffers);
			if (v != null)
				v.setVisibility(View.GONE);
			}
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

	DisplayImageOptions options;

	String[] imageUrls;

	private void startImagePagerActivity(int position)
		{
		if (true)  // jordan this opened up the old details activity
			return;
		Intent intent = new Intent(getActivity(), OfferDetailsActivity.class);
		GSUser o = nearbyUsersList.get(position);

		intent.putExtra(Extra.CDSID, o.id);
		startActivity(intent);
		}

	private class PeopleItemArrayAdapter extends ArrayAdapter<GSUser>
		{
		private final Context context;
		private final List<GSUser> gsUsers;
		private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

		private class PeopleItemViewHolder
			{
			public TextView title;
			public TextView title2;
			public TextView txtName;
			public TextView txtLocations;
			public TextView txtPctToCharity;

			public ImageView image;
			public ImageView upForImage;
			}

		public PeopleItemArrayAdapter(Context context, List<GSUser> users)
			{
			super(context, R.layout.item_list_people_match, users);
			this.context = context;
			this.gsUsers = users;
			}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
			{
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // not
																		// necessary?
			View rowView = inflater.inflate(R.layout.item_list_people_match, parent,
					false); // not necessary?

			View view = convertView;

			PeopleMatchActivity offersActivity = (PeopleMatchActivity) getActivity();
			PeopleItemViewHolder holder;
			if (convertView == null)
				{
				view = offersActivity.getLayoutInflater().inflate(
						R.layout.item_list_people_match, parent, false);
				holder = new PeopleItemViewHolder();
				holder.title = (TextView) view.findViewById(R.id.txtTitle1);
				holder.title2 = (TextView) view.findViewById(R.id.txtTitle2);
				holder.txtName = (TextView) view.findViewById(R.id.txtName);
				holder.txtLocations = (TextView) view
						.findViewById(R.id.txtLocationsDistance);
				holder.txtPctToCharity = (TextView) view
						.findViewById(R.id.txtDonation);
				holder.image = (ImageView) view.findViewById(R.id.image);
				holder.upForImage = (ImageView)view.findViewById(R.id.image_upfor);
				view.setTag(holder);
				}
			else
				{
				holder = (PeopleItemViewHolder) view.getTag();
				}

			String s;
			s = gsUsers.get(position).iconUrl;
			s = gsUsers.get(position).title;
		//	s = offers.get(position).merchant.iconUrl;

			holder.title.setText("Swing Dancing"); //offers.get(position).title); // title
			holder.title2.setText("Rock Climbing");
			holder.txtName.setText(gsUsers.get(position).firstName);
			//holder.txtLocations.setText("1 mile");
			//holder.txtPctToCharity
			//		.setText(gsUsers.get(position).discountToCharityString);

			offersActivity.imageLoader.displayImage(
					gsUsers.get(position).iconUrl, holder.image, options,
					animateFirstListener);

			
			offersActivity.imageLoader.displayImage(
					gsUsers.get(position).upForUrl, holder.upForImage, options,
					animateFirstListener);
			return view;

			// TextView textView = (TextView) rowView.findViewById(R.id.label);
			// ImageView imageView = (ImageView)
			// rowView.findViewById(R.id.icon);
			// textView.setText(values[position]);
			// change the icon for Windows and iPhone
			// String s = values[position];
			// if (s.startsWith("iPhone"))
			// imageView.setImageResource(R.drawable.no);
			// } else {
			// imageView.setImageResource(R.drawable.ok);
			// }

			// return rowView;
			}
		}

	private static class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener
		{

		static final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage)
			{
			if (loadedImage != null)
				{
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay)
					{
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
					}
				}
			}
		}

	@Override
	public void onDestroyView()
		{
		// rootView = null;
		super.onDestroyView();
		}
	/*
	 * public void onCreate(Bundle savedInstanceState) {
	 * setRetainInstance(true); super.onCreate(savedInstanceState);
	 * setRetainInstance(true); }
	 * 
	 * @Override public void onDestroyView() { //
	 * http://stackoverflow.com/questions
	 * /14565460/error-opening-supportmapfragment-for-second-time
	 * super.onDestroyView(); if (true) return; try { // jordan put this back in
	 * Fragment fragment = null; // = (Fragment) //
	 * getActivity().getFragmentManager() // .findFragmentById(R.id.mapOffers);
	 * if (fragment != null)
	 * getFragmentManager().beginTransaction().remove(fragment) .commit();
	 * 
	 * } catch (IllegalStateException e) { // handle this situation because you
	 * are necessary will get // an exception here :-(
	 * 
	 * // do some kind of log/toast here } }
	 */
	}
