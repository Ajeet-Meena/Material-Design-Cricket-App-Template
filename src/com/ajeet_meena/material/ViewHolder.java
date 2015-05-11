package com.ajeet_meena.material;

import com.ajeet_meena.material.R;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	
	ImageView imageView;
	TextView textView;
	

	public ViewHolder(View row) {
		this.imageView = (ImageView) row.findViewById(R.id.imgAvatar);
		this.textView = (TextView) row.findViewById(R.id.textView);
		// TODO Auto-generated constructor stub
	}

}
