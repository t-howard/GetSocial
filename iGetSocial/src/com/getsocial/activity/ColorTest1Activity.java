package com.getsocial.activity;

import com.getsocial.R;
import com.getsocial.R.id;
import com.getsocial.R.layout;
import com.getsocial.R.menu;
import com.getsocial.util.Toaster;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.parse.mealspotting.Meal;
import com.parse.mealspotting.NewMealActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ColorTest1Activity extends Activity
	{

	Button mBtnOK;
	Button mBtnLeft;
	Button mBtnMiddle;
	Button mBtnRight;
	RelativeLayout mTransparency;

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_color_test_1);
		mBtnLeft = ((Button) findViewById(R.id.btnLeft));
		mBtnMiddle = ((Button) findViewById(R.id.btnMiddle));
		mBtnRight = ((Button) findViewById(R.id.btnRight));
		mBtnOK = ((Button) findViewById(R.id.btnOK));
		mTransparency = ((RelativeLayout) findViewById(R.id.transparentOverlay));
		mBtnLeft.setEnabled(false);
		mBtnMiddle.setEnabled(false);

		mBtnRight.setEnabled(false);
		// saveButton.setOnClickListener(new View.OnClickListener()

		}

	public  void onBtnOK(View v)
		{
		mBtnOK.setVisibility(View.INVISIBLE);
		mTransparency.setVisibility(View.GONE);
		mBtnLeft.setEnabled(true);
		mBtnMiddle.setEnabled(true);
		mBtnRight.setEnabled(true);
		}
	
	public  void onBtnLeft(View v)
		{
		mBtnLeft.setVisibility(View.INVISIBLE);
		}
	public  void onBtnMiddle(View v)
		{
		mBtnMiddle.setVisibility(View.INVISIBLE);
		}
	public  void onBtnRight(View v)
		{
		mBtnRight.setVisibility(View.INVISIBLE);
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
		{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple, menu);
		return true;
		}

	public void onBtnOpenRegister(View view)
		{
		// Toaster.toast("Test");
		// Toaster.notify(this, "User Created");
		Intent i = new Intent(this, RegisterActivity.class);
		startActivity(i);
		}

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
	}
