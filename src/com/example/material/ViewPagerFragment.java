package com.example.material;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ViewPagerFragment extends Fragment {
	// private List<SamplePagerItem> mTabs = new ArrayList<SamplePagerItem>();

	ViewPager pager;
	ViewPagerAdapter adapter;
	SlidingTabLayout tabs;
	CharSequence Titles[] = { "DASH BOARD", "COMMENTRY", "LIVE POLLS" };
	int Numboftabs = 3;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// mTabs.add(new SamplePagerItem(0, getString(R.string.tab_one),
		// getResources().getColor(Utils.colors[0]), Color.GRAY));
		// mTabs.add(new SamplePagerItem(1, getString(R.string.tab_two),
		// getResources().getColor(Utils.colors[2]), Color.GRAY));
		// mTabs.add(new SamplePagerItem(2, getString(R.string.tab_three),
		// getResources().getColor(Utils.colors[4]), Color.GRAY));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view =  inflater.inflate(R.layout.viewpager_fragment, container, false);

		adapter = new ViewPagerAdapter(getFragmentManager(), Titles,
				Numboftabs);

		// Assigning ViewPager View and setting the adapter
		 pager = (ViewPager)  view.findViewById(R.id.pager);
		 pager.setAdapter(adapter);

		// Assiging the Sliding Tab Layout View
		tabs = (SlidingTabLayout) view.findViewById(R.id.tabs);
		 tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this
		// true, This makes the tabs Space Evenly in Available width
		 

		// Setting Custom Color for the Scroll bar indicator of the Tab View
		// setting indicator and divider color
		tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

		 @Override
		 public int getIndicatorColor(int position) {
		 return getResources().getColor(R.color.white); //define any color in
		// xml resources and set it here, I have used white
		 }

		 //@Override
		 public int getDividerColor(int position) {
		 return getResources().getColor(R.color.white);
		 }
		 });

		 //Setting the ViewPager For the SlidingTabsLayout
		 tabs.setViewPager(pager);

		return view;
	}

	
}