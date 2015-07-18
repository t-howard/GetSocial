package com.getsocial.activity.offers;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
 





import org.json.JSONObject;

import com.getsocial.BaseActivity;
import com.getsocial.R;


/**
 * A splash screen to be displayed when user first opens the app.
 */
public final class OffersFilterActivity extends BaseActivity 
		
	{
	private static final String TAG = OffersFilterActivity.class
			.getSimpleName();
	private static int SPLASH_TIME_OUT = 3000;

	@Override
	public void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_offers_filter);
		/*
		this.greyOutToolbar();
		Button btn ;
		Drawable top;
		top = getResources().getDrawable(R.drawable.ic_btn_home);
		btn = (Button) findViewById(R.id.btnHome);
		btn.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
		*/
	 

		}
	
	}
