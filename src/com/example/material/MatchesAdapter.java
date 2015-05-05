package com.example.material;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

class MatchesAdapter extends BaseAdapter {
	ArrayList<SingleRowMatches> list;
	Context context;

	MatchesAdapter(Context context) {
		list = new ArrayList<SingleRowMatches>();
		this.context = context;
	}

	void add(SingleRowMatches singleRowMatches) {
		list.add(singleRowMatches);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = convertView;
		ViewHolderMatches holder = null;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.header_vs, parent, false);
			holder = new ViewHolderMatches(row);
			row.setTag(holder);
			
				
			
		}

		else {
			holder = (ViewHolderMatches) row.getTag();
		}
		holder.setColor(list.get(position).getColor());

		return row;
	}

}

class SingleRowMatches {
	String color;

	SingleRowMatches(String color) {
		this.color = color;

	}
	
	String getColor()
	{
		return this.color;
	}
}

class ViewHolderMatches {
	
	LinearLayout linearLayout;
	
	ViewHolderMatches(View row) {
			this.linearLayout = (LinearLayout) row.findViewById(R.id.layout_linear_main);
	}
	
	void setColor(String color)
	{
		this.linearLayout.setBackgroundColor(Color.parseColor(color));
	}
}
