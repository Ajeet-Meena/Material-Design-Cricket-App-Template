package com.example.material;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ListView;

public class Matches extends ActionBarActivity {

	MatchesAdapter adapter;
	ListView listView;
	SingleRowMatches singleRowMatches;
	
	
	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		

		super.onCreate(savedInstanceState);
		
		overridePendingTransition(R.anim.anim_in,
				R.anim.anim_out);
		setContentView(R.layout.matches);
		
		SingleRowMatches singleRowMatches1 = new SingleRowMatches("#673ab7");
		SingleRowMatches singleRowMatches2 = new SingleRowMatches("#4caf50");
		singleRowMatches = new SingleRowMatches("#5c6bc0");
		

		toolbar = (Toolbar) findViewById(R.id.tool_bar3);
		if (toolbar != null)
			setSupportActionBar(toolbar);
		toolbar.setSubtitle(Html
				.fromHtml("<font color='#cccccc'>Matches</font>"));

		toolbar.getBackground().setAlpha(0);
		toolbar.bringToFront();
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		listView = (ListView) findViewById(R.id.matches_listView);
		adapter = new MatchesAdapter(this);

		adapter.add(singleRowMatches);
		
		adapter.add(singleRowMatches2);
		adapter.add(singleRowMatches);
		adapter.add(singleRowMatches);
		adapter.add(singleRowMatches1);
		adapter.add(singleRowMatches);

		listView.setAdapter(adapter);
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
