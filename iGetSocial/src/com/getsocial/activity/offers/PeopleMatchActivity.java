package com.getsocial.activity.offers;

import static com.getsocial.example.universalimageloader.Constants.IMAGES;

import java.util.Locale;

import com.getsocial.BaseActivity;
import com.getsocial.R;
import com.getsocial.example.universalimageloader.ImageGalleryActivity;
import com.getsocial.example.universalimageloader.ImageGridActivity;
import com.getsocial.example.universalimageloader.ImageListActivity;
import com.getsocial.example.universalimageloader.ImagePagerActivity;
import com.getsocial.example.universalimageloader.Constants.Extra;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class PeopleMatchActivity extends BaseActivity implements
		ActionBar.TabListener
	{

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a {@link FragmentPagerAdapter}
	 * derivative, which will keep every loaded fragment in memory. If this
	 * becomes too memory intensive, it may be best to switch to a
	 * {@link android.support.v13.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	public void tlbOffers(View v)
		{
		// Intent i = new Intent(this, CharitiesActivity.class);
		// startActivity(i);
		}

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_offers);

		//this.greyOutToolbar();
		Button btn;
		Drawable top;
		top = getResources().getDrawable(R.drawable.ic_btn_offers);
		//btn = (Button) findViewById(R.id.btnOffers);
		//btn.setCompoundDrawablesWithIntrinsicBounds(null, top, null, null);

		// Set up the action bar.
		final ActionBar actionBar = getActionBar();

		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		// When swiping between different sections, select the corresponding
		// tab. We can also use ActionBar.Tab#select() to do this if we have
		// a reference to the Tab.
		mViewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
					{
						@Override
						public void onPageSelected(int position)
							{
							actionBar.setSelectedNavigationItem(position);
							}
					});

		// For each of the sections in the app, add a tab to the action bar.
		for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++)
			{
			// Create a tab with text corresponding to the page title defined by
			// the adapter. Also specify this Activity object, which implements
			// the TabListener interface, as the callback (listener) for when
			// this tab is selected.
			actionBar.addTab(actionBar.newTab()
					.setText(mSectionsPagerAdapter.getPageTitle(i))
					.setTabListener(this));
			}

		ImageButton button = (ImageButton) // rootView
		findViewById(R.id.btnMapListSwitch);

		button.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
					{
					toggleMapView();
					}
			});

		}

	@Override
	protected void onResume()
		{
		super.onResume();
		showHideMapView();
		// locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
		// 0,
		// 0, this);
		}

	private Boolean isShowingMapView = false;

	private void toggleMapView()
		{
		// OffersActivity act = (OffersActivity) this.getActivity();
		// act.
		toast("Map View Button");

		if (isShowingMapView)
			isShowingMapView = false;
		else
			isShowingMapView = true;
		showHideMapView();
		// findViewById(R.id.offersList).setVisibility(View.GONE);
		// Fragment fragment = (Fragment) getActivity()
		// .getFragmentManager().findFragmentById(
		// R.id.mapOffers);
		}

	public void showHideMapView()
		{
		View root;
		View v;

		if (false)
			return; // jordan fix this

		// find the TextView within the current page
		// mCaption = (TextView) mViewPager.findViewById(R.id.caption);
		SectionsPagerAdapter adapter = (SectionsPagerAdapter) mViewPager
				.getAdapter();

		Fragment f = adapter.getItem(0
		// mViewPager.getCurrentItem()
				);

		PeopleNearbyListFragment of;

		of = (PeopleNearbyListFragment) f;

		if (false)
			{
			of.showHideMapView(isShowingMapView);
			return;
			}
		View foo;

		for (int i = 0; i < mViewPager.getChildCount(); i++)
			{
			foo = mViewPager.getChildAt(i
			// mViewPager.getCurrentItem()
					);
			if (foo == null)
				return;
			root = foo; // .getRootView();
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
					v.setVisibility(View.INVISIBLE);
				}
			}

		}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) {
	 * 
	 * // Inflate the menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 */

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
		{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
			{
			return true;
			}
		return super.onOptionsItemSelected(item);
		}

	@Override
	public void onTabSelected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction)
		{
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
		}

	@Override
	public void onTabUnselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction)
		{
		}

	@Override
	public void onTabReselected(ActionBar.Tab tab,
			FragmentTransaction fragmentTransaction)
		{
		}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter // FragmentStatePagerAdapter
		{

		public SectionsPagerAdapter(FragmentManager fm)
			{
			super(fm);
			}
 
		@Override
		public Fragment getItem(int position)
			{
			// getItem is called to instantiate the fragment for the given page.
			// Return a PlaceholderFragment (defined as a static inner class
			// below).
			 
			if (position == 0) // comment this out to get it to work
				return PeopleNearbyListFragment.newInstance(position + 1); // why
																			// is
			
			if (position > 0)
				return SocialHistoryPlaceholdersFragment.newInstance(position + 1);
			if (true)
				return SocialHistoryPlaceholdersFragment.newInstance(position + 1);
			if (position == 1)
				return PeopleNearbyListFragment.newInstance(position + 1); // why
																			// is
																			// this
																			// different
																			// ?
																			// makes
																			// no
																			// sense
			if (position == 2)
				return OffersNewMapFragment.newInstance(position + 1); // why
																		// is
																		// this
																		// different
																		// ?
																		// makes
																		// no
																		// sense

			return OffersNewMapFragment.newInstance(position + 1);

			// OffersPlaceholderFragment has some mapfragment taht doesnt work
			}

		@Override
		public int getCount()
			{
			 
			return 2;
			}

		@Override
		public CharSequence getPageTitle(int position)
			{
			Locale l = Locale.getDefault();
			switch (position)
				{
				case 0:
					return ("Nearby").toUpperCase(l);
				case 1:
					return ("Social History").toUpperCase(l);
				 
				}
			return null;
			}
		}

	public void btnFilter(View v)
		{
		Intent i = new Intent(this, OffersFilterActivity.class);
		startActivity(i);
		}

	}
