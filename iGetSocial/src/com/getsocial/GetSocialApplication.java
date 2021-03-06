package com.getsocial;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;


 

import com.getsocial.database.mock.MockDB;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.mealspotting.Meal;

public class GetSocialApplication extends Application
	{
	private static GetSocialApplication singleton;

	public static GetSocialApplication getInstance()
		{
		return singleton; 
		}
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressWarnings("unused")
	@Override
 
	
	public void onCreate()
		{
		singleton = this;
		if (//Config.DEVELOPER_MODE
				//true
				//The app GetSocial has iolated it's self -enforced StrictMode Policy
				false
				&& Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD)
			{
			StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
					.detectAll().penaltyDialog().build());
			StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
					.detectAll().penaltyDeath().build());
			}
		super.onCreate();
		MockDB.getInstance().buildMockDB();
		initImageLoader(getApplicationContext());
		/*
		 * In this tutorial, we'll subclass ParseObject for convenience to
		 * create and modify Meal objects
		 */
		ParseObject.registerSubclass(ParseUser.class);
		ParseObject.registerSubclass(Meal.class);

		/*
		 * Fill in this section with your Parse credentials
		 */
		//Parse.initialize(this, "YOUR_APP_ID", "YOUR_CLIENT_KEY");
		Parse.initialize(this, "8uJKsPD9bcalmjYvEyLnzKmQa791xezrlmYZ87jj", "LFLJ1pwxLBafcS2IeJhZFEf6kuCPT8aJHCxqtlSC");
		
		
		/*
		 * This app lets an anonymous user create and save photos of meals
		 * they've eaten. An anonymous user is a user that can be created
		 * without a username and password but still has all of the same
		 * capabilities as any other ParseUser.
		 * 
		 * After logging out, an anonymous user is abandoned, and its data is no
		 * longer accessible. In your own app, you can convert anonymous users
		 * to regular users so that data persists.
		 * 
		 * Learn more about the ParseUser class:
		 * https://www.parse.com/docs/android_guide#users
		 */
		ParseUser.enableAutomaticUser();

		/*
		 * For more information on app security and Parse ACL:
		 * https://www.parse.com/docs/android_guide#security-recommendations
		 */
		ParseACL defaultACL = new ParseACL();

		/*
		 * If you would like all objects to be private by default, remove this
		 * line
		 */
		//defaultACL.setPublicReadAccess(true);

		ParseACL.setDefaultACL(defaultACL, true);
		}
	public static void initImageLoader(Context context)
		{
		// This configuration tuning is custom. You can tune every option, you
		// may tune some of them,
		// or you can create default configuration by
		// ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				// .writeDebugLogs() // Remove for release app
				.build();
		// Initialize ImageLoader with configuration.
		ImageLoader.getInstance().init(config);
		}
 

	 
	}
