package com.ajeet_meena.material;

import java.util.ArrayList;

import com.ajeet_meena.material.R;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerAdapter extends BaseAdapter{
	
	Context context;
	ArrayList<SingleRowPlayer> list;
	
	PlayerAdapter(Context context)
	{
		list = new ArrayList<SingleRowPlayer>();
		this.context = context;
	}
	
	void add(SingleRowPlayer singleRowPlayer)
	{
		list.add(singleRowPlayer);
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
		ViewHolderPlayer holder = null;
		if(row==null)
		{
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.players_row, parent,
					false);
			holder = new ViewHolderPlayer(row);
			row.setTag(holder);
		}
		
		else
		{
			holder = (ViewHolderPlayer) row.getTag();
		}
		
		row.setAnimation(AnimationUtils.loadAnimation(context,
				R.anim.gridview_anim));
		
		//holder.set_resource(list.get(position).name, list.get(position).image);
		
		return row;
	}
	
	

}

class ViewHolderPlayer
{
	ImageView image;
	TextView text;
	ViewHolderPlayer(View row)
	{
		this.image  = (ImageView) row.findViewById(R.id.imageView_image);
		this.text = (TextView) row.findViewById(R.id.textView1_text);
	}
	
	void set_resource(String text, int image)
	{
		this.image.setImageResource(image);
		this.text.setText(text);
	}
}

class SingleRowPlayer
{
	public String name;
	public int image;
	SingleRowPlayer(String name,int image)
	{
		this.name = name;
		this.image=image;
	}
}
