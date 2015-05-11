package com.ajeet_meena.material;


import com.ajeet_meena.material.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by d4ddy-lild4rk on 12/12/14.
 */
public class Standard_Dialog extends DialogFragment implements
		View.OnClickListener {

	private static final String KEY_TITLE = "title";
	
	private TextView dialogTitle;
	
	public static Standard_Dialog newInstance(String title, String message,
			String negativeButton, String positiveButton) {
		Standard_Dialog f = new Standard_Dialog();

		Bundle args = new Bundle();
		args.putString(KEY_TITLE, title);
		
		f.setArguments(args);

		return f;
	}

	public Standard_Dialog() {
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		LayoutInflater inflater = getActivity().getLayoutInflater();
		View dialogView = inflater.inflate(R.layout.layout_dialog, null);

		dialogTitle = (TextView) dialogView.findViewById(R.id.dialogTitle);
		
		
		
		dialogTitle.setText(getArguments().getString(KEY_TITLE));
	

		builder.setView(dialogView);
		Dialog dialog = builder.create();
		dialog.getWindow().getAttributes().windowAnimations = R.style.MyAnimation_Window;

		return dialog;
	}

	@Override
	public void onClick(View v) {
		
		//if (v.getId() == R.id.dialogButtonPositive) {
			//dismiss();
		//}

	}
}