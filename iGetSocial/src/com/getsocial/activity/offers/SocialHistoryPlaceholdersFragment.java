package com.getsocial.activity.offers;

import com.getsocial.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



/**
	 * A placeholder fragment containing a simple view.
	 */
	public  class SocialHistoryPlaceholdersFragment extends Fragment
		{
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static SocialHistoryPlaceholdersFragment newInstance(int sectionNumber)
			{
			SocialHistoryPlaceholdersFragment fragment = new SocialHistoryPlaceholdersFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
			}
 
		public SocialHistoryPlaceholdersFragment()
			{
			}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState)
			{
			View rootView = inflater.inflate(R.layout.fragment_socialhistory
					//activity_home,
					,
					container,
					false);
		//	TextView textView = (TextView) rootView
		//			.findViewById(R.id.section_label);
		//	textView.setText(Integer.toString(getArguments().getInt(
		//			ARG_SECTION_NUMBER)));
			return rootView;
			}
		}
