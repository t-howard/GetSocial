package com.getsocial.util;

import com.getsocial.GetSocialApplication;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class Toaster
	{
	public static void toast(String s)
		{

		Log.d("Toaster", s);
		Toast.makeText(GetSocialApplication.getInstance(), s,
				Toast.LENGTH_SHORT).show();
		}

	public static void notify(Context ctxt, String s)
		{
		new AlertDialog.Builder(ctxt).setTitle("Notice")
				.setMessage(s)
				.setNeutralButton("Got it", null).show();
		}
	}
