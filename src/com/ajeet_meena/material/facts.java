package com.ajeet_meena.material;

import com.ajeet_meena.material.R;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ListView;

public class facts extends ActionBarActivity {

	ListView listView;
	FactAdapter adapter;
	SingleRowFacts singleRowFacts;

	Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		overridePendingTransition(R.anim.abc_slide_in_bottom,
				R.anim.abc_slide_out_bottom);
		setContentView(R.layout.facts);
		

		toolbar = (Toolbar) findViewById(R.id.tool_bar2);
		if (toolbar != null)
			setSupportActionBar(toolbar);
		toolbar.setSubtitle(Html
				.fromHtml("<font color='#cccccc'>Fast Fun Facts </font>"));
		toolbar.getBackground().setAlpha(0);
		toolbar.bringToFront();

		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);

		listView = (ListView) findViewById(R.id.facts_list);
		adapter = new FactAdapter(this);

		adapter.add(singleRowFacts);
		adapter.add(singleRowFacts);
		adapter.add(singleRowFacts);
		adapter.add(singleRowFacts);
		adapter.add(singleRowFacts);
		adapter.add(singleRowFacts);

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
