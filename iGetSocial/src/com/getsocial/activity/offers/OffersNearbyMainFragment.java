package com.getsocial.activity.offers;

import static com.getsocial.example.universalimageloader.Constants.IMAGES;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import com.getsocial.R;
import com.getsocial.example.universalimageloader.Constants;
import com.getsocial.example.universalimageloader.ImagePagerActivity;
import com.getsocial.example.universalimageloader.Constants.Extra;
import com.getsocial.example.universalimageloader.ImageGridActivity.ImageAdapter;
import com.getsocial.example.universalimageloader.ImageGridActivity.ImageAdapter.ViewHolder;

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
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * A placeholder fragment containing a simple view.
 */
public class OffersNearbyMainFragment extends Fragment
	{
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static OffersNearbyMainFragment newInstance(int sectionNumber)
		{
		OffersNearbyMainFragment fragment = new OffersNearbyMainFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
		}

	public OffersNearbyMainFragment()
		{
		}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
		{
		
		View rootView = inflater.inflate(R.layout.ac_image_grid, container,
				false);
		// TextView textView = (TextView) rootView
		// .findViewById(R.id.section_label);
		// textView.setText(Integer.toString(getArguments().getInt(
		// ARG_SECTION_NUMBER)));

		// setContentView(R.layout.activity_map_test);

		imageUrls = (Constants.IMAGES);
		 

	 
		imageUrls = Constants.IMAGES;

		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
				.cacheOnDisc(true).considerExifParams(true)
				.bitmapConfig(Bitmap.Config.RGB_565).build();

		PeopleMatchActivity activity123 = (PeopleMatchActivity) getActivity();
		
		GridView listView = (GridView) rootView.findViewById(R.id.gridview);
		((GridView) listView).setAdapter(new ImageAdapter());
		listView.setOnItemClickListener(new OnItemClickListener()
			{
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id)
					{
					startImagePagerActivity(position);
					}
			});
		options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
				.cacheOnDisc(true).considerExifParams(true)
				.displayer(new RoundedBitmapDisplayer(20)).build();

		 
		return rootView;
		}

	String[] imageUrls;

	DisplayImageOptions options;

	 
	private void startImagePagerActivity(int position)
		{
		Intent intent = new Intent(getActivity(), ImagePagerActivity.class);
		intent.putExtra(Extra.IMAGES, imageUrls);
		intent.putExtra(Extra.IMAGE_POSITION, position);
		startActivity(intent);
		}

	public class ImageAdapter extends BaseAdapter
		{
		@Override
		public int getCount()
			{
			return imageUrls.length;
			}

		@Override
		public Object getItem(int position)
			{
			return null;
			}

		@Override
		public long getItemId(int position)
			{
			return position;
			}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
			{
			 
			PeopleMatchActivity activity123 = (PeopleMatchActivity) getActivity();
			  
			final ViewHolder holder;
			View view = convertView;
			if (view == null)
				{
				view = activity123.getLayoutInflater().inflate(R.layout.item_grid_image,
						parent, false);
				holder = new ViewHolder();
				assert view != null;
				holder.imageView = (ImageView) view.findViewById(R.id.image);
				holder.progressBar = (ProgressBar) view
						.findViewById(R.id.progress);
				view.setTag(holder);
				} else
				{
				holder = (ViewHolder) view.getTag();
				}

			activity123.imageLoader.displayImage(imageUrls[position], holder.imageView,
					options, new SimpleImageLoadingListener()
						{
							@Override
							public void onLoadingStarted(String imageUri,
									View view)
								{
								holder.progressBar.setProgress(0);
								holder.progressBar.setVisibility(View.VISIBLE);
								}

							@Override
							public void onLoadingFailed(String imageUri,
									View view, FailReason failReason)
								{
								holder.progressBar.setVisibility(View.GONE);
								}

							@Override
							public void onLoadingComplete(String imageUri,
									View view, Bitmap loadedImage)
								{
								holder.progressBar.setVisibility(View.GONE);
								}
						}, new ImageLoadingProgressListener()
						{
							@Override
							public void onProgressUpdate(String imageUri,
									View view, int current, int total)
								{
								holder.progressBar.setProgress(Math
										.round(100.0f * current / total));
								}
						});

			return view;
			}

		class ViewHolder
			{
			ImageView imageView;
			ProgressBar progressBar;
			}
		}

	}
