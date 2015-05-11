package com.ajeet_meena.material;

import java.util.ArrayList;
import java.util.Currency;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ajeet_meena.material.R;

public class MainActivity extends ActionBarActivity {

	// Declaring Your View and Variables

	Toolbar toolbar;

	private String[] mDrawerTitles;
	private TypedArray mDrawerIcons;
	private ArrayList<Items> drawerItems;
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;
	private static FragmentManager mManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		if (Build.VERSION.SDK_INT >= 21) {
			Window window = this.getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			window.setStatusBarColor(this.getResources()
					.getColor(R.color.brown));
		}

		// Creating The Toolbar and setting it as the Toolbar for the activity
		mManager = getSupportFragmentManager();

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		if (toolbar != null)
			setSupportActionBar(toolbar);
		toolbar.getBackground().setAlpha(0);
		toolbar.bringToFront();
		toolbar.setSubtitle(Html
				.fromHtml("<font color='#cccccc'>BAN vs IND (live)</font>"));

		mDrawerTitles = getResources().getStringArray(R.array.drawer_titles);
		mDrawerIcons = getResources().obtainTypedArray(R.array.drawer_icons);
		drawerItems = new ArrayList<Items>();
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		mDrawerTitles = getResources().getStringArray(R.array.drawer_titles);
		mDrawerIcons = getResources().obtainTypedArray(R.array.drawer_icons);
		drawerItems = new ArrayList<Items>();
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		for (int i = 0; i < mDrawerTitles.length; i++) {
			drawerItems.add(new Items(mDrawerTitles[i], mDrawerIcons
					.getResourceId(i, -(i + 1))));
		}

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		mDrawerLayout, /* DrawerLayout object */
		toolbar, /* nav drawer icon to replace 'Up' caret */
		R.string.facts, /* "open drawer" description */
		R.string.facts/* "close drawer" description */
		) {

			/** Called when a drawer has settled in a completely closed state. */
			public void onDrawerClosed(View view) {
				super.onDrawerClosed(view);

			}

			/** Called when a drawer has settled in a completely open state. */
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);

			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		LayoutInflater inflater = getLayoutInflater();
		final ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header,
				mDrawerList, false);
		mDrawerList.addHeaderView(header, null, true);

		DrawerLayout.LayoutParams lp = (DrawerLayout.LayoutParams) mDrawerList
				.getLayoutParams();
		lp.width = calculateDrawerWidth();
		mDrawerList.setLayoutParams(lp);

		// Set the adapter for the list view
		mDrawerList.setAdapter(new DrawerAdapter(getApplicationContext(),
				drawerItems));
		// Set the list's click listener
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		selectItem(0);

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
		// trySetupSwipeRefresh();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	/* Called whenever we call invalidateOptionsMenu() */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the nav drawer is open, hide action items related to the content
		// view
		

		// menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Swaps fragments in the main content view
	 */
	private void selectItem(final int position) {

		// final String class_name = classes[position];
		mDrawerLayout.closeDrawer(mDrawerList);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				FragmentManager fragmentManager = getSupportFragmentManager();
				if (position == 0) {
					fragmentManager
							.beginTransaction()
							.replace(R.id.content_frame,
									new ViewPagerFragment()).commit();

					return;
				} else if (position == 4) {
					fragmentManager
							.beginTransaction()
							.replace(R.id.content_frame,
									new ViewPagerFragment()).commit();
					showMyDialog("Developer", "", "Cancel", "Sign Out");
					mDrawerLayout.closeDrawer(mDrawerList);
					return;
				} else if (position == 1) {
					Intent ourIntent = new Intent(MainActivity.this,
							Matches.class);
					startActivity(ourIntent);
				} else if (position == 3) {

					Intent ourIntent = new Intent(MainActivity.this,
							facts.class);

					startActivity(ourIntent);

				}

				else if (position == 2) {
					Intent ourIntent = new Intent(MainActivity.this,
							players.class);

					startActivity(ourIntent);
				}

			}
		}, 200);

	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	public int calculateDrawerWidth() {
		// Calculate ActionBar height
		TypedValue tv = new TypedValue();
		int actionBarHeight = 0;
		if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
			actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data,
					getResources().getDisplayMetrics());
		}

		Display display = getWindowManager().getDefaultDisplay();
		int width;

		if (android.os.Build.VERSION.SDK_INT >= 13) {
			Point size = new Point();
			display.getSize(size);
			width = size.x;

		} else {
			width = display.getWidth(); // deprecated
			// deprecated
		}
		return width - actionBarHeight;
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	public static void showMyDialog(String title, String message,
			String negativeButton, String positiveButton) {
		Standard_Dialog newDialog = Standard_Dialog.newInstance(title, message,
				negativeButton, positiveButton);
		newDialog.show(mManager, "dialog");
	}

	public void linkedin(View view) {
		Intent intent;
		try {
			this.getPackageManager().getPackageInfo("com.linkedin.android", 0);
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://in.linkedin.com/in/ajk2rxkamehameha"));
		} catch (Exception e) {
			intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("https://in.linkedin.com/in/ajk2rxkamehameha"));
		}
		startActivity(intent);
	}

	public void github(View view) {
		Intent intent;
		try {
			this.getPackageManager().getPackageInfo("com.github.android", 0);
			intent = new Intent(
					Intent.ACTION_VIEW,
					Uri.parse("https://github.com/Ajk2rxKamehameha/Material-Design-Cricket-App-Template"));
		} catch (Exception e) {
			intent = new Intent(
					Intent.ACTION_VIEW,
					Uri.parse("https://github.com/Ajk2rxKamehameha/Material-Design-Cricket-App-Template"));
		}
		startActivity(intent);
	}

}