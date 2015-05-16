package com.getsocial.util;

import com.getsocial.GetSocialApplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Toaster
	{
	private static ProgressDialog pd;

	public static void toast(String s)
		{

		Log.d("Toaster", s);
		Toast.makeText(GetSocialApplication.getInstance(), s,
				Toast.LENGTH_SHORT).show();
		}
	public static void notify(String s)
		{
		new AlertDialog.Builder(GetSocialApplication.getInstance()).setTitle("Notice").setMessage(s)
				.setNeutralButton("Got it", null).show();
		}

	public static void showIndeterminate()
		{
		pd = new ProgressDialog(GetSocialApplication.getInstance());
		pd.setTitle("Processing...");
		pd.setMessage("Please wait.");
		pd.setCancelable(false);
		pd.setIndeterminate(true);
		pd.show();

		}
	public static void notify(Context ctxt, String s)
		{
		new AlertDialog.Builder(ctxt).setTitle("Notice").setMessage(s)
				.setNeutralButton("Got it", null).show();
		}

	public static void showIndeterminate(Context ctxt)
		{
		pd = new ProgressDialog(ctxt);
		pd.setTitle("Processing...");
		pd.setMessage("Please wait.");
		pd.setCancelable(false);
		pd.setIndeterminate(true);
		pd.show();

		}

	public static void hideIndeterminate()
		{
		if (pd != null)
			pd.dismiss();
		pd = null;

		}
	}
