package com.example.material;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FactAdapter extends BaseAdapter{
	
	Context context;
	ArrayList<SingleRowFacts> list;
	
	
	
	FactAdapter(Context context)
	{
		this.context = context;
		list = new ArrayList<SingleRowFacts>();
	}
	
	void add(SingleRowFacts singleRowFacts)
	{
		list.add(singleRowFacts);
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
		ViewHolderFacts holder = null;
		if(row==null)
		{
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.fact_row, parent,
					false);
			holder = new ViewHolderFacts(row);
			row.setTag(holder);
		}
		
		else
		{
			holder = (ViewHolderFacts) row.getTag();
		}

		row.setAnimation(AnimationUtils.loadAnimation(context,
				R.anim.listview_anim));
		return row;
	}

}

class ViewHolderFacts
{
	TextView textView;
	ViewHolderFacts(View row)
	{
		this.textView = (TextView) row.findViewById(R.id.textView2);
	}
}

class SingleRowFacts
{
	SingleRowFacts()
	{
		
	}
}