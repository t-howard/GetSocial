package com.getsocial;

import com.getsocial.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.parse.mealspotting.Meal;
import com.parse.mealspotting.NewMealActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SimpleActivity extends Activity
	{

	@Override
	protected void onCreate(Bundle savedInstanceState)
		{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple);
		Button saveButton = ((Button) findViewById(R.id.btnAddMeal));
		saveButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v)
				{
				// Meal meal = ((NewMealActivity)
				// getActivity()).getCurrentMeal();
				ParseUser u = ParseUser.getCurrentUser();
				Meal meal = new Meal();
				// When the user clicks "Save," upload the meal to Parse
				// Add data to the meal object:
				meal.setTitle("Enchiladas");

				// Associate the meal with the current user
				meal.setAuthor(ParseUser.getCurrentUser());

				// Add the rating
				meal.setRating("5");

				// If the user added a photo, that data will be
				// added in the CameraFragment

				// Save the meal and return
				meal.saveInBackground(new SaveCallback()
				{

					@Override
					public void done(ParseException e)
						{
						if (e == null)
							{
							Toast.makeText(getApplicationContext(), "Saved: ",
									Toast.LENGTH_SHORT).show();
							}
						else
							{
							Toast.makeText(getApplicationContext(),
									"Error saving: " + e.getMessage(),
									Toast.LENGTH_SHORT).show();
							}
						}

				});

				}
		});

		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
		{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple, menu);
		return true;
		}

	public void onBtnCreateUser(View view)
		{
		final ParseUser user = new ParseUser();
		user.setUsername("Joe");
		user.setPassword("mypass");
		user.setEmail("joe@example.com");

		// other fields can be set just like with ParseObject
		user.put("phone", "650-555-0000");

		user.signUpInBackground(new SignUpCallback()
		{
			public void done(ParseException e)
				{
				if (e == null)
					{
					int a = 5;
					a++;
					String foo = user.getObjectId();
					ParseUser u = ParseUser.getCurrentUser();
					Toast.makeText(getApplicationContext(), "Saved: ",
							Toast.LENGTH_SHORT).show();
					// Hooray! Let them use the app now.
					}
				else
					{
					int a = 6;
					a++;
					// Sign up didn't succeed. Look at the ParseException
					// to figure out what went wrong
					Toast.makeText(getApplicationContext(),
							"Error saving: " + e.getMessage(),
							Toast.LENGTH_SHORT).show();
					}
				}
		});
		}

	public void onBtnLoginUser(View view)
		{
		ParseUser.logInInBackground("Joe", "mypass", new LogInCallback()
		{
			public void done(ParseUser user, ParseException e)
				{
				if (user != null)
					{
					Toast.makeText(getApplicationContext(), "Logged in: ",
							Toast.LENGTH_SHORT).show();
					}
				else
					{
					Toast.makeText(getApplicationContext(),
							"Error logging in: " + e.getMessage(),
							Toast.LENGTH_SHORT).show();
					}
				}
		});

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
