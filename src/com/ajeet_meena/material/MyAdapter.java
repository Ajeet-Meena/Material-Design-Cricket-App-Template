package com.ajeet_meena.material;

import java.util.ArrayList;

import com.ajeet_meena.material.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	ArrayList<SingleRow> list;
	Context context;
	int type;

	MyAdapter(Context context, int type) {
		list = new ArrayList<SingleRow>();
		this.context = context;
		this.type = type;
	}

	public void add_row(SingleRow singleRow) {
		list.add(singleRow);

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
		ViewHolder holder = null;
		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			if (type == 0)
				row = inflater.inflate(R.layout.row, parent, false);
			else
				row = inflater.inflate(R.layout.bowling_row, parent, false);

			holder = new ViewHolder(row);
			row.setTag(holder);
			
		}

		else {
			
			holder = (ViewHolder) row.getTag();
		}
		
		TextView textView = (TextView) row.findViewById(R.id.textView);
		
		if(!(position==1||position ==0))
		{
			textView.setAlpha((float).5);
		}
		

		return row;
	}

}
