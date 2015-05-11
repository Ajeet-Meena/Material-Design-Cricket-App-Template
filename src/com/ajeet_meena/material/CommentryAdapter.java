package com.ajeet_meena.material;

import java.util.ArrayList;

import com.ajeet_meena.material.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

public class CommentryAdapter extends BaseAdapter {

	Context context;
	ArrayList<SingleRowCommentry> list;
	
	CommentryAdapter(Context context)
	{
		list = new ArrayList<SingleRowCommentry>();
		this.context = context;
	}
	
	void add_commentry(SingleRowCommentry singleRowCommentry)
	{
		list.add(singleRowCommentry);
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
		ViewHolderCommentry holder = null;
		if(row==null)
		{
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.commentry_row, parent,
					false);
			holder = new ViewHolderCommentry(row);
			row.setTag(holder);
		}
		
		else
		{
			holder = (ViewHolderCommentry) row.getTag();
		}
		
		row.setAnimation(AnimationUtils.loadAnimation(context,
				R.anim.anim_in));
		
		return row;
		
		
	}

}

class SingleRowCommentry
{
	
}

class ViewHolderCommentry
{

	public ViewHolderCommentry(View row) {
		// TODO Auto-generated constructor stub
	}
	
}