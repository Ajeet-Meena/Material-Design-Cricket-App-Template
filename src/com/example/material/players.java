package com.example.material;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.GridView;

public class players extends ActionBarActivity{
	
	PlayerAdapter adapter;
	GridView gridView;
	SingleRowPlayer player;
	
	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		overridePendingTransition(R.anim.abc_slide_in_top,
				R.anim.abc_slide_out_top);
		setContentView(R.layout.players);
		
		
		
		
		toolbar = (Toolbar) findViewById(R.id.tool_bar4);
		if (toolbar != null)
			setSupportActionBar(toolbar);
		
		toolbar.getBackground().setAlpha(0);
		toolbar.bringToFront();
		toolbar.setSubtitle(Html
				.fromHtml("<font color='#cccccc'>Players</font>"));

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		
		
		gridView = (GridView) findViewById(R.id.gridView1);
		adapter = new PlayerAdapter(this);
		
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		adapter.add(player);
		
		gridView.setAdapter(adapter);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		// closing transition animations
		overridePendingTransition(R.anim.activity_open_scale,
				R.anim.activity_close_translate);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		finish();
		return true;
	}

}
