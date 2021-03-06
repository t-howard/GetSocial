package com.getsocial;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import android.app.AlertDialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.ToneGenerator;

public class CDSApp
	{

	private final static String TAG = CDSApp.class.getSimpleName();

	public static void beep()
		{
		final ToneGenerator tg = new ToneGenerator(
				AudioManager.STREAM_NOTIFICATION, 100);

		tg.startTone(ToneGenerator.TONE_CDMA_CALLDROP_LITE);

		// tg.startTone(ToneGenerator.TONE_PROP_BEEP2);
		}

	public static void reportException(Context ctxt, Exception e, String tag)
		{

		Class<? extends Exception> c = e.getClass();
		String cs = c.getSimpleName();
		String msg = e.getMessage();
		String pss = "";

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		ps.flush();
		ps.close();

		try
			{
			pss = baos.toString("ISO-8859-1"); // e.g. ISO-8859-1

			} catch (Exception ee)
			{
			// ignore encoding excpetion
			}

		new AlertDialog.Builder(ctxt).setTitle("Exception Reported in " + tag)
				.setMessage("Error: " + msg + pss)
				.setNeutralButton("Close", null).show();

		}

	public static void sleep(int i)
		{
		try
			{
			Thread.sleep(i);
			} catch (InterruptedException e)
			{
			// TODO Auto-generated catch block
			// e.printStackTrace();
			}
		}

	}
