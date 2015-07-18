package com.getsocial;

import java.io.IOException;

import com.getsocial.database.mock.MockDB;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The base implementation of all {@link Activity}s in our app.
 */
public class BaseActivity extends ProtoActivity  
	{
	/**
	 * Some random big number for big request code. This number is deliberately
	 * set to big value so that it does not conflict with any request code value
	 * in sub-activities or sub-fragment.
	 */
	 
	protected MockDB _mockDB = MockDB.getInstance();
  

	public ImageLoader imageLoader = ImageLoader.getInstance();
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.item_clear_memory_cache:
				imageLoader.clearMemoryCache();
				return true;
			case R.id.item_clear_disc_cache:
				imageLoader.clearDiscCache();
				return true;
			default:
				return false;
		}
		
	} */

	

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		 
		super.onCreate(savedInstanceState);
		//getWindow().setFormat(PixelFormat.RGBA_8888);
		//getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
		 
		}
	 

	// android:onClick="mnu10x" android:onClick="mnu1x"

	public boolean mnuPing(MenuItem item)
		{

		return true;
		}

	public boolean mnuReset(MenuItem item)
		{

		return true;
		}

 

	public void tlbHome(View v)
		{
	//	Intent i = new Intent(this, HomeActivity.class);
	//	startActivity(i);
		}
	
	public void tlbWallet(View v)
		{
	//	toast("Open the wallet activity");
		}
	  
	public void tlbOffers(View v)
		{
	//	Intent i = new Intent(this, OffersActivity.class);
	//	startActivity(i);
		}
	
	public void tlbCharities(View v)
		{
	//	Intent i = new Intent(this, OffersActivity.class);
	//	startActivity(i);
		}
	
  
 
  
	

/*	@Override
	public boolean onCreateOptionsMenu(Menu menu)
		{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_cds_common, menu);
		return true;
		}
*/

	protected void greyOutToolbar()
		{
		/*
		Button btn ;
		Drawable top;
		top = getResources().getDrawable(R.drawable.ic_btn_wallet_grey);
		btn = (Button) findViewById(R.id.btnWallet);
		btn.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
		
		top = getResources().getDrawable(R.drawable.ic_btn_home_grey);
		btn = (Button) findViewById(R.id.btnHome);
		btn.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
		
		top = getResources().getDrawable(R.drawable.ic_btn_offers_grey);
		btn = (Button) findViewById(R.id.btnOffers);
		btn.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
		
		top = getResources().getDrawable(R.drawable.ic_btn_charities_grey);
		btn = (Button) findViewById(R.id.btnCharities);
		btn.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
		
		top = getResources().getDrawable(R.drawable.ic_btn_merchants_grey);
		btn = (Button) findViewById(R.id.btnMerchants);
		btn.setCompoundDrawablesWithIntrinsicBounds(null, top , null, null);
		*/
		
		
		
		
		}
	 

	}
